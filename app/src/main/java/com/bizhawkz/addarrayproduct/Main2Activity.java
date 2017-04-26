package com.bizhawkz.addarrayproduct;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void broadcastIntent(View view){
        Intent intent = new Intent();
        intent.setAction("com.bizhawkz.addarrayproduct.CUSTOM_INTENT");//this will be Intent Calling
        sendBroadcast(intent);//intent to the BroadcastReciever
    }
}
