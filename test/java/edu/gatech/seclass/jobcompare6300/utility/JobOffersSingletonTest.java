package edu.gatech.seclass.jobcompare6300.utility;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;


import org.junit.Test;

import java.util.List;

import kotlinx.coroutines.Job;

public class JobOffersSingletonTest {
    @Test
    public void ShouldMakeNewInstanceIfInstanceIsNull() {
        JobOffersSingleton jobOffersSingleton = null;
        jobOffersSingleton = JobOffersSingleton.getInstance();
        assertNotNull(jobOffersSingleton);
    }

    @Test
    public void ShouldGetExistingInstanceIfExists() {
        JobOffersSingleton jobOffersSingleton = null;
        jobOffersSingleton = JobOffersSingleton.getInstance();
        JobOffer job = new JobOffer("","a","a","a","a",1,1,1,1,1,1);
        jobOffersSingleton.addJobOffer(job);
        jobOffersSingleton = JobOffersSingleton.getInstance();
        List<JobOffer> listOfJobs = jobOffersSingleton.getJobOffers();
        assertEquals(1, listOfJobs.get(0).getColIndex());
    }

    @Test
    public void ShouldRemoveJobOffer() {
        JobOffersSingleton jobOffersSingleton = null;
        jobOffersSingleton = JobOffersSingleton.getInstance();
        JobOffer job = new JobOffer("","a","a","a","a",1,1,1,1,1,1);
        jobOffersSingleton.addJobOffer(job);
        List<JobOffer> jobOffers = jobOffersSingleton.getJobOffers();
        String id = jobOffers.get(0).getId();
        int before = jobOffersSingleton.getNumberOfJobOffers();
        jobOffersSingleton.removeJobOffer(id);
        assertEquals(before - 1, jobOffersSingleton.getNumberOfJobOffers());
    }
}
