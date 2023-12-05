package com.raxlin4ik.homework2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    float robot = 35_000;
    float stipendija = 1_700;
    float account = 700;
    float percentBank = 9;
    float accountBank = 0;
    int count = 0;

    private TextView accountBankOut;

    private TextView countOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        accountBankOut = findViewById(R.id.accountBankOut);
        countOut = findViewById(R.id.countOut);

        accountBankOut.setText(howManyMoney(robot, account, stipendija, percentBank) + " монет");

        countOut.setText(howManyMonth(robot, account, stipendija, percentBank) + " месяцев");
    }

    public int howManyMonth(float robot, float account, float stipendija, float percentBank) {
        float robotCost = robot - account;
        float stpMonth = stipendija;
        float percentMonth = (percentBank / 100) / 12;
        float accountBank = account;
        int count = 0;

        while (robotCost > accountBank) {
            accountBank = accountBank + stpMonth;
            accountBank = accountBank * (1 + percentMonth);
            count++;
        }

        return count;
    }


    public int howManyMoney(float robot, float account, float stipendija, float percentBank) {
        float robotCost = robot - account;
        float stpMonth = stipendija;
        float percentMonth = (percentBank / 100) / 12;
        float accountBank = account;
        int count = 0;

        while (robotCost > accountBank) {
            accountBank = accountBank + stpMonth;
            accountBank = accountBank * (1 + percentMonth);
            count++;
        }

        return (int) accountBank;
    }

}