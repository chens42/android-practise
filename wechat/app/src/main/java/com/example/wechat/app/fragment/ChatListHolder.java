package com.example.wechat.app.fragment;

import android.view.View;
import android.widget.TextView;

import com.example.wechat.app.R;
import com.example.wechat.app.model.Chats;

/**
 * Created by shaojin on 03/06/14.
 */
public class ChatListHolder {
    TextView name;
    TextView msg;
    TextView date;
    public ChatListHolder(View view) {
        name = (TextView) view.findViewById(R.id.nameFiled);
        msg = (TextView) view.findViewById(R.id.msgField);
        date = (TextView) view.findViewById(R.id.dateFiled);
    }

    public void add(Chats chats) {
        name.setText(chats.getName());
        msg.setText(chats.getMsg());
        date.setText(chats.getDate());

    }
}
