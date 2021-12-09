package com.pepivsky.ejemplobroadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.pepivsky.ejemplobroadcastreceiver.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    // broadcastReceiver dinamico
    DynamicReceiver dynamicReceiver = new DynamicReceiver();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // emision explicita con intent
                Intent intent = new Intent(MainActivity.this, MyFirstReceiver.class);
                // enviando datos con el intent
                Bundle bundle = new Bundle();
                bundle.putString("name", "PP");
                bundle.putInt("age", 24);
                intent.putExtras(bundle);

                sendBroadcast(intent);
            }
        });

        // inner broadcast
        binding.btnInnerBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // explicito
                Intent intent = new Intent(MainActivity.this, MyThirdReceiverInner.class);
                intent.putExtra("dato", "algo");
                sendBroadcast(intent);
            }
        });

        // broadcast implicito, no funciona de Android 8 en adelante
        binding.btnimplicitBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // implcito, se le pasa la accion declarada en el manifest
                Intent intent = new Intent("my.custom.action");
                sendBroadcast(intent); // se envia de forma asincrona pero funciona sobre el hilo principal
            }
        });

        // instanciando el receiver dinamico
        //dynamicReceiver = new DynamicReceiver();
    }

    public static class MyThirdReceiverInner extends BroadcastReceiver {

        private static final String TAG = MyThirdReceiverInner.class.getSimpleName();

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive: Hello from 3rd receiver inner class");
            Toast.makeText(context, "Hello from 3rd receiver inner class", Toast.LENGTH_SHORT).show();
        }
    }

    // aqui se registra el broadcast receiver
    @Override
    protected void onResume() {
        super.onResume();

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED); // se dispara cuando se activa el modo avion

        registerReceiver(dynamicReceiver, intentFilter);

    }

    // aqui se desregistrar el receiver para que no de error al cerrar la app

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(dynamicReceiver);
    }

    /*@Override
    protected void onPause() {
        super.onPause();
        //unregisterReceiver(dynamicReceiver); // se elimina el receiver
    }*/
}