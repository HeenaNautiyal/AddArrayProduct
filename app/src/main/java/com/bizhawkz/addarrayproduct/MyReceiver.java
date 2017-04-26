package com.bizhawkz.addarrayproduct;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
       // Toast.makeText(context, "Intent Detected.", Toast.LENGTH_LONG).show();//On Recieving the intent
        Main3Activity mainActivity = ((MyApplication) context.getApplicationContext()).mainActivity;
        mainActivity.etReceivedBroadcast.append("broadcast: "+intent.getAction()+"\n");
    }
}

