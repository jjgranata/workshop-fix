package edu.gatech.seclass.jobcompare6300;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;

import java.lang.*;
import java.util.List;

import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;
//import kotlin.jvm.internal.FloatCompanionObject;
import edu.gatech.seclass.jobcompare6300.utility.CurrentJobSingleton;
import edu.gatech.seclass.jobcompare6300.utility.JobOffer;
import edu.gatech.seclass.jobcompare6300.utility.JobOffersSingleton;


public class MainActivity extends AppCompatActivity {

    TextView curJobEntered;
    TextView numOfJobOffers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        JobDatabase jobDatabaseDbHelper = new JobDatabase(this);
        jobDatabaseDbHelper.open();
        jobDatabaseDbHelper.openoffers();
        List<JobOffer> listOfJobOffers = jobDatabaseDbHelper.getAllJobOffers();
        List<JobOffer> listOfCurrentJobs = jobDatabaseDbHelper.getCurrentJobOffer();
        jobDatabaseDbHelper.close();
        jobDatabaseDbHelper.closeoffers();

        JobOffersSingleton jobOffersSingleton = JobOffersSingleton.getInstance();
        //update respective singletons with this information
        for (JobOffer jobOffer : listOfJobOffers) {
            if (jobOffersSingleton.isFirst) {
                jobOffersSingleton.addJobOffer(jobOffer);
            }
        }
        jobOffersSingleton.isFirst = false;

        CurrentJobSingleton currentJobSingleton = CurrentJobSingleton.getInstance();
        if (currentJobSingleton.isFirst) {
            for (JobOffer jobCurrent : listOfCurrentJobs) {
                currentJobSingleton.updateCurrentJob(
                        jobCurrent.getTitle(),
                        jobCurrent.getCompany(),
                        jobCurrent.getCity(),
                        jobCurrent.getState(),
                        jobCurrent.getColIndex(),
                        jobCurrent.getYearlySalary(),
                        jobCurrent.getYearlyBonus(),
                        jobCurrent.getTrainingFund(),
                        jobCurrent.getLeaveTime(),
                        jobCurrent.getTeleworkDaysPerWeek()
                );
                break;
            }
        }
        currentJobSingleton.isFirst = false;

        jobDatabaseDbHelper.close();
        jobDatabaseDbHelper.closeoffers();

        setContentView(R.layout.activity_main);
        curJobEntered = findViewById(R.id.textViewCurJobEntered);
        numOfJobOffers = findViewById(R.id.textViewNumOfJobOffers);
        // update GUI for better UX and debug purposes
        curJobEntered.setText(String.valueOf(CurrentJobSingleton.getInstance().isValid()));
        numOfJobOffers.setText(String.valueOf(JobOffersSingleton.getInstance().getNumberOfJobOffers()));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button buttonUpdateOrCreateCurrentJob = findViewById(R.id.update_or_create_current_job);
        buttonUpdateOrCreateCurrentJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateOrUpdateCurrentJobActivity.class);
                startActivity(intent);
            }
        });
        Button buttonCreateJobOffer = findViewById(R.id.create_job_offer_button);
        buttonCreateJobOffer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateNewJobOfferActivity.class);
                startActivity(intent);
            }
        });
        Button buttonViewAndRankJobs = findViewById(R.id.view_and_rank_job_button);
        buttonViewAndRankJobs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean currJobOfferEntered = CurrentJobSingleton.getInstance().isValid();
                int numOffers = (JobOffersSingleton.getInstance().getNumberOfJobOffers());

                if((numOffers < 2) && !currJobOfferEntered){
                    Toast.makeText(MainActivity.this, "Need at least two job offers", Toast.LENGTH_SHORT).show();
                    return;
                } else if (numOffers < 1 && currJobOfferEntered) {
                    Toast.makeText(MainActivity.this, "Need at least one job and current job", Toast.LENGTH_SHORT).show();
                    return;
                }


                Intent intent = new Intent(MainActivity.this, ViewAndRankJobsActivity.class);
                startActivity(intent);
            }
        });

        Button buttonAdjustComparisonSetting = findViewById(R.id.adjust_comparison_settings_button);
        buttonAdjustComparisonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AdjustComparisonSettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}


    /*
    Brief: Create or update current job
    Input:


        EditText titleID;
        EditText companyID;
        EditText cityID;
        EditText stateID;
        EditText costOfLivingIndexID;
        EditText yearlySalaryID;
        EditText yearlyBonusID;
        EditText trainingFundID;
        EditText leaveTimeID;
        EditText teleworkDaysPerWeekID;

        Button save;

    Output:
        N/A
//
//    */

