package edu.gatech.seclass.jobcompare6300;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import edu.gatech.seclass.jobcompare6300.utility.CurrentJobSingleton;
import edu.gatech.seclass.jobcompare6300.utility.JobOffer;
import edu.gatech.seclass.jobcompare6300.utility.JobOffersSingleton;
import edu.gatech.seclass.jobcompare6300.JobDatabase;
import kotlinx.coroutines.Job;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class CreateNewJobOfferActivity extends AppCompatActivity {

    private JobDatabase jobDatabase;
    EditText companyID;
    EditText cityID;
    EditText stateID;
    EditText titleID;
    EditText colIndexID;
    EditText yearlySalaryID;
    EditText yearlyBonusID;
    EditText trainingFundID;
    EditText leaveTimeID;
    EditText teleworkID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_job_offer);

        //open database instance
        jobDatabase = new JobDatabase(this);
        jobDatabase.openoffers();

        companyID = findViewById(R.id.editTextCompany);
        cityID = findViewById(R.id.editTextCity);
        stateID = findViewById(R.id.editTextState);
        titleID = findViewById(R.id.editTextTitle);
        colIndexID = findViewById(R.id.editTextCostOfLiving);
        yearlySalaryID = findViewById(R.id.editTextYearlySalary);
        yearlyBonusID = findViewById(R.id.editTextYearlyBonus);
        trainingFundID = findViewById(R.id.editTextTrainingFund);
        leaveTimeID = findViewById(R.id.editTextLeaveTime);
        teleworkID = findViewById(R.id.editTextTeleworkDays);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buttonSave = findViewById(R.id.save_and_return_button);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick_CreateJobOffer();
                Intent intent = new Intent(CreateNewJobOfferActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Add save_and_new_button click listener
        Button buttonSaveAndNew = findViewById(R.id.save_and_create_another_button);
        buttonSaveAndNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleID_string = String.valueOf(titleID.getText());
                String companyID_string = String.valueOf(companyID.getText());
                String cityID_string = String.valueOf(cityID.getText());
                String stateID_string = String.valueOf(stateID.getText());
                String colIndexID_string = String.valueOf(colIndexID.getText());
                String yearlySalaryID_string = String.valueOf(yearlySalaryID.getText());
                String yearlyBonusID_string = String.valueOf(yearlyBonusID.getText());
                String trainingFundID_string = String.valueOf(trainingFundID.getText());
                String leaveTimeID_string = String.valueOf(leaveTimeID.getText());
                String teleworkID_string = String.valueOf(teleworkID.getText());

                if (titleID_string.isBlank() ||
                        companyID_string.isBlank() ||
                        cityID_string.isBlank() ||
                        stateID_string.isBlank() ||
                        colIndexID_string.isBlank() ||
                        yearlySalaryID_string.isBlank() ||
                        yearlyBonusID_string.isBlank() ||
                        trainingFundID_string.isBlank() ||
                        leaveTimeID_string.isBlank() ||
                        teleworkID_string.isBlank()
                ) {
                    Toast.makeText(CreateNewJobOfferActivity.this, "Job invalid, fields cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                int trainingFundID_int = Integer.parseInt(trainingFundID_string);
                int leaveTimeID_int = Integer.parseInt(leaveTimeID_string);
                int teleworkID_int = Integer.parseInt(teleworkID_string);
                if (trainingFundID_int > 18000 || leaveTimeID_int > 100 || teleworkID_int > 5) {
                    Toast.makeText(CreateNewJobOfferActivity.this, "Job invalid, fields out of range", Toast.LENGTH_SHORT).show();
                    return;
                }
                onClick_CreateJobOffer();
                // Restart the activity to refresh it
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

        Button buttonCompare = findViewById(R.id.compare_with_cur_job_button);
        buttonCompare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titleID_string = String.valueOf(titleID.getText());
                String companyID_string = String.valueOf(companyID.getText());
                String cityID_string = String.valueOf(cityID.getText());
                String stateID_string = String.valueOf(stateID.getText());
                String colIndexID_string = String.valueOf(colIndexID.getText());
                String yearlySalaryID_string = String.valueOf(yearlySalaryID.getText());
                String yearlyBonusID_string = String.valueOf(yearlyBonusID.getText());
                String trainingFundID_string = String.valueOf(trainingFundID.getText());
                String leaveTimeID_string = String.valueOf(leaveTimeID.getText());
                String teleworkID_string = String.valueOf(teleworkID.getText());

                if (titleID_string.isBlank() ||
                        companyID_string.isBlank() ||
                        cityID_string.isBlank() ||
                        stateID_string.isBlank() ||
                        colIndexID_string.isBlank() ||
                        yearlySalaryID_string.isBlank() ||
                        yearlyBonusID_string.isBlank() ||
                        trainingFundID_string.isBlank() ||
                        leaveTimeID_string.isBlank() ||
                        teleworkID_string.isBlank()
                ) {
                    Toast.makeText(CreateNewJobOfferActivity.this, "Job invalid, fields cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                int trainingFundID_int = Integer.parseInt(trainingFundID_string);
                int leaveTimeID_int = Integer.parseInt(leaveTimeID_string);
                int teleworkID_int = Integer.parseInt(teleworkID_string);
                if (trainingFundID_int > 18000 || leaveTimeID_int > 100 || teleworkID_int > 7) {
                    Toast.makeText(CreateNewJobOfferActivity.this, "Job invalid, fields out of range", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (CurrentJobSingleton.getInstance().isValid()) {
                    String companyStr = companyID.getText().toString();
                    String cityStr = cityID.getText().toString();
                    String stateStr = stateID.getText().toString();
                    String titleStr = titleID.getText().toString();
                    String colStr = colIndexID.getText().toString();
                    String yearlySalaryStr = yearlySalaryID.getText().toString();
                    String yearlyBonusStr = yearlyBonusID.getText().toString();
                    String trainingFundStr = trainingFundID.getText().toString();
                    String leaveTimeStr = leaveTimeID.getText().toString();
                    String teleworkStr = teleworkID.getText().toString();

                    int colIndexInt = Integer.parseInt(colStr);
                    double yearlySalaryDouble = Double.parseDouble(yearlySalaryStr);
                    double yearlyBonusDouble = Double.parseDouble(yearlyBonusStr);
                    double trainingFundDouble = Double.parseDouble(trainingFundStr);
                    int leaveTimeInt = Integer.parseInt(leaveTimeStr);
                    int teleworkInt = Integer.parseInt(teleworkStr);
                    // Create a new JobOffer
                    JobOffer jobOffer = new JobOffer("", titleStr, companyStr, cityStr, stateStr, colIndexInt, yearlySalaryDouble, yearlyBonusDouble, trainingFundDouble, leaveTimeInt, teleworkInt);
                    // add the job
//                    JobOffersSingleton.getInstance().addJobOffer(jobOffer);
                    onClick_CreateJobOffer();
                    Intent intent = new Intent(CreateNewJobOfferActivity.this, CompareOfferWithCurrentJob.class);
                    intent.putExtra("jobOffer", jobOffer);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(CreateNewJobOfferActivity.this, "No current job", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

        Button buttonCancel = findViewById(R.id.cancel_button);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateNewJobOfferActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onClick_CreateJobOffer() {
        String companyStr = companyID.getText().toString();
        String cityStr = cityID.getText().toString();
        String stateStr = stateID.getText().toString();
        String titleStr = titleID.getText().toString();
        String colStr = colIndexID.getText().toString();
        String yearlySalaryStr = yearlySalaryID.getText().toString();
        String yearlyBonusStr = yearlyBonusID.getText().toString();
        String trainingFundStr = trainingFundID.getText().toString();
        String leaveTimeStr = leaveTimeID.getText().toString();
        String teleworkStr = teleworkID.getText().toString();

        int colIndexInt = Integer.parseInt(colStr);
        double yearlySalaryDouble = Double.parseDouble(yearlySalaryStr);
        double yearlyBonusDouble = Double.parseDouble(yearlyBonusStr);
        double trainingFundDouble = Double.parseDouble(trainingFundStr);
        int leaveTimeInt = Integer.parseInt(leaveTimeStr);
        int teleworkInt = Integer.parseInt(teleworkStr);

        // Add the new JobOffer to the JobOffersSingleton
            // Create a new JobOffer
        JobOffer jobOffer = new JobOffer("", titleStr, companyStr, cityStr, stateStr, colIndexInt, yearlySalaryDouble, yearlyBonusDouble, trainingFundDouble, leaveTimeInt, teleworkInt);
        JobOffersSingleton.getInstance().addJobOffer(jobOffer);

        // copy of variables to prevent mixing data
        String id = jobOffer.getId();
        String title = titleStr;
        String company = companyStr;
        String city = cityStr;
        String state = stateStr;
        int col = colIndexInt;
        double yearlySalary = yearlySalaryDouble;
        double yearlyBonus = yearlyBonusDouble;
        double trainingFunds = trainingFundDouble;
        int leaveTime = leaveTimeInt;
        int teleworkDays = teleworkInt;

        Log.d("CreateOrUpdate", "Saving job: " + title + ", " + company + ", "  + city + ", "  + state + ", "  + col + ", " + yearlySalary + ", " + yearlyBonus + ", " + trainingFunds + ", " + leaveTime + ", " + teleworkDays);

        // Save data to the database
        long newRowId = jobDatabase.createJobOffer(id, title, company, yearlySalary, yearlyBonus, trainingFunds, leaveTime, teleworkDays, city, state, col);

        if (newRowId != -1) {
            Toast.makeText(this, "Job Saved", Toast.LENGTH_SHORT).show();
            Log.d("CreateOrUpdate", "Job saved with id: " + newRowId);
        } else {
            Toast.makeText(this, "Error Saving Job", Toast.LENGTH_SHORT).show();
            Log.e("CreateOrUpdate", "Error saving job");
        }
        finish();
    }
//saving job offer

}