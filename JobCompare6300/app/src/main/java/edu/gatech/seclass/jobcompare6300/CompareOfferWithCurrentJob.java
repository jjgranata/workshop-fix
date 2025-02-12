package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import edu.gatech.seclass.jobcompare6300.utility.CurrentJobSingleton;
import edu.gatech.seclass.jobcompare6300.utility.JobOffer;

public class CompareOfferWithCurrentJob extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_offer_with_current_job);
        JobOffer jobOffer = getIntent().getParcelableExtra("jobOffer", JobOffer.class);
        if (jobOffer != null) {
            TextView newJobTitle = findViewById(R.id.job1Title);
            TextView newJobCompany = findViewById(R.id.job1Company);
            TextView newJobLocation = findViewById(R.id.job1Location);
            TextView newJobYearlySalary = findViewById(R.id.job1YearlySalary);
            TextView newJobYearlyBonus = findViewById(R.id.job1YearlyBonus);
            TextView newJobTDF = findViewById(R.id.job1TDF);
            TextView newJobLT = findViewById(R.id.job1LT);
            TextView newJobRWT = findViewById(R.id.job1RWT);

            newJobTitle.setText(jobOffer.getTitle());
            newJobCompany.setText(jobOffer.getCompany());
            newJobLocation.setText(jobOffer.getCity().concat(", ").concat(jobOffer.getState()));
            newJobYearlySalary.setText(String.valueOf(jobOffer.getYearlySalaryColAdjusted()));
            newJobYearlyBonus.setText(String.valueOf(jobOffer.getYearlyBonusColAdjusted()));
            String trainingFund = String.valueOf(jobOffer.getTrainingFund());
            newJobTDF.setText(trainingFund);
            String leaveTime = String.valueOf(jobOffer.getLeaveTime());
            newJobLT.setText(leaveTime);
            String teleworkDays = String.valueOf(jobOffer.getTeleworkDaysPerWeek());
            newJobRWT.setText(teleworkDays);
        }
        TextView currentJobTitle = findViewById(R.id.job2Title);
        TextView currentJobCompany = findViewById(R.id.job2Company);
        TextView currentJobLocation = findViewById(R.id.job2Location);
        TextView currentJobYearlySalary = findViewById(R.id.job2YearlySalary);
        TextView currentJobYearlyBonus = findViewById(R.id.job2YearlyBonus);
        TextView currentJobTDF = findViewById(R.id.job2TDF);
        TextView currentJobLT = findViewById(R.id.job2LT);
        TextView currentJobRWT = findViewById(R.id.job2RWT);

        currentJobTitle.setText(CurrentJobSingleton.getInstance().getTitle());
        currentJobCompany.setText(CurrentJobSingleton.getInstance().getCompany());
        currentJobLocation.setText(CurrentJobSingleton.getInstance().getCity().concat(", ").concat(CurrentJobSingleton.getInstance().getState()));
        currentJobYearlySalary.setText(String.valueOf(CurrentJobSingleton.getInstance().getYearlySalaryColAdjusted()));
        currentJobYearlyBonus.setText(String.valueOf(CurrentJobSingleton.getInstance().getYearlyBonusColAdjusted()));
        String tf = String.valueOf(CurrentJobSingleton.getInstance().getTrainingFund());
        currentJobTDF.setText(tf);
        String lt = String.valueOf(CurrentJobSingleton.getInstance().getLeaveTime());
        currentJobLT.setText(lt);
        String tw = String.valueOf(CurrentJobSingleton.getInstance().getTeleworkDaysPerWeek());
        currentJobRWT.setText(tw);

        Button buttonCancel = findViewById(R.id.return_button);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompareOfferWithCurrentJob.this, CreateNewJobOfferActivity.class);
                startActivity(intent);
            }
        });
    }
}