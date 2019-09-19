package com.example.myapplication1;
//package android.database.sqlite;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

//import android.widget.Button;
//import android.widget.EditText;
//
//import com.allyants.notifyme.NotifyMe;
//import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
//import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;
//import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
//
//    Calendar now = Calendar.getInstance();
//    TimePickerDialog tpd;
//    DatePickerDialog dpd;
//    EditText etText, etContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);

    }

//    @Override
//    public void onDateSet(DatePickerDialog view, int year, int month, int day) {
//        now.set(Calendar.YEAR, year);
//        now.set(Calendar.MONTH, month);
//        now.set(Calendar.DAY_OF_MONTH, day);
//        tpd.show(getFragmentManager(), "Timepickerdialog");
//    }
//
//    @Override
//    public void onTimeSet(TimePickerDialog view, int hour, int minute, int sec) {
//        now.set(Calendar.HOUR_OF_DAY, hour);
//        now.set(Calendar.MINUTE, minute);
//        now.set(Calendar.SECOND, sec);
//
//
//        NotifyMe ntfyme = new NotifyMe.Builder(getApplicationContext()).color(255, 0, 0, 255).led_color(255, 255, 255, 255)
//                .time(now).addAction(new Intent(), "Snooze", false)
//                .key("test").addAction(new Intent(), "Dismiss", true, false).addAction(new Intent(), "Done")
//                .large_icon(R.mipmap.ic_launcher_round).build();
//
//    }

    public class Events  {
        private List<Events> listeners =  new ArrayList<Events>();

        public void addListener(Events toAdd) {
            listeners.add(toAdd);
        }

        public void sayHello() {
            System.out.println("Hello");

            for(Events pl : listeners) {
                pl.someOne();
            }
        }
    }

}
