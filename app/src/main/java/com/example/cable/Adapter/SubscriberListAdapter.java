package com.example.cable.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cable.Activity.SubscriberDetailsActivity;
import com.example.cable.Model.Common;
import com.example.cable.Model.Subscriber;
import com.example.cable.R;

import java.util.List;

public class SubscriberListAdapter extends RecyclerView.Adapter<SubscriberListAdapter.ViewHolder> {

    private Context context;
    List<Subscriber> subscriberList;

    public SubscriberListAdapter(Context context, List<Subscriber> subscriberList) {
        this.context = context;
        this.subscriberList = subscriberList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View list = layoutInflater.inflate(R.layout.item_subscriber, parent, false);
        return new ViewHolder(list);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvSubscriberName.setText(subscriberList.get(position).getName());
        holder.tvMobileNo.setText(subscriberList.get(position).getMobileNo());
        holder.itemView.setOnClickListener(view -> context.startActivity(new Intent(context, SubscriberDetailsActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK).putExtra(Common.EXTRA_SUBSCRIBER, subscriberList.get(position))));

    }

    @Override
    public int getItemCount() {
        return subscriberList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSubscriberName, tvMobileNo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvSubscriberName = itemView.findViewById(R.id.tvsubscribername);
            this.tvMobileNo = itemView.findViewById(R.id.tvmobileno);


        }
    }
}
