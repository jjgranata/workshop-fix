package edu.gatech.seclass.jobcompare6300;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import edu.gatech.seclass.jobcompare6300.utility.CompareJobsSingleton;

public class AdjustComparisonSettingsActivity extends AppCompatActivity {

    EditText yearlySalaryWgt;
    EditText yearlyBonusWgt;
    EditText trainingAndDevelopmentWgt;
    EditText leaveTimeWgt;
    EditText teleworkDaysPerWeekWgt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adjust_comparison_settings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        yearlySalaryWgt = findViewById(R.id.editTextYearlySalaryWgt);
        yearlyBonusWgt = findViewById(R.id.editTextYearlyBonusWgt);
        trainingAndDevelopmentWgt = findViewById(R.id.editTextTrainingFundWgt);
        leaveTimeWgt = findViewById(R.id.editTextLeaveTimeWgt);
        teleworkDaysPerWeekWgt = findViewById(R.id.editTextTeleworkDaysWgt);
        // set the text
        yearlySalaryWgt.setText(String.valueOf(CompareJobsSingleton.getInstance().getYearlySalaryWeight()));
        yearlyBonusWgt.setText(String.valueOf(CompareJobsSingleton.getInstance().getYearlyBonusWeight()));
        trainingAndDevelopmentWgt.setText(String.valueOf(CompareJobsSingleton.getInstance().getTrainingFundWeight()));
        leaveTimeWgt.setText(String.valueOf(CompareJobsSingleton.getInstance().getLeaveTimeWeight()));
        teleworkDaysPerWeekWgt.setText(String.valueOf(CompareJobsSingleton.getInstance().getTeleworkWeight()));

        Button buttonSave = findViewById(R.id.save_return_button);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String salaryW_string = String.valueOf(yearlySalaryWgt.getText());
                String bonusW_string = String.valueOf(yearlyBonusWgt.getText());
                String trainingW_string = String.valueOf(trainingAndDevelopmentWgt.getText());
                String leaveW_string = String.valueOf(leaveTimeWgt.getText());
                String teleworkW_string = String.valueOf(teleworkDaysPerWeekWgt.getText());
                if (salaryW_string.isBlank() || bonusW_string.isBlank() || trainingW_string.isBlank() || leaveW_string.isBlank()|| teleworkW_string.isBlank() ) {
                    Toast.makeText(AdjustComparisonSettingsActivity.this, "Settings invalid, cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                int salaryW = Integer.parseInt(salaryW_string);
                int bonusW = Integer.parseInt(bonusW_string);
                int trainingW = Integer.parseInt(trainingW_string);
                int leaveW = Integer.parseInt(leaveW_string);
                int teleworkW = Integer.parseInt(teleworkW_string);
                if (salaryW > 9 || bonusW > 9 || trainingW > 9 || leaveW > 9 || teleworkW > 9) {
                    Toast.makeText(AdjustComparisonSettingsActivity.this, "Settings invalid, cannot be over 9", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (salaryW < 0 || bonusW < 0 || trainingW < 0 || leaveW < 0 || teleworkW < 0 ) {
                    Toast.makeText(AdjustComparisonSettingsActivity.this, "Settings invalid, cannot be below 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                onClick_assignWeights();
                Intent intent = new Intent(AdjustComparisonSettingsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });


        Button buttonCancel = findViewById(R.id.cancel_button);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdjustComparisonSettingsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onClick_assignWeights() {

        String salWeightStr = yearlySalaryWgt.getText().toString();
        String bonusWeightStr = yearlyBonusWgt.getText().toString();
        String trainingFundStr = trainingAndDevelopmentWgt.getText().toString();
        String leaveTimeStr = leaveTimeWgt.getText().toString();
        String teleworkStr = teleworkDaysPerWeekWgt.getText().toString();

        int salWeight = Integer.parseInt(salWeightStr);
        int bonusWeight = Integer.parseInt(bonusWeightStr);
        int trainingWeight = Integer.parseInt(trainingFundStr);
        int leaveWeight = Integer.parseInt(leaveTimeStr);
        int teleWeight = Integer.parseInt(teleworkStr);
        //Load into class
        CompareJobsSingleton.getInstance().assignWeights(salWeight, bonusWeight, trainingWeight, leaveWeight, teleWeight);
    }
}
