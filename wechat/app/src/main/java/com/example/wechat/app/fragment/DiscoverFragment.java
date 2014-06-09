package com.example.wechat.app.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.wechat.app.R;
import com.example.wechat.app.activity.DisplayActivity;
import com.example.wechat.app.activity.QRReader;
import com.example.wechat.app.fragment.holder.Discover;

import java.util.ArrayList;
import java.util.List;

public class DiscoverFragment extends Fragment {

    private ListView listview;
    private DiscoverAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        listview = (ListView) inflater.inflate(R.layout.wechat_fragment, container, false);
        final List<Discover> discoverList = new ArrayList<Discover>();
        Discover discover = new Discover("Moments", false, R.drawable.ic_discover_one);
        discoverList.add(discover);
        discover = new Discover("scan QR Code", false, R.drawable.ic_discover_one);
        discoverList.add(discover);
        discover = new Discover("Shake", false, R.drawable.ic_discover_one);
        discoverList.add(discover);
        discover = new Discover("People Nearby", false, R.drawable.ic_discover_one);
        discoverList.add(discover);
        discover = new Discover("Drift Bottle", false, R.drawable.ic_discover_one);
        discoverList.add(discover);
        discover = new Discover("Games", true, R.drawable.ic_discover_one);
        discoverList.add(discover);
        discover = new Discover("Sticker Gallery", false, R.drawable.ic_discover_one);
        discoverList.add(discover);

        adapter = new DiscoverAdapter(getActivity(), R.layout.discover_row, discoverList);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (discoverList.get(position).getDescription().equals("scan QR Code")) {
                    Intent intent = new Intent(getActivity(), QRReader.class);
                    startActivity(intent);
                }
            }
        });
        listview.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (discoverList.get(position).getDescription().equals("scan QR Code")) {
                    Intent intent = new Intent(getActivity(), QRReader.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return listview;
    }
}
