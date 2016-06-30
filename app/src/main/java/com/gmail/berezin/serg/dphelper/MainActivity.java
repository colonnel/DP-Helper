package com.gmail.berezin.serg.dphelper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText vInputHigh;
    EditText vInputWidth;
    EditText vInputInches;
    Button vCalcButton;
    TextView vErrorHigh;
    TextView vErrorWidth;
    TextView vErrorInches;
    TextView vDpi;
    TextView vTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vInputHigh = (EditText) findViewById(R.id.high);
        vInputWidth = (EditText) findViewById(R.id.width);
        vInputInches = (EditText) findViewById(R.id.inches);
        vCalcButton = (Button) findViewById(R.id.calc_button);
        vErrorHigh = (TextView) findViewById(R.id.error_high);
        vErrorWidth = (TextView) findViewById(R.id.error_width);
        vErrorInches = (TextView) findViewById(R.id.error_inches);
        vDpi = (TextView) findViewById(R.id.dpi);
        vTarget = (TextView) findViewById(R.id.target);

        vCalcButton.setOnClickListener(clkCalc);
    }

    //click on button "Calculate"
    View.OnClickListener clkCalc = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean highIs = false;
            boolean widthIs = false;
            boolean inchesIs = false;
            boolean success = false;
            if (TextUtils.isEmpty(vInputHigh.getText().toString())) {
                vErrorHigh.setVisibility(View.VISIBLE);
                vErrorHigh.setText(R.string.message_isempty);
            } else {
                vErrorHigh.setVisibility(View.INVISIBLE);
                highIs = true;
            }
            if (TextUtils.isEmpty(vInputWidth.getText().toString())) {
                vErrorWidth.setVisibility(View.VISIBLE);
                vErrorWidth.setText(R.string.message_isempty);
            } else {
                vErrorWidth.setVisibility(View.INVISIBLE);
                widthIs = true;
            }
            if (TextUtils.isEmpty(vInputInches.getText().toString())) {
                vErrorInches.setVisibility(View.VISIBLE);
                vErrorInches.setText(R.string.message_isempty);
            } else {
                vErrorInches.setVisibility(View.INVISIBLE);
                inchesIs = true;
            }
            if (highIs && widthIs && inchesIs) {
                int dpi = Utils.calculate(getHigh(), getWidth(), getInches());
                vDpi.setText(dpi + getString(R.string.dpi));
                vTarget.setText(Utils.setTarget(dpi));
                success = true;
            }
            if (success) {
                vCalcButton.setText(R.string.button_clear);
                vCalcButton.setOnClickListener(clearListener);
            }
        }
    };
    //Click on button "Clear"
    View.OnClickListener clearListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            clear();
            vCalcButton.setText(R.string.calculate);
            vCalcButton.setOnClickListener(clkCalc);
        }
    };

    //Method makes all fields empty
    public void clear() {
        vInputHigh.setText("");
        vInputWidth.setText("");
        vInputInches.setText("");
        vDpi.setText("");
        vTarget.setText("");
    }

    public double getHigh() {
        String h = vInputHigh.getText().toString();
        return Double.parseDouble(h);
    }

    public double getWidth() {
        String w = vInputWidth.getText().toString();
        return Double.parseDouble(w);
    }

    public double getInches() {
        String i = vInputInches.getText().toString();
        return Double.parseDouble(i);

    }


}
