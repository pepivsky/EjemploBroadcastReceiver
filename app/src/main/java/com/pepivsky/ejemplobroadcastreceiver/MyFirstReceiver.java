package com.pepivsky.ejemplobroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyFirstReceiver extends BroadcastReceiver {

    private static final String TAG = MyFirstReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: Hello from 1st receiver");
        Toast.makeText(context, "Hello from 1st receiver", Toast.LENGTH_SHORT).show();
        
    }
}
