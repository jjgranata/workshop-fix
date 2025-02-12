package edu.gatech.seclass.jobcompare6300;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.jobcompare6300.utility.CurrentJobSingleton;
import edu.gatech.seclass.jobcompare6300.utility.JobOffer;
import edu.gatech.seclass.jobcompare6300.utility.JobOffersSingleton;
import edu.gatech.seclass.jobcompare6300.utility.Location;

public class JobDatabase {
    private SQLiteDatabase database;
    private SQLiteDatabase database_2;
    private DatabaseHelper dbHelper;
    private DatabaseHelperJobOffers dbHelperOffers;

//    private String[] allColumns = {
//            DatabaseHelper.COLUMN_ID,
//            DatabaseHelper.COLUMN_TITLE,
//            DatabaseHelper.COLUMN_COMPANY,
//            DatabaseHelper.COLUMN_YEARLY_SALARY,
//            DatabaseHelper.COLUMN_YEARLY_BONUS,
//            DatabaseHelper.COLUMN_TRAINING,
//            DatabaseHelper.COLUMN_LEAVE_TIME,
//            DatabaseHelper.COLUMN_TELEWORK
//    };

    public JobDatabase(Context context) {
        dbHelper = new DatabaseHelper(context);
        dbHelperOffers = new DatabaseHelperJobOffers(context);
    }

    public void open() throws SQLException {
        database_2 = dbHelper.getWritableDatabase();
        Log.d("JobDAO", "Database opened");
    }

    public void close() {
        dbHelper.close();
        Log.d("JobDAO", "Database closed");
    }

    public long createJob(String title, String company, double yearlySalary, double yearlyBonus, double trainingFunds, int leaveTime, int teleworkDays, String city, String state, int col) {
        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_TITLE, title);
        values.put(DatabaseHelper.COLUMN_COMPANY, company);
        values.put(DatabaseHelper.COLUMN_YEARLY_SALARY, yearlySalary);
        values.put(DatabaseHelper.COLUMN_YEARLY_BONUS, yearlyBonus);
        values.put(DatabaseHelper.COLUMN_TRAINING, trainingFunds);
        values.put(DatabaseHelper.COLUMN_LEAVE_TIME, leaveTime);
        values.put(DatabaseHelper.COLUMN_TELEWORK, teleworkDays);
        values.put(DatabaseHelper.COLUMN_CITY, city);
        values.put(DatabaseHelper.COLUMN_STATE, state);
        values.put(DatabaseHelper.COLUMN_COL, col);

