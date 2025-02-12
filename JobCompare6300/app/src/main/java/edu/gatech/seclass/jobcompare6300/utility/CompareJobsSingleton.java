package edu.gatech.seclass.jobcompare6300.utility;

import java.util.ArrayList;
import java.util.List;

public class CompareJobsSingleton {
    // Singleton instance
    private static CompareJobsSingleton instance;

    // Private constructor to prevent instantiation
    private CompareJobsSingleton() {
        // Initialize weights or any other initialization if needed
    }

    // Method to get the singleton instance
    public static CompareJobsSingleton getInstance() {
        if (instance == null) {
            instance = new CompareJobsSingleton();
        }
        return instance;
    }

    // Moving ComparisonSettings class here. Passing around objects other than JobOffer is unnecessary
    private int yearlySalaryWeight = 1;
    private int yearlyBonusWeight = 1;
    private int trainingFundWeight = 1;
    private int leaveTimeWeight = 1;
    private int teleworkWeight = 1;

    public double computeJobScore(JobForComparison job) {
        double weight = 0;

        // Calculate total weight
        int weightTotal = yearlySalaryWeight + yearlyBonusWeight + trainingFundWeight + leaveTimeWeight + teleworkWeight;

        if (weightTotal == 0) {
            weightTotal = 1;
        }

        // Calculate weighted components
        double AYS = job.getYearlySalary() * (job.getColIndex() / 100.0);
        double AYB = job.getYearlyBonus() * (job.getColIndex() / 100.0);

        weight = AYS * ((double) yearlySalaryWeight / weightTotal)
                + AYB * ((double) yearlyBonusWeight / weightTotal)
                + job.getTrainingFund() * ((double) trainingFundWeight / weightTotal);

        weight += ((job.getLeaveTime() * AYS) / 260.0) * ((double) leaveTimeWeight / weightTotal)
                - ((double) teleworkWeight / weightTotal) * (((260 - 52 * job.getTeleworkDaysPerWeek()) * (AYS / 260.0)) / 8);

        if(Double.isNaN(weight)) {
            throw new ArithmeticException("Invalid input -- Cannot compute score");
        }
        return weight;
    }

    public List<JobForComparison> rankJobs(List<JobForComparison> jobs) {
        List<JobForComparison> newRanking = new ArrayList<>();

        if (jobs == null || jobs.isEmpty()) {
            return newRanking;
        }
        if (jobs.size() == 1) {
            return jobs;
        }

        for (JobForComparison job : jobs) {
            double score = computeJobScore(job);
            job.setScore(score); // Assuming score is an integer in JobOffer
            newRanking.add(job);
        }

        // Sorting newRanking based on score, descending order
        newRanking.sort((job1, job2) -> (int) (job2.getScore() - job1.getScore()));

        return newRanking;
    }

//    public void compareTwoJobs(JobOffer job1, JobOffer job2) {
//        // Display comparison in GUI tables or other means
//        // This method can be customized based on your specific GUI implementation
//        // Example:
//        System.out.println("Comparing Job 1: " + job1.getTitle() + " with Job 2: " + job2.getTitle());
//        System.out.println("Job 1 Score: " + computeJobScore(job1));
//        System.out.println("Job 2 Score: " + computeJobScore(job2));
//    }

    public void assignWeights(int salWeight, int bonusWeight, int trainingWeight, int leaveWeight, int teleWeight) {
        if (salWeight < 0 || bonusWeight < 0 || trainingWeight < 0 || leaveWeight < 0 || teleWeight < 0) {
            throw new IllegalArgumentException("Cannot assign negative weight");
        }

        if (salWeight > 9 || bonusWeight > 9 || trainingWeight > 9 || leaveWeight > 9 || teleWeight > 9) {
            throw new IllegalArgumentException("Cannot assign weight greater than 9");
        }

        yearlySalaryWeight = salWeight;
        yearlyBonusWeight = bonusWeight;
        trainingFundWeight = trainingWeight;
        leaveTimeWeight = leaveWeight;
        teleworkWeight = teleWeight;
    }

    // Getter for salaryWeight
    public int getYearlySalaryWeight() {
        return yearlySalaryWeight;
    }

    // Getter for yearlyBonusWeight
    public int getYearlyBonusWeight() {
        return yearlyBonusWeight;
    }

    // Getter for trainingFundWeight
    public int getTrainingFundWeight() {
        return trainingFundWeight;
    }

    // Getter for leaveTimeWeight
    public int getLeaveTimeWeight() {
        return leaveTimeWeight;
    }

    // Getter for teleworkWeight
    public int getTeleworkWeight() {
        return teleworkWeight;
    }
}