package edu.gatech.seclass.jobcompare6300.utility;

import java.util.Objects;

public class CurrentJobSingleton {
    public boolean isFirst = true;
    private static CurrentJobSingleton instance;

    private String title;
    private String company;
    private Location location;
    private double yearlySalary;
    private double yearlyBonus;
    private double trainingFund;
    private int leaveTime;
    private int teleworkDaysPerWeek;

//    // Private constructor to prevent instantiation from outside
//    private CurrentJobSingleton(String title, String company, String city, String state, int colIndex, double yearlySalary, double yearlyBonus, int trainingFund, int leaveTime, int teleworkDaysPerWeek) {
//        this.title = title;
//        this.company = company;
//        this.location = new Location(city, state, colIndex);
//        this.yearlySalary = yearlySalary;
//        this.yearlyBonus = yearlyBonus;
//        this.trainingFund = trainingFund;
//        this.leaveTime = leaveTime;
//        this.teleworkDaysPerWeek = teleworkDaysPerWeek;
//
//    }

    // Default Constructor
    private CurrentJobSingleton() {
        this.title = null;
        this.company = null;
        this.location = new Location("Austin", "Texas", 0);
        this.yearlySalary = 0;
        this.yearlyBonus = 0;
        this.trainingFund = 0;
        this.leaveTime = 0;
        this.teleworkDaysPerWeek = 0;
    }

    // Singleton instance retrieval method
    public static CurrentJobSingleton getInstance() {
        if (instance == null) {
            instance = new CurrentJobSingleton();
        }
        return instance;
    }

    // Getters and Setters (omitted for brevity)

    // Update current job details
    //TODO -- Can we refactor this to accept a "JobOffer"? It's the same information
    public void updateCurrentJob(String titleStr, String companyStr, String cityStr, String stateStr, int colIndexInt, double yearlySalaryDouble, double yearlyBonusDouble, double trainingFundDouble, int leaveTimeInt, int teleworkInt) {
        if (!Objects.equals(titleStr, this.title)) {
            this.title = titleStr;
        }

        if (!Objects.equals(companyStr, this.company)) {
            this.company = companyStr;
        }

        if (!Objects.equals(cityStr, this.location.getCity())) {
            this.location.setCity(cityStr);
        }

        if (!Objects.equals(stateStr, this.location.getState())) {
            this.location.setState(stateStr);
        }

        if (colIndexInt != this.location.getColIndex()) {
            this.location.setColIndex(colIndexInt);
        }

        if (Double.compare(yearlySalaryDouble, this.yearlySalary) != 0) {
            this.yearlySalary = yearlySalaryDouble;
        }

        if (Double.compare(yearlyBonusDouble, this.yearlyBonus) != 0) {
            this.yearlyBonus = yearlyBonusDouble;
        }

        if (Double.compare(trainingFundDouble, this.trainingFund) != 0) {
            this.trainingFund = trainingFundDouble;
        }

        if (leaveTimeInt != this.leaveTime) {
            this.leaveTime = leaveTimeInt;
        }

        if (teleworkInt != this.teleworkDaysPerWeek) {
            this.teleworkDaysPerWeek = teleworkInt;
        }
    }

    // Method to convert CurrentJobSingleton to JobForComparison
    public JobForComparison toJobForComparison() {
        return new JobForComparison(
                "",
                this.title,
                this.company,
                this.location.getCity(),
                this.location.getState(),
                this.location.getColIndex(),
                this.yearlySalary,
                this.yearlyBonus,
                this.trainingFund,
                this.leaveTime,
                this.teleworkDaysPerWeek,
                true // isCurrentJob is true for the singleton instance
        );
    }


    public boolean isValid() {
        return this.title != null;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public Location getLocation() {
        return location;
    }

    public String getState() {
        return location.getState();
    }

    public String getCity() {
        return location.getCity();
    }

    public int getColIndex() {
        return location.getColIndex();
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
        return yearlyBonus/ this.getColIndex();
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
}