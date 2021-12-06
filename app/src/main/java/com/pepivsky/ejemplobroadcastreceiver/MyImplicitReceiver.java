package com.pepivsky.ejemplobroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyImplicitReceiver extends BroadcastReceiver {

    private static final String TAG = MyImplicitReceiver.class.getSimpleName();

    // recibiendo el broadcast implicito
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: My implicit receiver");
        Toast.makeText(context, "My implicit receiver", Toast.LENGTH_SHORT).show();
    }
}
