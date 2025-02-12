package edu.gatech.seclass.jobcompare6300.utility;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobOffersSingleton {
    private static JobOffersSingleton instance;
    private Map<String, JobOffer> jobOffers;
    public boolean isFirst = true;

    private JobOffersSingleton() {
        jobOffers = new HashMap<>();
    }

    public static JobOffersSingleton getInstance() {
        if (instance == null) {
            instance = new JobOffersSingleton();
        }
        return instance;
    }

    public List<JobOffer> getJobOffers() {
        return new ArrayList<>(jobOffers.values());
    }

    public void addJobOffer(JobOffer jobOffer) {
        jobOffers.put(jobOffer.getId(), jobOffer);
    }

    public void removeJobOffer(String jobId) {
        jobOffers.remove(jobId);
    }

    public JobOffer getJobOfferById(String jobId) {
        return jobOffers.get(jobId);
    }

    public int getNumberOfJobOffers() {
        return jobOffers.values().size();
    }

//    public void updateJobOffer(String id, JobOffer updatedJobOffer) {
//        jobOffers.put(id, updatedJobOffer);
//    }
}
