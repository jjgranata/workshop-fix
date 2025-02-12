package edu.gatech.seclass.jobcompare6300;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import android.database.sqlite.SQLiteDatabase;

import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class JobDatabaseTest {

    @Test
    public void ShouldCreateAndDropDatabase() {
        JobDatabase jobDatabase = new JobDatabase(InstrumentationRegistry.getInstrumentation().getTargetContext());
        boolean success = true;
        try {
            jobDatabase.open();
            jobDatabase.close();
        }
        catch (Exception e) {
            success = false;
        }
        assertTrue(success);
    }

    @Test
    public void ShouldInsertData() {
        JobDatabase jobDatabase = new JobDatabase(InstrumentationRegistry.getInstrumentation().getTargetContext());
        jobDatabase.open();
        long databaseId = jobDatabase.createJob("a", "a",10000, 10000, 1000, 1000, 10, "a", "aa", 2);
        assertNotEquals(-1, databaseId);
        jobDatabase.close();
    }
}
