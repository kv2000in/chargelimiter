package com.example.kv2000in.chargelimiter;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

public class ChargeLimitService extends Service {
    public ChargeLimitService() {

    }

    @Override
    public IBinder onBind(Intent intent) {


        System.out.println("My service has been Bond");

        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //On create of this service either via mainactivity or via boot-completed broadcastreceiver - this service registers
        //another broadcast receiver(chargelimitbroadcastreceiver) - which will be listening to the action-battery-changed broadcasts
        System.out.println("My service has been created");
        BroadcastReceiver br = new ChargeLimitBroadcastReceiver();
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(br, filter);
    }
}