package com.example.elshiekho.myapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class BcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

        if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
            Toast.makeText(context, "Phone Is Ringing", Toast.LENGTH_LONG).show();
        }

        if(state.equals(TelephonyManager.EXTRA_STATE_OFFHOOK)){
            Log.i("ringing","dsadasdads");

        }

        if (state.equals(TelephonyManager.EXTRA_STATE_IDLE)){
            Toast.makeText(context, "Phone Is Idle", Toast.LENGTH_LONG).show();
        }
        Log.i("ahohaaa","fjhjdf");
//        //if(intent.getIntExtra(TelephonyManager.EXTRA_STATE_OFFHOOK,0)==1) {
//            Intent i = new Intent(context, MainActivity.class);
//            context.startActivity(i);
       // }
    }
}
