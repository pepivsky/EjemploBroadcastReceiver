package com.pepivsky.ejemplobroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

//clase receiver que recibe el evento del sistema
public class MySystemEventReceiver extends BroadcastReceiver {

    private static final String TAG = MySystemEventReceiver.class.getSimpleName();
// <!--Broadcast que escucha eventos del sistema, no funciona desde Android 8 en adelante, en su lugar hay que usar Context.registerReceiver o usar scheduled jobs-->
    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_AIRPLANE_MODE_CHANGED)) {
            Log.d(TAG, "onReceive: hello from System event reciver airplane mode activated");
            Toast.makeText(context, "Receiver from System event", Toast.LENGTH_SHORT).show();
        }

    }
}
