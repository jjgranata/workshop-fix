package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.jobcompare6300.utility.JobOffer;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "jobListings.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_JOBS = "jobs";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TITLE = "title";
    public static final String COLUMN_COMPANY = "company";
    public static final String COLUMN_YEARLY_SALARY = "yearly_salary";
    public static final String COLUMN_YEARLY_BONUS = "yearly_bonus";
    public static final String COLUMN_TRAINING = "training_funds";
    public static final String COLUMN_LEAVE_TIME = "leave_time";
    public static final String COLUMN_TELEWORK = "telework_days";
    public static final String COLUMN_CITY = "city";
    public static final String COLUMN_STATE = "state";
    public static final String COLUMN_COL = "cost_of_living";

    //saving jobs
    private static final String TABLE_CREATE =
            "CREATE TABLE " + TABLE_JOBS + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_TITLE + " TEXT, " +
                    COLUMN_COMPANY + " TEXT, " +
                    COLUMN_YEARLY_SALARY + " REAL, " +
                    COLUMN_YEARLY_BONUS + " REAL, " +
                    COLUMN_TRAINING + " INTEGER, " +
                    COLUMN_LEAVE_TIME + " INTEGER, " +
                    COLUMN_COL + " INTEGER, " +
                    COLUMN_CITY + " TEXT, " +
                    COLUMN_STATE + " TEXT, " +
                    COLUMN_TELEWORK + " INTEGER);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public String getDatabaseHelperName() {
        return DATABASE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        Log.d("DatabaseHelper", "Database created with table: " + TABLE_JOBS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOBS);
        onCreate(db);
    }
}