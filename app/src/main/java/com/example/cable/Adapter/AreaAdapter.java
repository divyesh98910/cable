package com.example.cable.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.cable.Model.Area;
import com.example.cable.R;

import java.util.ArrayList;
import java.util.List;

public class AreaAdapter extends BaseAdapter {
    Context context;
    List<Area> areaList;

    public AreaAdapter(Context context, List<Area> areaList) {
        this.context = context;
        this.areaList = new ArrayList<>();
        this.areaList.add(new Area(null, "Select Area"));
        this.areaList.addAll(areaList);
    }

    @Override
    public int getCount() {
        return areaList.size();
    }

    @Override
    public Area getItem(int i) {
        return areaList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.spinner_item, viewGroup, false);
        TextView names = view.findViewById(R.id.text);
        names.setText(areaList.get(i).getAreaName());
        return view;
    }
}
