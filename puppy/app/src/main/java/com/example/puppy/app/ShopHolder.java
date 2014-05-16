package com.example.puppy.app;

import android.view.View;
import android.widget.TextView;

/**
 * Created by shaojin on 16/05/14.
 */
public class ShopHolder {
    TextView identify;
    TextView name;
    TextView email;
    TextView address;
    TextView gender;
    TextView mobile;
    TextView home;
    TextView office;
    public ShopHolder(View view) {
        identify=(TextView) view.findViewById(R.id.identify);
        name=(TextView) view.findViewById(R.id.name);
        email=(TextView) view.findViewById(R.id.email);
        address=(TextView) view.findViewById(R.id.address);
        gender=(TextView) view.findViewById(R.id.gender);
        mobile=(TextView) view.findViewById(R.id.mobile);
        home=(TextView) view.findViewById(R.id.home);
        office=(TextView) view.findViewById(R.id.office);

    }

    public void add(RowInfo rowInfo) {
        identify.setText("id:"+rowInfo.getId());
        name.setText("name:"+rowInfo.getName());
        email.setText("email:"+rowInfo.getEmail());
        address.setText("address:"+rowInfo.getAddress());
        gender.setText("gender:"+rowInfo.getGender());
        mobile.setText("mobile phone:"+rowInfo.getMobilePhone());
        home.setText("home phone:"+rowInfo.getHomePhone());
        office.setText("office phone:"+rowInfo.getOfficePhone());

    }
}
