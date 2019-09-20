package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    //SQLiteOpenHelper openHelper;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);

        // When user presses the register button, this activates and keeps listening to notify the user of the authentication process (only tje first time)
        // after the first notification is given, thereafter the user has to click on "authorize" button to do the same
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();

                // User gets an alarm every thirty days at 18:00 HRS in the evening //
                cal.set(Calendar.HOUR_OF_DAY, 18);
                cal.set(Calendar.MINUTE, 00);
                cal.set(Calendar.SECOND, 00);


                Intent intent = new Intent(getApplicationContext(), Notification_receiver.class);
                PendingIntent pid = PendingIntent.getBroadcast(getApplicationContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmMan = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmMan.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 720 * 60 * 60 * 1000, pid);

            }
        });
    }

}
