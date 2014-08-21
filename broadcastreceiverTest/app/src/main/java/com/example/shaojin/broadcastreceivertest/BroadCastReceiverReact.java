package com.example.shaojin.broadcastreceivertest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class BroadCastReceiverReact extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        Toast.makeText(this,"wifi connect",Toast.LENGTH_LONG).show();
    }
}
