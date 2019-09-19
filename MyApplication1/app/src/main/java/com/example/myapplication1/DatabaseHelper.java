package com.example.myapplication1;

import android.content.Context;

import java.text.DateFormat;
import java.time.LocalDate;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.sql.SQLData;
import java.time.LocalDate;
import java.util.Calendar;

import static android.icu.lang.UProperty.NAME;
import static android.os.Build.ID;

@RequiresApi(api = Build.VERSION_CODES.O)
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Wills.db";
    public static final String TABLE_UR = "RegTable";
    public static final String TABLE_UT = "UserTrusted";
    public static final String TABLE_UW = "UserWills";
    public static final String TABLE_UA = "UserAuth";

    // Table attributes for Registration
    public static final String RId = "ID";
    public static final String RName = "Name";
    public static final String REm = "Email";
    public static final String RPass = "Password";
    public static final String RPh = "Phone";
    public static final String RDate = "RegistrationDate";

    // Table attributes for UserTrusted
    public static final String TName = "Name";
    public static final String TConNo = "Phone";
    public static final String TRel = "Relationship";

    // Table attributes for UserWills //
    private static final String BrowserPasswords = "Password";

    // Table attributes for UserAuth //
    public static final LocalDate authenticationPeriod = LocalDate.of(2019, 9, 10);


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        //SQLiteDatabase db = this.getWritableDatabase();
    }

    private static final String getDate() {
        //  Get the date of registration from the user and store it in db for periodic authentication
        //String temp = "SELECT GETDATE";
        Calendar cal = Calendar.getInstance();
        String currDate = DateFormat.getDateInstance().format(cal.getTime());
        return currDate;
    }

    private static final String registration = "CREATE TABLE "
            + TABLE_UR + "(" + RId
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + RName + " TEXT," + REm + " TEXT," + RPass + "TEXT," + RPh + " TEXT," + getDate() + "DATE);";

    private static final String trustedUsers = "CREATE TABLE "
            + TABLE_UT + "(" + RId
            + " INTEGER PRIMARY KEY AUTOINCREMENT," + TName + " TEXT," + TConNo + " TEXT," + TRel + "TEXT);";

    private static final String userWills = "CREATE TABLE " + TABLE_UW;


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Registration table is created when db object is created in MainActivity page //
        db.execSQL(registration);
        db.execSQL(trustedUsers);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UR);
        onCreate(db);
    }
}
