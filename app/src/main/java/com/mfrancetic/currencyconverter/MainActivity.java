package com.mfrancetic.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private double dollarAmount;

    private double euroAmount;

    private double currencyRate = 1.1;

    private String euroString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.currency_convert_button);
        final EditText editText = findViewById(R.id.currency_edit_text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                euroString = editText.getText().toString();
                euroAmount = Double.valueOf(euroString);
                dollarAmount = getDollarAmount(euroAmount);
                displayDollarAmount(dollarAmount);
            }
        });

    }

    private double getDollarAmount(double euroAmount) {
        return euroAmount * currencyRate;
    }

    private void displayDollarAmount(double dollarAmount) {
        Toast.makeText(this, euroAmount + getString(R.string.toast_text) + " " + dollarAmount + getString(R.string.dollar_text), Toast.LENGTH_LONG).show();
    }
}