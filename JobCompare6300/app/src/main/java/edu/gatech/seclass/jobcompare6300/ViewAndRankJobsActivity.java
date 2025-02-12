package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import edu.gatech.seclass.jobcompare6300.utility.CompareJobsSingleton;
import edu.gatech.seclass.jobcompare6300.utility.CurrentJobSingleton;
import edu.gatech.seclass.jobcompare6300.utility.JobForComparison;
import edu.gatech.seclass.jobcompare6300.utility.JobOffer;
import edu.gatech.seclass.jobcompare6300.utility.JobOffersSingleton;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ViewAndRankJobsActivity extends AppCompatActivity {

    private LinearLayout jobsContainer;
    private List<CheckBox> checkBoxes = new ArrayList<>();
    private final int MAX_CHECKED_BOXES = 2;
    private List<JobForComparison> rankedJobForComparison = new ArrayList<>();
    private List<JobForComparison> selectedJobs = new ArrayList<>();
    private JobDatabase jobDatabaseDbHelper = new JobDatabase(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_and_rank_jobs);

        jobsContainer = findViewById(R.id.jobs_container);

        rankedJobForComparison = getRankedJobsList();

        for (JobForComparison job : rankedJobForComparison) {

            addJobItem(job);
        }

        Button buttonCompare = findViewById(R.id.compare_two_jobs_button);
        buttonCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedJobs.size() != 2){
                   Toast.makeText(ViewAndRankJobsActivity.this, "Two jobs need to be selected for comparison.", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(ViewAndRankJobsActivity.this, CompareSelectedJobs.class);
                intent.putExtra("selectedJob1", selectedJobs.get(0));
                intent.putExtra("selectedJob2", selectedJobs.get(1));
                startActivity(intent);
            }
        });

        Button buttonReturn = findViewById(R.id.return_to_main);
        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ViewAndRankJobsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addJobItem(JobForComparison job) {
        View jobView = getLayoutInflater().inflate(R.layout.job_item, jobsContainer, false);

        TextView jobText = jobView.findViewById(R.id.job_text);
        CheckBox jobCheckBox = jobView.findViewById(R.id.job_checkbox);
        Button deleteButton = jobView.findViewById(R.id.delete_button);
        CurrentJobSingleton.getInstance().getCity().concat(", ").concat(CurrentJobSingleton.getInstance().getState());
        // Set job text
        jobText.setText(job.getTitle().concat(", ").concat(job.getCompany()));  // Assuming job.getTitle() returns a String representing the job title

        // Check if the job is the current job to decide whether to hide the delete button
        if (job.isCurrentJob()) {
            deleteButton.setVisibility(View.GONE);  // Hide delete button
        } else {
            deleteButton.setVisibility(View.VISIBLE);  // Show delete button
        }

        jobCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                if (checkBoxes.size() >= MAX_CHECKED_BOXES) {
                    jobCheckBox.setChecked(false);
                    Toast.makeText(ViewAndRankJobsActivity.this, "You can only check a maximum of " + MAX_CHECKED_BOXES + " checkboxes", Toast.LENGTH_SHORT).show();
                } else {
                    checkBoxes.add(jobCheckBox);
                    selectedJobs.add(job);
                }
            } else {
                checkBoxes.remove(jobCheckBox);
                selectedJobs.remove(job);
            }
        });

        deleteButton.setOnClickListener(v -> {
            String jobId = job.getId();  // Assuming JobForComparison has a method getId() that returns the job ID
            JobOffersSingleton.getInstance().removeJobOffer(jobId);
            // delete from db
            jobDatabaseDbHelper.openoffers();
            jobDatabaseDbHelper.deleteJobOffer(jobId);
            jobDatabaseDbHelper.closeoffers();
            jobsContainer.removeView(jobView);
            checkBoxes.remove(jobCheckBox);
            selectedJobs.remove(job);
        });

        jobsContainer.addView(jobView);
    }

    private List<JobForComparison> getRankedJobsList() {
        List<JobForComparison> jobForComparisonList =
                JobOffersSingleton.getInstance().getJobOffers().stream()
                .map(JobOffer::toJobForComparison)
                .collect(Collectors.toList());

        if(CurrentJobSingleton.getInstance().isValid()){
            jobForComparisonList.add(CurrentJobSingleton.getInstance().toJobForComparison());
        }
        return CompareJobsSingleton.getInstance().rankJobs(jobForComparisonList);
    }
}