//
//
//
//
//    /*
//
//    Input:
//
//        Button cancelAndErase;
//
//     Output:
//        Clear text or return to main menu.
//
//     */
//    public void onClick_CancelCurrentJob(View view){
//
//        //!TODO: Set to empty OR return to main menu
//
//    }
//
//    /*
//    Brief: Create job offer
//    Input:
//
//        EditText jobOfferID; Used for user to compare jobs easily.
//        EditText title_jobOffer_ID;
//        EditText company_jobOffer_ID;
//        EditText city_jobOffer_ID;
//        EditText state_jobOffer_ID;
//        EditText costOfLivingIndex_jobOffer_ID;
//        EditText yearlySalary_jobOffer_ID;
//        EditText yearlyBonus_jobOffer_ID;
//        EditText trainingFund_jobOffer_ID;
//        EditText leaveTime_jobOffer_ID;
//        EditText teleworkDaysPerWeek_jobOffer_ID;
//
//        Button jobOffer_save;
//
//
//    Output:
//        !TODO: Add to GUI table
//
//    */

//
//
//
//
//    /*
//    Input:
//        Button jobOffer_cancelAndErase;
//
//    Output:
//        Clear text fields OR return to main menu
//    */
//
//    public void onClick_CancelJobOffer(View view){
//
//        //Find fields
//
//        //!TODO: Set to empty OR return to main screen
//
//    }
//
//
//
//    /*
//
//    Brief: Delete job offer from table. Retrieve by Id
//
//    Input:
//        EditText jobOfferID;
//
//        Button deleteJobOfferAndReturnID;
//
//    Output:
//
//        N/A
//
//     */
//
//    public void onClick_DeleteJobOffer(View view){
//
//        //Find job offer by id
//
//        EditText jobId1 = findViewById(R.id.jobOfferID);
//
//        String jobId1Str = jobId1.getText().toString();
//
//        int jobId1Int = Integer.parseInt(jobId1Str);
//        //!TODO: Delete from list
//
//        //!TODO: Update SQL
//
//
//    }
//
//    /*
//
//    Brief: Compare recent job offer to other by ID
//
//    Input:
//        EditText recentjobOfferID;
//
//        Button compareRecentJobOfferToOtherID;
//
//    Output:
//
//        Output to table
//
//     */
//    public void onClick_CompareRecentJobOfferToOther(View view){
//
//        EditText jobId1 = findViewById(R.id.jobOfferID);
//        EditText jobId2 = findViewById(R.id.recentjobOfferID);
//
//        String jobId1Str = jobId1.getText().toString();
//        String jobId2Str = jobId2.getText().toString();
//
//        int jobId1Int = Integer.parseInt(jobId1Str);
//        int jobId2Int = Integer.parseInt(jobId2Str);
//        //Find job offer by id
//
//        //!TODO: Show in GUI
//
//
//    }
//
//
//    /*
//
//    Brief: Compare two jobs and display results
//    Input:
//        EditText one_jobOfferID;
//        EditText two_jobOfferID;
//
//        Button compareTwoJobsID;
//
//    Output:
//
//        Output to table
//
//
//     */
//    public void onClick_CompareTwoJobs(View view){
//        EditText jobId1 = findViewById(R.id.one_jobOfferID);
//        EditText jobId2 = findViewById(R.id.two_jobOfferID);
//
//
//        String jobId1Str = jobId1.getText().toString();
//        String jobId2Str = jobId2.getText().toString();
//
//        int jobId1Int = Integer.parseInt(jobId1Str);
//        int jobId2Int = Integer.parseInt(jobId2Str);
//
//        //!TODO: Retrieve jobs by id
//
//        //!TODO: Show in table
//
//    }
//
//    /*
//
//
//    Brief: Compute scores for jobs and display in order of rank.
//
//    Input:
//        Button rankJobsID;
//
//    Output:
//        Display results in table.
//
//     */
//    public void onClick_RankJobs(View view){
//
//
//        //Rank jobs
//        List<JobOffer> new_list = compareJobObject.rankJobs(listOfJobOffers);
//
//        //!TODO: Show in table
//
//
//    }
//
//    /*
//
//    Brief: Compare two jobs and display results
//    Input:
//        EditText salaryWeightID;
//        EditText yearlyBonusWeightID;
//        EditText trainingFundWeight;
//        EditText leaveTimeWeight;
//        EditText teleworkWeight;
//
//
//    Output:
//
//        N/A
//
//
//     */



