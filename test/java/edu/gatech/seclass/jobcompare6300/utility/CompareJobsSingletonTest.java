package edu.gatech.seclass.jobcompare6300.utility;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import static java.lang.Double.NaN;
import static java.lang.Double.compare;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import edu.gatech.seclass.jobcompare6300.utility.CompareJobsSingleton;
import kotlinx.coroutines.Job;

public class CompareJobsSingletonTest {
    @Test
    public void ShouldMakeNewInstanceIfInstanceIsNull() {
        CompareJobsSingleton compareJobsSingleton = null;
        compareJobsSingleton = CompareJobsSingleton.getInstance();
        assertNotNull(compareJobsSingleton);
    }

    @Test
    public void ShouldGetExistingInstanceIfExists() {
        CompareJobsSingleton compareJobsSingleton = null;
        compareJobsSingleton = CompareJobsSingleton.getInstance();
        compareJobsSingleton.assignWeights(1,1,1,1,1);
        compareJobsSingleton = CompareJobsSingleton.getInstance();
        assertEquals(1, compareJobsSingleton.getLeaveTimeWeight());
    }

    @Test
    public void ShouldReturnScoreForValidInputJob() {
        CompareJobsSingleton compareJobsSingleton = null;
        compareJobsSingleton = CompareJobsSingleton.getInstance();
        compareJobsSingleton.assignWeights(1,1,1,1,1);
        JobForComparison job = new JobForComparison("a","test", "test2", "test3", "test4",
                80, 80000,8000, 8000, 12 ,3, false);
        double score = compareJobsSingleton.computeJobScore(job);
        assertEquals(15630.76923076923, score);
    }

    @Test
    public void ShouldThrowExceptionOnInvalidJobInput() {
        CompareJobsSingleton compareJobsSingleton = null;
        compareJobsSingleton = CompareJobsSingleton.getInstance();
        compareJobsSingleton.assignWeights(1,1,1,1,1);
        JobForComparison job = new JobForComparison("q","test", "test2", "test3", "test4",
                0, 0,NaN, 0, 0 ,0, false);
        CompareJobsSingleton finalCompareJobsSingleton = compareJobsSingleton;
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> finalCompareJobsSingleton.computeJobScore(job));
        assertTrue(exception.getMessage().contains("Invalid input -- Cannot compute score"));
    }

    @Test
    public void ShouldReturnEmptyListWhenSortingZeroJobs() {
        CompareJobsSingleton compareJobsSingleton = null;
        compareJobsSingleton = CompareJobsSingleton.getInstance();
        List<JobForComparison> list = new ArrayList<>();
        List<JobForComparison> listOfOffers = compareJobsSingleton.rankJobs(list);
        assertEquals(0, listOfOffers.size());
    }

    @Test
    public void ShouldSortJobsOfSizeOne() {
        CompareJobsSingleton compareJobsSingleton = null;
        compareJobsSingleton = CompareJobsSingleton.getInstance();
        List<JobForComparison> list = new ArrayList<>();
        list.add(new JobForComparison("u","a","a","a","a",1,1,1,1,1,1, false));
        List<JobForComparison> listOfOffers = compareJobsSingleton.rankJobs(list);
        assertEquals(1, listOfOffers.size());
        String title = listOfOffers.get(0).getTitle();
        assertEquals(title, "a");
    }

    @Test
    public void ShouldSortJobsAccordingToScore() {
        CompareJobsSingleton compareJobsSingleton = null;
        compareJobsSingleton = CompareJobsSingleton.getInstance();
        compareJobsSingleton.assignWeights(1,1,1,1,1);
        List<JobForComparison> list = new ArrayList<>();
        JobForComparison lowestScore = new JobForComparison("k","a","a","a","a",1,1,1,1,1, 1, false);
        JobForComparison middleScore = new JobForComparison("m","b","b","b","b",2,20,20,20,20, 2, false);
        JobForComparison highestScore = new JobForComparison("i","c","c","c","c",3,3000,3000,3000,3, 3, false);
        list.add(lowestScore);
        list.add(highestScore);
        list.add(middleScore);
        List<JobForComparison> listOfOffers = compareJobsSingleton.rankJobs(list);
        assertEquals(3, listOfOffers.size());
        String title = listOfOffers.get(0).getTitle();
        assertEquals("c", title);
        title = listOfOffers.get(1).getTitle();
        assertEquals("b", title);
        title = listOfOffers.get(2).getTitle();
        assertEquals("a", title);
    }

    @Test
    public void ShouldSuccessfullyAssignWeights() {
        CompareJobsSingleton compareJobsSingleton = null;
        compareJobsSingleton = CompareJobsSingleton.getInstance();
        compareJobsSingleton.assignWeights(3,1,2,5,6);
        assertEquals(5, compareJobsSingleton.getLeaveTimeWeight());
        assertEquals(2, compareJobsSingleton.getTrainingFundWeight());
        assertEquals(6, compareJobsSingleton.getTeleworkWeight());
        assertEquals(1, compareJobsSingleton.getYearlyBonusWeight());
        assertEquals(3, compareJobsSingleton.getYearlySalaryWeight());
    }

    @Test
    public void ShouldNotAssignNegativeWeights() {
        CompareJobsSingleton compareJobsSingleton = null;
        compareJobsSingleton = CompareJobsSingleton.getInstance();
        CompareJobsSingleton finalCompareJobsSingleton = compareJobsSingleton;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> finalCompareJobsSingleton.assignWeights(-3,1,2,5,6));
        assertTrue(exception.getMessage().contains("Cannot assign negative weight"));
    }

    @Test
    public void ShouldNotAssignWeightsGreaterThanNine() {
        CompareJobsSingleton compareJobsSingleton = null;
        compareJobsSingleton = CompareJobsSingleton.getInstance();
        CompareJobsSingleton finalCompareJobsSingleton = compareJobsSingleton;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> finalCompareJobsSingleton.assignWeights(3,1,2,5,11));
        assertTrue(exception.getMessage().contains("Cannot assign weight greater than 9"));
    }
}