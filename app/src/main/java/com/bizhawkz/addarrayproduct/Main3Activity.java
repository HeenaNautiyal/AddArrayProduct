package com.bizhawkz.addarrayproduct;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener{
    MyReceiver myReceiver;
    IntentFilter intentFilter;
    EditText etReceivedBroadcast;
    Button btnSendBroadcast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        etReceivedBroadcast = (EditText) findViewById(R.id.etReceivedBroadcast);
        btnSendBroadcast = (Button) findViewById(R.id.btnSendBroadcast);

        //keep reference to Activity context
        MyApplication myApplication = (MyApplication) this.getApplicationContext();
        myApplication.mainActivity = this;

        btnSendBroadcast.setOnClickListener(this);

        myReceiver = new MyReceiver();
        intentFilter = new IntentFilter("com.hmkcode.android.USER_ACTION");
    }
    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myReceiver, intentFilter);

    }
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myReceiver);
    }


    @Override
    public void onClick(View view) {

        Intent intnet = new Intent("com.hmkcode.android.USER_ACTION");
        sendBroadcast(intnet);

    }
}
