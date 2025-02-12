package edu.gatech.seclass.jobcompare6300.utility;
import java.io.Serializable;

public class JobOffer implements Serializable {
    private final String id; //CHANGE THIS
    private final String title;
    private final String company;
    private final Location location;
    private final double yearlySalary;
    private final double yearlyBonus;
    private final double trainingFund;
    private final int leaveTime;
    private final int teleworkDaysPerWeek;

    // Constructor
    public JobOffer(String id, String titleStr, String companyStr, String cityStr, String stateStr, int colIndexInt, double yearlySalaryDouble, double yearlyBonusDouble, double trainingFundDouble, int leaveTimeInt, int teleworkInt) {
        if (id.isEmpty()) {
            this.id = String.valueOf(System.currentTimeMillis());
        } else {
            this.id = id;
        }
        //<-- CHANGE THIS// Increment the counter and assign it to the id, this id is used as UUID for deletion
        this.title = titleStr;
        this.company = companyStr;
        this.location = new Location(cityStr, stateStr, colIndexInt);
        this.yearlySalary = yearlySalaryDouble;
        this.yearlyBonus = yearlyBonusDouble;
        this.trainingFund = trainingFundDouble;
        this.leaveTime = leaveTimeInt;
        this.teleworkDaysPerWeek = teleworkInt;
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

    public JobForComparison toJobForComparison() {
        return new JobForComparison(
                this.id,
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
                false // Assuming this is not the current job
        );
    }
//    public JobOffer createUpdatedJobOffer(String titleStr, String companyStr, String cityStr, String stateStr, int colIndexInt, double yearlySalaryDouble, double yearlyBonusDouble, double trainingFundDouble, int leaveTimeInt, int teleworkInt) {
//        return new JobOffer(titleStr, companyStr, cityStr, stateStr, colIndexInt, yearlySalaryDouble, yearlyBonusDouble, trainingFundDouble, leaveTimeInt, teleworkInt);
//    }

    // Save details method placeholder
    public void saveDetails() {
        // TODO: Implement Android SQLite save logic here
        // TODO: Is this needed here?
    }

}