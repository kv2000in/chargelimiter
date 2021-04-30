package com.example.kv2000in.chargelimiter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;

public class ChargeLimitBroadcastReceiver  extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        //This broadcastreceiver is registered by chargelimitservice. It receives action-battery-changed broadcasts
        //gets the "extra" values coming with the broadcast such as battery level or whether or not device is plugged
        //based on this information, it asks the "networktasks" to execute ON or OFF

    if (intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1)<40){
        System.out.println("Less than 40");

        if (intent.getIntExtra(BatteryManager.EXTRA_PLUGGED,-1)==0) {
            System.out.println("NOT PLUGGED");
            //0 means on battery.  it is not charging so turn it on
            String Command = "ON";
            new NetworkTasks().execute(Command);

        }
    }
    else if (intent.getIntExtra(BatteryManager.EXTRA_LEVEL,-1)>70){

        System.out.println("More than 70");
        if (intent.getIntExtra(BatteryManager.EXTRA_PLUGGED,-1)>0) {
            System.out.println("PLUGGED");
            //0 means on battery. not 0 means it is charging so turn it off
            String Command="OFF";
            new NetworkTasks().execute(Command);
        }

    }
    ;
    }
}
