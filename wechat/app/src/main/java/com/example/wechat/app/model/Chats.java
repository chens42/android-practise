package com.example.wechat.app.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Chats implements Parcelable {
    private String name;
    private String msg;
    private String date;
    private boolean isFrend;

    public Chats(String name, String msg, String date, boolean isFrend) {
        this.name = name;
        this.msg = msg;
        this.date = date;
        this.isFrend = isFrend;
    }

    public String getName() {
        return name;
    }

    public String getMsg() {
        return msg;
    }

    public String getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(name);
        parcel.writeString(msg);
        parcel.writeString(date);
    }

    public boolean isFrend() {
        return isFrend;
    }
}
