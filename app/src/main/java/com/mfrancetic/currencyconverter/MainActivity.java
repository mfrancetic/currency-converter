package com.mfrancetic.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private double dollarAmount;

    private double euroAmount;

    private String dollarAmountString;

    private String euroAmountString;

    private double currencyRate = 1.1;

    private String euroString;

    private static DecimalFormat decimalFormat = new DecimalFormat("#.##");

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
                dollarAmountString = decimalFormat.format(dollarAmount);
                displayDollarAmount();
                editText.setText("");
            }
        });

    }

    private double getDollarAmount(double euroAmount) {
        dollarAmount = euroAmount * currencyRate;
        return dollarAmount;
    }

    private void displayDollarAmount() {
        euroAmountString = decimalFormat.format(euroAmount);
        Toast.makeText(this, euroAmountString + getString(R.string.toast_text) + " " + dollarAmountString + getString(R.string.dollar_text), Toast.LENGTH_LONG).show();
    }
}