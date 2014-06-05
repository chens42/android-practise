package com.example.wechat.app.fragment;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.wechat.app.R;
import com.example.wechat.app.model.Chats;

import java.util.ArrayList;
import java.util.List;

public class ChatsFragment extends Fragment {
    public static final String ARRAY_LIST = "ArrayList";
    private ListView listView;
    ArrayList<Chats> arrayList;
    ChatList adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        listView = (ListView) inflater.inflate(R.layout.webchat_fragment, container, false);
        Bundle bundle = getArguments();
        ArrayList<Parcelable> parcelableArrayList = bundle.getParcelableArrayList(ARRAY_LIST);
        arrayList = new ArrayList<Chats>();

        for (Parcelable parcelable : parcelableArrayList) {
            arrayList.add((Chats) parcelable);
        }
        adapter = new ChatList(getActivity(), R.layout.chat_row, arrayList);
        listView.setAdapter(adapter);
        return listView;
    }

    class ChatList extends ArrayAdapter {
        ChatList(Context context, int resource, List objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            ChatListHolder holder;

            if (row == null) {
                LayoutInflater inflater = getLayoutInflater(getArguments());
                row = inflater.inflate(R.layout.chat_row, parent, false);
                holder = new ChatListHolder(row);
                row.setTag(holder);
            } else {
                holder = (ChatListHolder) row.getTag();
            }

            holder.add(arrayList.get(position));
            return row;
        }
    }
}
