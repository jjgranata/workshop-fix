package edu.gatech.seclass.jobcompare6300;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import edu.gatech.seclass.jobcompare6300.utility.CurrentJobSingleton;

public class CreateOrUpdateCurrentJobActivity extends AppCompatActivity {

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

    // initialize database CRUD
    private JobDatabase jobDatabase;
//    private EditText titleEditText;
//    private EditText companyEditText;
//    private EditText salaryEditText;
//    private EditText yearlySalaryEditText;
//    private EditText yearlyBonusEditText;
//    private EditText trainingFundsEditText;
//    private EditText leaveTimeEditText;
//    private EditText teleworkDaysEditText;
    //private Button saveButton;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_or_update_current_job);

        //open database instance
        jobDatabase = new JobDatabase(this);
        jobDatabase.open();

        // Initialize EditText fields after setContentView
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

//        // Check if CurrentJobSingleton instance is valid before populating fields
        if (CurrentJobSingleton.getInstance().isValid()) {
            titleID.setText(CurrentJobSingleton.getInstance().getTitle());
            companyID.setText(CurrentJobSingleton.getInstance().getCompany());
            cityID.setText(CurrentJobSingleton.getInstance().getCity());
            stateID.setText(CurrentJobSingleton.getInstance().getState());
            colIndexID.setText(String.valueOf(CurrentJobSingleton.getInstance().getColIndex()));
            yearlySalaryID.setText(String.valueOf(CurrentJobSingleton.getInstance().getYearlySalary()));
            yearlyBonusID.setText(String.valueOf(CurrentJobSingleton.getInstance().getYearlyBonus()));
            trainingFundID.setText(String.valueOf(CurrentJobSingleton.getInstance().getTrainingFund()));
            leaveTimeID.setText(String.valueOf(CurrentJobSingleton.getInstance().getLeaveTime()));
            teleworkID.setText(String.valueOf(CurrentJobSingleton.getInstance().getTeleworkDaysPerWeek()));
        }

        // Add save button click listener
        Button buttonSave = findViewById(R.id.button_save);
        buttonSave.setOnClickListener(new View.OnClickListener() {
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
                    Toast.makeText(CreateOrUpdateCurrentJobActivity.this, "Job invalid, fields cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }

                int trainingFundID_int = Integer.parseInt(trainingFundID_string);
                int leaveTimeID_int = Integer.parseInt(leaveTimeID_string);
                int teleworkID_int = Integer.parseInt(teleworkID_string);
                if (trainingFundID_int > 18000 || leaveTimeID_int > 100 || teleworkID_int > 7) {
                    Toast.makeText(CreateOrUpdateCurrentJobActivity.this, "Job invalid, fields out of range", Toast.LENGTH_SHORT).show();
                    return;
                }

                onClick_UpdateCurrentJob();
                Intent intent = new Intent(CreateOrUpdateCurrentJobActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // Add cancel button click listener
        Button buttonCancel = findViewById(R.id.button_cancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateOrUpdateCurrentJobActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onDestroy() {
        jobDatabase.close();
        super.onDestroy();
    }
    public void onClick_UpdateCurrentJob() {
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

        // Convert input to appropriate types
        int colIndexInt = Integer.parseInt(colStr);
        double yearlySalaryDouble = Double.parseDouble(yearlySalaryStr);
        double yearlyBonusDouble = Double.parseDouble(yearlyBonusStr);
        double trainingFundDouble = Double.parseDouble(trainingFundStr);
        int leaveTimeInt = Integer.parseInt(leaveTimeStr);
        int teleworkInt = Integer.parseInt(teleworkStr);

        // Validate input before updating CurrentJobSingleton
        CurrentJobSingleton.getInstance().updateCurrentJob(titleStr, companyStr, cityStr, stateStr, colIndexInt, yearlySalaryDouble, yearlyBonusDouble, trainingFundDouble, leaveTimeInt, teleworkInt);

        // copy of variables to prevent mixing data
        String title = titleStr;
        String company = companyStr;
        double salary = yearlySalaryDouble;
        double yearlySalary = yearlySalaryDouble;
        double yearlyBonus = yearlyBonusDouble;
        double trainingFunds = trainingFundDouble;
        int leaveTime = leaveTimeInt;
        int teleworkDays = teleworkInt;
        String city = cityStr;
        String state = stateStr;
        int col = colIndexInt;

        Log.d("CreateOrUpdate", "Saving job: " + title + ", " + company + ", " + salary + ", " + yearlySalary + ", " + yearlyBonus + ", " + trainingFunds + ", " + leaveTime + ", " + teleworkDays);

        // Save data to the database
        long newRowId = jobDatabase.createJob(title, company, yearlySalary, yearlyBonus, trainingFunds, leaveTime, teleworkDays, city, state, col);

        if (newRowId != -1) {
            Toast.makeText(this, "Job Saved", Toast.LENGTH_SHORT).show();
            Log.d("CreateOrUpdate", "Job saved with id: " + newRowId);
        } else {
            Toast.makeText(this, "Error Saving Job", Toast.LENGTH_SHORT).show();
            Log.e("CreateOrUpdate", "Error saving job");
        }
        finish();
    }
}
