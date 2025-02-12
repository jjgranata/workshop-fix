package edu.gatech.seclass.jobcompare6300;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class DatabaseHelperJobOffersTest {

    private static int database_COLUMN_ID;
    private static String database_COLUMN_TITLE;
    private static String database_COLUMN_COMPANY;
    private static int database_COLUMN_YEARLY_SALARY;
    private static int database_COLUMN_YEARLY_BONUS;
    private static int database_COLUMN_TRAINING;
    private static int database_COLUMN_LEAVE_TIME;
    private static int database_COLUMN_TELEWORK;

    @Test
    public void ShouldCreateAndDropDatabase() {
        DatabaseHelperJobOffers databaseHelperJobOffers = new DatabaseHelperJobOffers(InstrumentationRegistry.getInstrumentation().getTargetContext());
        SQLiteDatabase sql = databaseHelperJobOffers.getWritableDatabase();
        assertTrue(sql.isOpen());
        sql.close();
        boolean isDropped = InstrumentationRegistry.getInstrumentation().getContext().deleteDatabase(databaseHelperJobOffers.getDatabaseHelperName());
        assertTrue(isDropped);
    }

    @Test
    public void ShouldInsertDataAndVerifyCorrect() {
        DatabaseHelperJobOffers databaseHelperJobOffers = new DatabaseHelperJobOffers(InstrumentationRegistry.getInstrumentation().getTargetContext());
        SQLiteDatabase sql = databaseHelperJobOffers.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        database_COLUMN_ID = 1;
        contentValues.put(DatabaseHelperJobOffers.COLUMN_ID,database_COLUMN_ID);
        database_COLUMN_TITLE = "a";
        contentValues.put(DatabaseHelperJobOffers.COLUMN_TITLE,database_COLUMN_TITLE);
        database_COLUMN_COMPANY = "a";
        contentValues.put(DatabaseHelperJobOffers.COLUMN_COMPANY,database_COLUMN_COMPANY);
        database_COLUMN_YEARLY_SALARY = 10000;
        contentValues.put(DatabaseHelperJobOffers.COLUMN_YEARLY_SALARY,database_COLUMN_YEARLY_SALARY);
        database_COLUMN_YEARLY_BONUS = 1000;
        contentValues.put(DatabaseHelperJobOffers.COLUMN_YEARLY_BONUS,database_COLUMN_YEARLY_BONUS);
        database_COLUMN_TRAINING = 1000;
        contentValues.put(DatabaseHelperJobOffers.COLUMN_TRAINING,database_COLUMN_TRAINING);
        database_COLUMN_LEAVE_TIME = 10;
        contentValues.put(DatabaseHelperJobOffers.COLUMN_LEAVE_TIME,database_COLUMN_LEAVE_TIME);
        database_COLUMN_TELEWORK = 1;
        contentValues.put(DatabaseHelperJobOffers.COLUMN_TELEWORK,database_COLUMN_TELEWORK);

        long assignedId = sql.insert(DatabaseHelperJobOffers.TABLE_JOB_OFFERS, null, contentValues);
        assertTrue(assignedId != -1);

        Cursor cursor = sql.query(DatabaseHelperJobOffers.TABLE_JOB_OFFERS, null, null, null, null, null, null);
        assertTrue(cursor.moveToFirst());

        int idColumnIndex = cursor.getColumnIndex(DatabaseHelperJobOffers.COLUMN_ID);
        int databaseId = cursor.getInt(idColumnIndex);
        int titleColumnIndex = cursor.getColumnIndex(DatabaseHelperJobOffers.COLUMN_TITLE);
        String databaseTitle = cursor.getString(titleColumnIndex);
        int companyColumnIndex = cursor.getColumnIndex(DatabaseHelperJobOffers.COLUMN_COMPANY);
        String databaseCompany = cursor.getString(companyColumnIndex);
        int yearlySalaryColumnIndex = cursor.getColumnIndex(DatabaseHelperJobOffers.COLUMN_YEARLY_SALARY);
        int databaseYearlySalary = cursor.getInt(yearlySalaryColumnIndex);
        int yearlyBonusColumnIndex = cursor.getColumnIndex(DatabaseHelperJobOffers.COLUMN_YEARLY_BONUS);
        int databaseYearlyBonus = cursor.getInt(yearlyBonusColumnIndex);
        int trainingColumnIndex = cursor.getColumnIndex(DatabaseHelperJobOffers.COLUMN_TRAINING);
        int databaseTraining = cursor.getInt(trainingColumnIndex);
        int leaveTimeColumnIndex = cursor.getColumnIndex(DatabaseHelperJobOffers.COLUMN_LEAVE_TIME);
        int databaseLeaveTime = cursor.getInt(leaveTimeColumnIndex);
        int teleworkColumnIndex = cursor.getColumnIndex(DatabaseHelperJobOffers.COLUMN_TELEWORK);
        int databaseTelework = cursor.getInt(teleworkColumnIndex);

        assertEquals(database_COLUMN_ID, databaseId);
        assertEquals(database_COLUMN_TITLE, databaseTitle);
        assertEquals(database_COLUMN_COMPANY, databaseCompany);
        assertEquals(database_COLUMN_YEARLY_SALARY, databaseYearlySalary);
        assertEquals(database_COLUMN_YEARLY_BONUS, databaseYearlyBonus);
        assertEquals(database_COLUMN_TRAINING, databaseTraining);
        assertEquals(database_COLUMN_LEAVE_TIME, databaseLeaveTime);
        assertEquals(database_COLUMN_TELEWORK, databaseTelework);

        sql.close();
        InstrumentationRegistry.getInstrumentation().getTargetContext().deleteDatabase(databaseHelperJobOffers.getDatabaseHelperName());
    }
}
