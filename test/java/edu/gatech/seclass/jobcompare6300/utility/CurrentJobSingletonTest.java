package edu.gatech.seclass.jobcompare6300.utility;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertNotNull;

import org.junit.Test;

public class CurrentJobSingletonTest {
    @Test
    public void ShouldMakeNewInstanceIfInstanceIsNull() {
        CurrentJobSingleton currentJobSingleton = null;
        currentJobSingleton = CurrentJobSingleton.getInstance();
        assertNotNull(currentJobSingleton);
    }

    @Test
    public void ShouldGetExistingInstanceIfExists() {
        CurrentJobSingleton currentJobSingleton = null;
        currentJobSingleton = CurrentJobSingleton.getInstance();
        currentJobSingleton.updateCurrentJob("a","a","a","a",1,2,2,2,1,1);
        currentJobSingleton = CurrentJobSingleton.getInstance();
        assertEquals(1, currentJobSingleton.getColIndex());
    }

    @Test
    public void ShouldUpdateCurrentJobWithValidInput() {
        CurrentJobSingleton currentJobSingleton = null;
        currentJobSingleton = CurrentJobSingleton.getInstance();
        currentJobSingleton.updateCurrentJob("a","a","a","a",1,2,2,2,1,1);
        currentJobSingleton = CurrentJobSingleton.getInstance();
        assertEquals(1, currentJobSingleton.getColIndex());

        currentJobSingleton.updateCurrentJob("b","b","b","b",2,3,4,4,3,3);
        assertEquals(2, currentJobSingleton.getColIndex());
    }

    @Test
    public void ShouldConfirmJobIsNotValid() {
        CurrentJobSingleton currentJobSingleton = null;
        currentJobSingleton = CurrentJobSingleton.getInstance();
        currentJobSingleton.updateCurrentJob(null,"a","a","a",1,2,2,2,1,1);
        assertFalse(currentJobSingleton.isValid());
    }
}
