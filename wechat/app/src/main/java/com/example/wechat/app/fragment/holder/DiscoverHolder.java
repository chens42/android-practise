package com.example.wechat.app.fragment.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wechat.app.R;
import com.example.wechat.app.model.Chat;


public class DiscoverHolder {
    TextView discoverTextView;

    public DiscoverHolder(View view) {
        discoverTextView = (TextView) view.findViewById(R.id.discoverContent);
    }

    public void putIn(Discover discover) {
        discoverTextView.setText(discover.getDescription());
        if (discover.isNew()) {
            discoverTextView.setCompoundDrawablesWithIntrinsicBounds(discover.getImageSource(), 0, R.drawable.ic_indicator_new, 0);
        } else {
            discoverTextView.setCompoundDrawablesWithIntrinsicBounds(discover.getImageSource(), 0, 0, 0);
        }
    }
}
