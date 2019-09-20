package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {
    //SQLiteOpenHelper openHelper;
    DatabaseHelper db;
    private EditText name;
    private EditText password;
    private Button login;
    private TextView attempt;
    private TextView newUser;
    private int counter = 5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.etName);
        password = (EditText) findViewById(R.id.et4);
        login = (Button) findViewById(R.id.btnLogin);
        attempt = (TextView) findViewById(R.id.tvAttempts);
        newUser = (TextView) findViewById(R.id.tvNew);

        db = new DatabaseHelper(this);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(name.getText().toString(), password.getText().toString());
            }
        });

        newUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FrontPage.class);
                startActivity(intent);
            }
        });

    }

    private void validate(String userName, String userPassword) {
        if ((userName.equals("admin")) && (userPassword.equals("12345"))) {
            Intent intent = new Intent(MainActivity.this, HomePage.class);
            startActivity(intent);
        } else {
            counter--;
            if (counter == 0) {
                login.setEnabled(false);
            }
            attempt.setText("Attemps Remaining: "+ String.valueOf(counter));
        }
    }

}
