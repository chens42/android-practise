package com.example.wechat.app.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.wechat.app.R;
import com.example.wechat.app.fragment.holder.Discover;
import com.example.wechat.app.fragment.holder.DiscoverHolder;

import java.util.List;

public class DiscoverAdapter extends ArrayAdapter {
    public DiscoverAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        DiscoverHolder holder;

        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.discover_row, parent, false);
            holder = new DiscoverHolder(row);
            row.setTag(holder);
        } else {
            holder = (DiscoverHolder) row.getTag();
        }

        holder.putIn((Discover) getItem(position));
        return row;
    }
}
