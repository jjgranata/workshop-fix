package edu.gatech.seclass.jobcompare6300.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import kotlinx.coroutines.Job;

public class JobOfferTest {
    @Test
    public void ShouldCreateNewJobWithValidInput() throws InterruptedException {
        JobOffer job = new JobOffer("","a", "a", "a", "a", 1, 1, 1, 1, 1, 1);
        TimeUnit.SECONDS.sleep(1);
        JobOffer job2 = new JobOffer("","b", "a", "a", "a", 1, 1, 1, 1, 1, 1);
        assertNotNull(job.getId());
        assertNotNull(job2.getId());
        assertNotEquals(job2.getId(), job.getId());
    }
}
