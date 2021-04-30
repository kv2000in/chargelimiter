package com.example.kv2000in.chargelimiter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BatteryManagerBroadcastReceiver extends BroadcastReceiver {
    //This BroadcastReceiver receives the "BOOT_COMPLETED" broadcast and starts the chargelimitservice
    //Chargelimitservice started from the "MainActivity" context - gets destroyed when the activity is exited.
    //Service started via this broadcastreciever method - starts at boot and keeps running.
    //need to add the <uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" /> to manifest
    static final String ACTION = "android.intent.action.BOOT_COMPLETED";
    @Override
    public void onReceive(Context context, Intent intent) {
        //StringBuilder sb = new StringBuilder();
        //sb.append("Action: " + intent.getAction() + "\n");
        //sb.append("URI: " + intent.toUri(Intent.URI_INTENT_SCHEME).toString() + "\n");
        //String log = sb.toString();
        //Log.d(TAG, log);

        if (intent.getAction().equals(ACTION)) {
            //Service
            Intent serviceIntent = new Intent(context, ChargeLimitService.class);
            context.startService(serviceIntent);
        }


            //throw new UnsupportedOperationException("Not yet implemented",);
    }
}
