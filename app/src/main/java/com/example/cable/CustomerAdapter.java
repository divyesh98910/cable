package com.example.cable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.Viewholde> {

  private com.example.myapplication.CustomerAdapter[] list;

    public CustomerAdapter(com.example.myapplication.CustomerAdapter[] list) {
        this.list = list;
    }

    @NonNull
    @Override
    public com.example.myapplication.CustomerAdapter.Viewholde onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View list=layoutInflater.inflate(R.layout.customeritem,parent,false);
        Viewholde viewhold =new Viewholde(list);
        return viewhold;
    }

    @Override
    public void onBindViewHolder(@NonNull com.example.myapplication.CustomerAdapter.Viewholde holder, int position) {
        holder.tvsubscribername.setText(list[position]);
        holder.tvmobileno.setText(list[position]);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Viewholde extends RecyclerView.ViewHolder {
        TextView tvsubscribername,tvmobileno;

        public Viewholde(@NonNull View itemView) {
            super(itemView);
            this.tvsubscribername=itemView.findViewById(R.id.tvsubscribername);
            this.tvmobileno=itemView.findViewById(R.id.tvmobileno);



        }
    }
}
