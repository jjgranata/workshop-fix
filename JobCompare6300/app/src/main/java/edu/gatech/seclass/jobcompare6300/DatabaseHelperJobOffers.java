package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelperJobOffers extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "joboffers.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_JOB_OFFERS = "job_offers";
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
    public static final String COLUMN_COST_OF_LIVING = "cost_of_living";

    //saving job offers
    private static final String TABLE_CREATE_JOB_OFFERS = "CREATE TABLE " + TABLE_JOB_OFFERS + " (" +
            COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            COLUMN_TITLE + " TEXT, " +
            COLUMN_COMPANY + " TEXT, " +
            COLUMN_YEARLY_SALARY + " REAL, " +
            COLUMN_YEARLY_BONUS + " REAL, " +
            COLUMN_TRAINING + " INTEGER, " +
            COLUMN_CITY + " TEXT, " +
            COLUMN_STATE + " TEXT, " +
            COLUMN_LEAVE_TIME + " INTEGER, " +
            COLUMN_COST_OF_LIVING + " INTEGER, " +
            COLUMN_TELEWORK + " INTEGER);";

    public DatabaseHelperJobOffers(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public String getDatabaseHelperName() {
        return DATABASE_NAME;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_JOB_OFFERS);
        Log.d("DatabaseHelper", "Database created with table: " + TABLE_CREATE_JOB_OFFERS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JOB_OFFERS);
        onCreate(db);
    }
}