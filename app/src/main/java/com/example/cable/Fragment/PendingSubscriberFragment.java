package com.example.cable.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.cable.Adapter.AreaAdapter;
import com.example.cable.Adapter.SubscriberListAdapter;
import com.example.cable.Model.Area;
import com.example.cable.Model.Common;
import com.example.cable.Model.Subscriber;
import com.example.cable.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.android.volley.Request.Method.POST;

public class PendingSubscriberFragment extends Fragment {
    View view;
    RecyclerView rvPendingSubscribers;
    Spinner areaSpinner;
    List<Area> areaList;
    private List<Subscriber> subscriberList;
    private SubscriberListAdapter subscriberListAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_current, container, false);
        rvPendingSubscribers = view.findViewById(R.id.rvPendingSubscriber);
        areaSpinner = view.findViewById(R.id.areaSpinner);
        areaList = new ArrayList<>();
        subscriberList = new ArrayList<>();
        subscriberListAdapter = new SubscriberListAdapter(getActivity(), subscriberList);
        rvPendingSubscribers.setHasFixedSize(true);
        rvPendingSubscribers.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvPendingSubscribers.setAdapter(subscriberListAdapter);
        StringRequest areaRequest = new StringRequest(POST, Common.AREA, response -> {
            try {
                JSONObject object = new JSONObject(response);
                JSONArray resultArray = object.getJSONArray("result");
                for (int i = 0; i < resultArray.length(); i++) {
                    JSONObject area = resultArray.getJSONObject(i);
                    areaList.add(new Area(area.getString("a_id"), area.getString("area_name")));
                }
                areaSpinner.setAdapter(new AreaAdapter(getActivity(), areaList));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, error -> Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show());
        Volley.newRequestQueue(getActivity()).add(areaRequest);

        StringRequest subscribersRequest = new StringRequest(POST, Common.SUBSCRIBERS, response -> {
            try {
                JSONObject object = new JSONObject(response);
                JSONArray resultArray = object.getJSONArray("result");
                for (int i = 0; i < resultArray.length(); i++) {
                    JSONObject subscriberObject = resultArray.getJSONObject(i);
                    Subscriber subscriber = new Subscriber();
                    subscriber.setName(subscriberObject.getString("s_name"));
                    subscriber.setMobileNo(subscriberObject.getString("s_mobile_no"));
                    subscriber.setId(subscriberObject.getString("s_id"));
                    subscriber.setAddress(subscriberObject.getString("s_address"));
                    subscriber.setPackageName(subscriberObject.getString("p_name"));
                    subscriber.setPackagePrice(subscriberObject.getString("p_price"));
                    subscriber.setPackageDesc(subscriberObject.getString("p_descri"));
                    subscriber.setAreaName(subscriberObject.getString("area_name"));
                    subscriber.setBoxId(subscriberObject.getString("box_id"));
                    subscriber.setRemainingPrice(subscriberObject.getString("remaining_price"));
                    subscriberList.add(subscriber);
                    subscriberListAdapter.notifyDataSetChanged();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, error -> Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("a_id", ((Area) areaSpinner.getSelectedItem()).getAId());
                return map;
            }
        };

        areaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (((Area) parent.getSelectedItem()).getAId() != null && position != 0) {
                    Volley.newRequestQueue(getActivity()).add(subscribersRequest);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }
}
