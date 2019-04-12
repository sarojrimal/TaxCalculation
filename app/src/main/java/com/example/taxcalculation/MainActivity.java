package com.example.taxcalculation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    private EditText text_salary;
    private TextView output;
    double TAX = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text_salary = findViewById(R.id.et_salary);
        output = findViewById(R.id.rslt);
    }
    public void calculate_tax(View view) {
        String salary_value = text_salary.getText().toString();
        if (salary_value.isEmpty()){
            text_salary.setError("enter your salary to calculate tax");
        }
        else{
            User usr = new User(Double.parseDouble(salary_value));
            double yearlySalary = usr.getSalary() * 12;
            if (yearlySalary <= 200000) {
                TAX = 0.01 * yearlySalary;
            }
            else if (yearlySalary > 200000 && yearlySalary <= 350000) {
                TAX = (0.01 * 200000) + 0.15*(yearlySalary - 200000);
            }
            else {
                TAX = (0.01 * 200000) + (0.15*150000) + 0.25*(yearlySalary - 350000);
            }
            output.setText("The Total Tax Amount is : "+(TAX));
        }
    }
}
