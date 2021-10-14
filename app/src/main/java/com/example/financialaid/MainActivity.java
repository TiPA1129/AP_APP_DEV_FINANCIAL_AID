package com.example.financialaid;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText AmountF, RateF, TermF, FeesF;
    private Button Calculate;
    private TextView Monthly_Payment, Total_Interest;


    private void mathcalc(){
        double Amount = Double.parseDouble(AmountF.getText().toString());
        double Rate = (1 + Double.parseDouble(RateF.getText().toString()) / 100);
        double Term = Double.parseDouble(TermF.getText().toString());
        double Fees = Double.parseDouble(FeesF.getText().toString());

        double Interest = Math.pow(Rate, Term) * (Amount + Fees) - (Amount + Fees);
        double TotalDue = Amount + Interest + Fees;
        double Monthly = TotalDue / (Term*12);

        String outputD = "Interest due is: $" + String.format("%.2f", Interest);
        String outputM = "Monthly payment due is: $" + String.format("%.2f",Monthly);

        Monthly_Payment.setText(outputM);
        Total_Interest.setText(outputD);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Monthly_Payment = (TextView) findViewById(R.id.Monthly_Payment);
        Total_Interest = (TextView) findViewById(R.id.Total_Interest);

        AmountF = (EditText) findViewById(R.id.Loan_Amount);
        RateF = (EditText) findViewById(R.id.Interest_Rate);
        TermF = (EditText) findViewById(R.id.Loan_Term);
        FeesF = (EditText) findViewById(R.id.Loan_Fees);

        Calculate = (Button) findViewById(R.id.button);
        Calculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View w) {
                mathcalc();
                System.out.println("done");
            }
        });
    }
    }
