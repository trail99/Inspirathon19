package com.example.myapplication1;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class Notification_receiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager nMan = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent repeatingIntent = new Intent(context, RepeatingActivity.class);

        repeatingIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pd = PendingIntent.getActivity(context, 100, repeatingIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context).setContentIntent(pd).setSmallIcon(android.R.drawable.arrow_up_float)
                .setContentTitle("Notification Title").setContentText("Notification Text").setAutoCancel(true);
        nMan.notify(100, builder.build());
    }
}
