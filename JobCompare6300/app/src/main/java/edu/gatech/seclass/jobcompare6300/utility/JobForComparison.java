package edu.gatech.seclass.jobcompare6300.utility;

import java.io.Serializable;

public class JobForComparison implements Serializable {
    // this class is used to calculate the score and update on the UI
    private final String id;
    private final String title;
    private final String company;
    private final Location location;
    private final double yearlySalary;
    private final double yearlyBonus;
    private final double trainingFund;
    private final int leaveTime;
    private final int teleworkDaysPerWeek;
    private boolean isCurrentJob;
    private double score;

    // Constructor
    public JobForComparison(String id,
               String titleStr,
               String companyStr,
               String cityStr, String stateStr, int colIndexInt,
               double yearlySalaryDouble, double yearlyBonusDouble,
               double trainingFundDouble,
               int leaveTimeInt,
               int teleworkInt,
               boolean isCurrentJob) {
        this.id = id;
        this.title = titleStr;
        this.company = companyStr;
        this.location = new Location(cityStr, stateStr, colIndexInt);
        this.yearlySalary = yearlySalaryDouble;
        this.yearlyBonus = yearlyBonusDouble;
        this.trainingFund = trainingFundDouble;
        this.leaveTime = leaveTimeInt;
        this.teleworkDaysPerWeek = teleworkInt;
        this.isCurrentJob = isCurrentJob;
    }

    public String getId() {return id; }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public double getYearlySalaryColAdjusted() {
        return yearlySalary/ this.getColIndex();
    }

    public double getYearlyBonus() {
        return yearlyBonus;
    }

    public double getYearlyBonusColAdjusted() {
        if (this.getColIndex() == 0) {
            return yearlyBonus;
        }
        return yearlyBonus/ this.getColIndex(); //TODO: Not sure if this adjustment is correct
    }


    public double getTrainingFund() {
        return trainingFund;
    }


    public int getLeaveTime() {
        return leaveTime;
    }


    public int getTeleworkDaysPerWeek() {
        return teleworkDaysPerWeek;
    }


    public int getColIndex() {
        return location.getColIndex();
    }

    public String getState() {
        return location.getState();
    }

    public String getCity() {
        return location.getCity();
    }

    public double getScore() {

        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public boolean isCurrentJob() {
        return this.isCurrentJob;
    }

    // Save details method placeholder
    public void saveDetails() {
        // TODO: Implement Android SQLite save logic here
        // TODO: Is this needed here?
    }
}
