package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.gatech.seclass.jobcompare6300.utility.CurrentJobSingleton;
import edu.gatech.seclass.jobcompare6300.utility.JobOffer;
import edu.gatech.seclass.jobcompare6300.utility.JobForComparison;
public class CompareSelectedJobs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare_selected_jobs);
        JobForComparison job1 = getIntent().getParcelableExtra("selectedJob1", JobForComparison.class);
        JobForComparison job2 = getIntent().getParcelableExtra("selectedJob2", JobForComparison.class);
        if (job1 != null && job2 != null) {
            TextView job1Title = findViewById(R.id.job1Title);
            TextView job1Company = findViewById(R.id.job1Company);
            TextView job1Location = findViewById(R.id.job1Location);
            TextView job1YearlySalary = findViewById(R.id.job1YearlySalary);
            TextView job1YearlyBonus = findViewById(R.id.job1YearlyBonus);
            TextView job1TDF = findViewById(R.id.job1TDF);
            TextView job1LT = findViewById(R.id.job1LT);
            TextView job1RWT = findViewById(R.id.job1RWT);

            job1Title.setText(job1.getTitle());
            job1Company.setText(job1.getCompany());
            job1Location.setText(job1.getCity().concat(", ").concat(job1.getState()));
            job1YearlySalary.setText(String.valueOf(job1.getYearlySalaryColAdjusted()));
            job1YearlyBonus.setText(String.valueOf(job1.getYearlyBonusColAdjusted()));
            job1TDF.setText(String.valueOf(job1.getTrainingFund()));
            job1LT.setText(String.valueOf(job1.getLeaveTime()));
            job1RWT.setText(String.valueOf(job1.getTeleworkDaysPerWeek()));


            TextView job2Title = findViewById(R.id.job2Title);
            TextView job2Company = findViewById(R.id.job2Company);
            TextView job2Location = findViewById(R.id.job2Location);
            TextView job2YearlySalary = findViewById(R.id.job2YearlySalary);
            TextView job2YearlyBonus = findViewById(R.id.job2YearlyBonus);
            TextView job2TDF = findViewById(R.id.job2TDF);
            TextView job2LT = findViewById(R.id.job2LT);
            TextView job2RWT = findViewById(R.id.job2RWT);

            job2Title.setText(job2.getTitle());
            job2Company.setText(job2.getCompany());
            job2Location.setText(job2.getCity().concat(", ").concat(job2.getState()));
            job2YearlySalary.setText(String.valueOf(job2.getYearlySalaryColAdjusted()));
            job2YearlyBonus.setText(String.valueOf(job2.getYearlyBonusColAdjusted()));
            job2TDF.setText(String.valueOf(job2.getTrainingFund()));
            job2LT.setText(String.valueOf(job2.getLeaveTime()));
            job2RWT.setText(String.valueOf(job2.getTeleworkDaysPerWeek()));
        }

        Button buttonCancel = findViewById(R.id.return_button);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CompareSelectedJobs.this, ViewAndRankJobsActivity.class);
                startActivity(intent);
            }
        });
    }
}