        try {
            long insertId = database_2.insert(DatabaseHelper.TABLE_JOBS, null, values);
            Log.d("JobDAO", "Job created with id: " + insertId);
            return insertId;
        } catch (Exception e) {
            Log.e("JobDAO", "Error inserting data", e);
            return -1;
        }

    }

    public long createJobOffer(String id, String title, String company, double yearlySalary, double yearlyBonus, double trainingFunds, int leaveTime, int teleworkDays, String city, String state, int COL) {
        ContentValues values = new ContentValues();
        values.put(dbHelperOffers.COLUMN_ID, id);
        values.put(dbHelperOffers.COLUMN_TITLE, title);
        values.put(dbHelperOffers.COLUMN_COMPANY, company);
        values.put(dbHelperOffers.COLUMN_YEARLY_SALARY, yearlySalary);
        values.put(dbHelperOffers.COLUMN_YEARLY_BONUS, yearlyBonus);
        values.put(dbHelperOffers.COLUMN_TRAINING, trainingFunds);
        values.put(dbHelperOffers.COLUMN_LEAVE_TIME, leaveTime);
        values.put(dbHelperOffers.COLUMN_TELEWORK, teleworkDays);
        values.put(dbHelperOffers.COLUMN_CITY, city);
        values.put(dbHelperOffers.COLUMN_STATE, state);
        values.put(dbHelperOffers.COLUMN_COST_OF_LIVING, COL);

        try {
            long insertId = database.insert(dbHelperOffers.TABLE_JOB_OFFERS, null, values);
            Log.d("JobDAO", "Job created with id: " + insertId);
            return insertId;
        } catch (Exception e) {
            Log.e("JobDAO", "Error inserting data", e);
            return -1;
        }

    }

    public void deleteJobOffer(String id) {

        try {
            database.execSQL("DELETE FROM "+ DatabaseHelperJobOffers.TABLE_JOB_OFFERS +
                    " WHERE " + DatabaseHelperJobOffers.COLUMN_ID + " = " + id);
            Log.d("JobDAO", "Job deleted with id: " + id);
        } catch (Exception e) {
            Log.e("JobDAO", "Error deleting data", e);
        }
    }


    public void openoffers() throws SQLException {
        database = dbHelperOffers.getWritableDatabase();
        Log.d("JobDAO", "Database opened");
    }

    public void closeoffers() {
        dbHelperOffers.close();
        Log.d("JobDAO", "Database closed");
    }


    public List<JobOffer> getAllJobOffers() {
        List<JobOffer> jobOffers = new ArrayList<>();
        Cursor cursor = database.query(DatabaseHelperJobOffers.TABLE_JOB_OFFERS, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                JobOffer jobOffer = cursorToJobOffer(cursor);
                jobOffers.add(jobOffer);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return jobOffers;
    }

    public List<JobOffer> getCurrentJobOffer() {
        List<JobOffer> jobOffers = new ArrayList<>();
        Cursor cursor = database_2.query(DatabaseHelper.TABLE_JOBS, null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
              JobOffer jobOffer = cursorToJobOffer_2(cursor);
                jobOffers.add(jobOffer);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return jobOffers;
    }

//        public JobOffer getJobOfferById(String id) {
//            Cursor cursor = database.query(DatabaseHelperJobOffers.TABLE_JOB_OFFERS, null,
//                    DatabaseHelperJobOffers.COLUMN_ID + "=?", new String[]{id}, null, null, null);
//
//            JobOffer jobOffer = null;
//            if (cursor != null && cursor.moveToFirst()) {
//                jobOffer = cursorToJobOffer(cursor);
//                cursor.close();
//            }
//            return jobOffer;
//        }
//
//    public boolean updateJobOffer(String id, JobOffer updatedJobOffer) {
//        ContentValues values = new ContentValues();
//        values.put(DatabaseHelperJobOffers.COLUMN_TITLE, updatedJobOffer.getTitle());
//        values.put(DatabaseHelperJobOffers.COLUMN_COMPANY, updatedJobOffer.getCompany());
//        values.put(DatabaseHelperJobOffers.COLUMN_YEARLY_SALARY, updatedJobOffer.getYearlySalary());
//        values.put(DatabaseHelperJobOffers.COLUMN_YEARLY_BONUS, updatedJobOffer.getYearlyBonus());
//        values.put(DatabaseHelperJobOffers.COLUMN_TRAINING, updatedJobOffer.getTrainingFund());
//        values.put(DatabaseHelperJobOffers.COLUMN_LEAVE_TIME, updatedJobOffer.getLeaveTime());
//        values.put(DatabaseHelperJobOffers.COLUMN_TELEWORK, updatedJobOffer.getTeleworkDaysPerWeek());
//        values.put(DatabaseHelperJobOffers.COLUMN_CITY, updatedJobOffer.getCity());
//        values.put(DatabaseHelperJobOffers.COLUMN_STATE, updatedJobOffer.getState());
//        values.put(DatabaseHelperJobOffers.COLUMN_COST_OF_LIVING, updatedJobOffer.getColIndex());
//        // Add any other fields that need to be updated
//
//        int rowsAffected = database.update(DatabaseHelperJobOffers.TABLE_JOB_OFFERS, values,
//                DatabaseHelperJobOffers.COLUMN_ID + "=?", new String[]{id});
//
//        if (rowsAffected > 0) {
//            // Update the JobOffersSingleton
//            JobOffersSingleton.getInstance().updateJobOffer(id, updatedJobOffer);
//        }
//
//        return rowsAffected > 0;
//    }
        private JobOffer cursorToJobOffer(Cursor cursor) {
            @SuppressLint("Range") String id = cursor.getString(cursor.getColumnIndex(DatabaseHelperJobOffers.COLUMN_ID));
            @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex(DatabaseHelperJobOffers.COLUMN_TITLE));
            @SuppressLint("Range") String company = cursor.getString(cursor.getColumnIndex(DatabaseHelperJobOffers.COLUMN_COMPANY));
            @SuppressLint("Range") double yearlysalary = cursor.getDouble(cursor.getColumnIndex(DatabaseHelperJobOffers.COLUMN_YEARLY_SALARY));
            @SuppressLint("Range") double training = cursor.getDouble(cursor.getColumnIndex(DatabaseHelperJobOffers.COLUMN_TRAINING));
            @SuppressLint("Range") int leavetime = cursor.getInt(cursor.getColumnIndex(DatabaseHelperJobOffers.COLUMN_LEAVE_TIME));
            @SuppressLint("Range") int telework = cursor.getInt(cursor.getColumnIndex(DatabaseHelperJobOffers.COLUMN_TELEWORK));

            @SuppressLint("Range") String city = cursor.getString(cursor.getColumnIndex(DatabaseHelperJobOffers.COLUMN_CITY));
            @SuppressLint("Range") String state = cursor.getString(cursor.getColumnIndex(DatabaseHelperJobOffers.COLUMN_STATE));
            @SuppressLint("Range") int costofliving = cursor.getInt(cursor.getColumnIndex(DatabaseHelperJobOffers.COLUMN_COST_OF_LIVING));
            @SuppressLint("Range") double bonus = cursor.getInt(cursor.getColumnIndex(DatabaseHelperJobOffers.COLUMN_YEARLY_BONUS));

            return new JobOffer(id, title, company, city, state, costofliving, yearlysalary, bonus, training, leavetime, telework);

        }

        private JobOffer cursorToJobOffer_2(Cursor cursor) {
            @SuppressLint("Range") String id = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_ID));
            @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_TITLE));
            @SuppressLint("Range") String company = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_COMPANY));
            @SuppressLint("Range") double yearlysalary = cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.COLUMN_YEARLY_SALARY));
            @SuppressLint("Range") double training = cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.COLUMN_TRAINING));
            @SuppressLint("Range") int leavetime = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_LEAVE_TIME));
            @SuppressLint("Range") int telework = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_TELEWORK));

            @SuppressLint("Range") String city = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_CITY));
            @SuppressLint("Range") String state = cursor.getString(cursor.getColumnIndex(DatabaseHelper.COLUMN_STATE));
            @SuppressLint("Range") int costofliving = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_COL));
            @SuppressLint("Range") double bonus = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.COLUMN_YEARLY_BONUS));

            return new JobOffer(id, title, company, city, state, costofliving, yearlysalary, bonus, training, leavetime, telework);
        }
}
