package com.example.wechat.app.fragment;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.wechat.app.R;
import com.example.wechat.app.fragment.holder.ChatListHolder;
import com.example.wechat.app.model.Chat;

import java.util.ArrayList;
import java.util.List;

public class ChatsFragment extends Fragment {
    public static final String CHAT_ARRAY_LIST = "ChatArrayList";
    private View rootView;
    private ListView listView;
    private ArrayList<Chat> arrayList;
    private ChatList adapter;
    private View chatsLoaderLinearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.wechat_fragment, container, false);
        Bundle bundle = getArguments();
        ArrayList<Parcelable> parcelableArrayList = bundle.getParcelableArrayList(CHAT_ARRAY_LIST);
        arrayList = new ArrayList<Chat>();

        for (Parcelable parcelable : parcelableArrayList) {
            arrayList.add((Chat) parcelable);
        }
        listView = (ListView) rootView.findViewById(R.id.display);
        adapter = new ChatList(getActivity(), R.layout.chat_row, arrayList);
        chatsLoaderLinearLayout =  inflater.inflate(R.layout.chats_loader, null);
        listView.addFooterView(chatsLoaderLinearLayout);
        listView.setAdapter(adapter);
        return rootView;
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
            if (position == (arrayList.size() - 1)) {
                new LoadData().execute();
            }
            return row;
        }
    }

    class LoadData extends AsyncTask<Void, Void, ArrayList<Chat>> {
        @Override
        protected void onPreExecute() {
            chatsLoaderLinearLayout.setVisibility(View.VISIBLE);
        }

        @Override
        protected ArrayList<Chat> doInBackground(Void... params) {
            SystemClock.sleep(5000);
            ArrayList<Chat> chatList = new ArrayList<Chat>();
            Chat chats = new Chat("wen", "hello world", "06/06/2013", true);
            chatList.add(chats);
            chatList.add(chats);
            chatList.add(chats);
            chatList.add(chats);
            chatList.add(chats);
            chatList.add(chats);
            chatList.add(chats);
            chats = new Chat("wen", "hello world", "06/06/2013", false);
            chatList.add(chats);
            chatList.add(chats);
            chatList.add(chats);
            chatList.add(chats);
            return chatList;
        }

        @Override
        protected void onPostExecute(ArrayList<Chat> chats) {
            chatsLoaderLinearLayout.setVisibility(View.INVISIBLE);
            arrayList.addAll(chats);
            adapter.notifyDataSetChanged();
        }
    }
}
