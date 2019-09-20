package com.example.myapplication1;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class FrontPage extends AppCompatActivity {
    private Button SignUp;
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    EditText UName, FName, Pass, CPass, PNo, Email, DOB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);
        SignUp = (Button)findViewById(R.id.btnSignUp);
        UName = (EditText) findViewById(R.id.etUsername);
        FName = (EditText) findViewById(R.id.editText2);
        Pass = (EditText) findViewById(R.id.et4);
        CPass = (EditText) findViewById(R.id.etConfirmPassword);
        PNo = (EditText) findViewById(R.id.etPhoneNumber);
        Email = (EditText) findViewById(R.id.etEmail);
        DOB = (EditText) findViewById(R.id.etDOB);

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // When user presses the register button, this activates and keeps listening to notify the user of the authentication process (only tje first time)
                // after the first notification is given, thereafter the user has to click on "authorize" button to do the same
                findViewById(R.id.btnSignUp).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        db = openHelper.getWritableDatabase();
                        String uname = UName.getText().toString();
                        String fname = FName.getText().toString();
                        String pass = Pass.getText().toString();
                        String cpass = CPass.getText().toString();
                        String pno = PNo.getText().toString();
                        String email = Email.getText().toString();
                        String dob = DOB.getText().toString();


                        Calendar cal = Calendar.getInstance();

                        // User gets an alarm every thirty days at 18:00 HRS in the evening //
                        cal.set(Calendar.HOUR_OF_DAY, 7);
                        cal.set(Calendar.MINUTE, 59);
                        cal.set(Calendar.SECOND, 00);


                        Intent intent = new Intent(getApplicationContext(), Notification_receiver.class);
                        PendingIntent pid = PendingIntent.getBroadcast(getApplicationContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
                        AlarmManager alarmMan = (AlarmManager) getSystemService(ALARM_SERVICE);
                        alarmMan.setRepeating(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), 30 * 1000, pid);


                        Intent intentd = new Intent(FrontPage.this,MainActivity.class);
                        startActivity(intentd);

                    }
                });



            }
        });
    }
    public void insertdata(String uname, String fname, String pass, String cpass, String email, String pno, String dob) {
        ContentValues cv = new ContentValues();
        cv.put(DatabaseHelper.RUName, UName);
    }
}
