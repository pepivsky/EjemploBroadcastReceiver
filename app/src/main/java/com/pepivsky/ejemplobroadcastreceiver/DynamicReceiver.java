package com.pepivsky.ejemplobroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class DynamicReceiver extends BroadcastReceiver {

    private static final String TAG = DynamicReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: Hello from Dynamic receiver in thread:" + Thread.currentThread().getName());
        Toast.makeText(context, "Dynamic receiver", Toast.LENGTH_LONG).show();
    }
}
