package com.example.wechat.app.fragment.adapter;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.wechat.app.activity.DisplayActivity;
import com.example.wechat.app.fragment.ChatsFragment;
import com.example.wechat.app.fragment.DiscoverFragment;
import com.example.wechat.app.fragment.ContactsFragment;
import com.example.wechat.app.model.Chats;

import java.util.ArrayList;

public class TabsPagerAdapter extends FragmentPagerAdapter {
    private ChatsFragment chatsFragment;
    private DiscoverFragment discoverFragment;
    private ContactsFragment contactsFragment;
    private ArrayList<Chats> chatList = new ArrayList<Chats>();

    public TabsPagerAdapter(FragmentManager fm) {
        super(fm);
        Chats chats = new Chats("wen", "hello world", "06/06/2013", true);
        chatList.add(chats);
        chatList.add(chats);
        chatList.add(chats);
        chatList.add(chats);
        chatList.add(chats);
        chatList.add(chats);
        chatList.add(chats);
        chats = new Chats("wen", "hello world", "06/06/2013", false);
        chatList.add(chats);
        chatList.add(chats);
        chatList.add(chats);
        chatList.add(chats);
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {

        switch (position) {
            case 0:
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList(ChatsFragment.ARRAY_LIST, chatList);
                chatsFragment = new ChatsFragment();
                chatsFragment.setArguments(bundle);
                return chatsFragment;
            case 1:
                if (discoverFragment == null) {
                    discoverFragment = new DiscoverFragment();
                }
                return discoverFragment;
            case 2:
                if (contactsFragment == null) {
                    contactsFragment = new ContactsFragment();
                }
                return contactsFragment;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
