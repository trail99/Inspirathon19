package com.example.myapplication1;

import android.content.Intent;
import android.widget.EditText;

import androidx.fragment.app.FragmentActivity;

import android.app.*;
import com.allyants.notifyme.NotifyMe;
import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;
import java.util.Calendar;

public class Events implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    Calendar now = Calendar.getInstance();
    TimePickerDialog tpd;
    DatePickerDialog dpd;
    EditText etText, etContent;
    FragmentActivity ac = new FragmentActivity();
    
    @Override
    public void onDateSet(DatePickerDialog view, int year, int month, int day) {
        now.set(Calendar.YEAR, year);
        now.set(Calendar.MONTH, month);
        now.set(Calendar.DAY_OF_MONTH, day);
        tpd.show(ac.getSupportFragmentManager(), "Timepickerdialog");
    }

    @Override
    public void onTimeSet(TimePickerDialog view, int hour, int minute, int sec) {
        now.set(Calendar.HOUR_OF_DAY, hour);
        now.set(Calendar.MINUTE, minute);
        now.set(Calendar.SECOND, sec);


        NotifyMe ntfyme = new NotifyMe.Builder(ac.getApplicationContext()).color(255, 0, 0, 255).led_color(255, 255, 255, 255)
                .time(now).addAction(new Intent(), "Snooze", false)
                .key("test").addAction(new Intent(), "Dismiss", true, false).addAction(new Intent(), "Done")
                .large_icon(R.mipmap.ic_launcher_round).build();

    }
}

// Should take care of the date and time events of the application
// When the period date is reached, the application should issue a notification to the user to authenticate himself/herself,
// so as to prevent lockdown

//public class Events  {
//    private List<PeriodListener> listeners =  new ArrayList<PeriodListener>();
//
//    public void addListener(PeriodListener toAdd) {
//        listeners.add(toAdd);
//    }
//
//    public void sayHello() {
//        System.out.println("Hello");
//
//        for(PeriodListener pl : listeners) {
//            pl.someOne();
//        }
//    }
//}

