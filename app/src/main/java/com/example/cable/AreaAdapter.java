package com.example.cable;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AreaAdapter extends BaseAdapter {
    Context context;
    List<String> categories;

    public AreaAdapter(Context context) {
        this.context = context;
        this.categories = new ArrayList<>();
        this.categories.add("Select Item Type");
        this.categories.add("area");
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public String getItem(int i) {
        return categories.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.spinner_item, viewGroup, false);
        TextView names = view.findViewById(R.id.text);
        names.setText(categories.get(i));
        return view;
    }
}
