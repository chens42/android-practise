package com.example.shaojin.broadcastreceivertest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyInterNetState extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intentOne = new Intent(context, BroadCastReceiverReact.class);
        intentOne.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intentOne);
    }
}