package com.example.wechat.app.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wechat.app.R;
import com.example.wechat.app.model.Chat;

/**
 * Created by shaojin on 03/06/14.
 */
public class ChatListHolder {
    TextView name;
    TextView msg;
    TextView date;
    ImageView icon;

    public ChatListHolder(View view) {
        name = (TextView) view.findViewById(R.id.nameFiled);
        msg = (TextView) view.findViewById(R.id.msgField);
        date = (TextView) view.findViewById(R.id.dateFiled);
        icon = (ImageView) view.findViewById(R.id.qqIcon);
    }

    public void add(Chat chats) {
        name.setText(chats.getName());
        msg.setText(chats.getMsg());
        date.setText(chats.getDate());
    }
}
