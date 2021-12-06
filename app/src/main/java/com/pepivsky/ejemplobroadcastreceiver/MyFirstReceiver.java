package com.pepivsky.ejemplobroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyFirstReceiver extends BroadcastReceiver {

    private static final String TAG = MyFirstReceiver.class.getSimpleName();

    // aqui se recibe el 1st broadcast receiver, debe estar declarado en el manifest
    // sucede en el hilo principal, por lo que no se deben ejecutar tareas pesadas, para eso es mejor usar service
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: Hello from 1st receiver in thread:" + Thread.currentThread().getName());
        Toast.makeText(context, "Hello from 1st receiver", Toast.LENGTH_SHORT).show();
        
    }
}
