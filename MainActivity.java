package com.example.jameswelch.fahrenheitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.Button;
//HAVE TO IMPORT BOTH OF THESE FOR ONCLICKLISTENER
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button applyButton = (Button) findViewById(R.id.applyButton);

        RadioButton fToC = (RadioButton) findViewById(R.id.FtoC);
        fToC.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                final String LOG_TAG = MainActivity.class.getSimpleName();
                Log.d(LOG_TAG, "User Clicked -- Fahrenheit to Celsius");
                final TextView userInput = (TextView) findViewById(R.id.userTextInput);
                final TextView userOutput = (TextView) findViewById(R.id.output);
                userInput.setHint("Enter Fahrenheit");
                userOutput.setText("Celsius Conversion");


                applyButton.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CharSequence cs = userInput.getText();
                        double number;
                        try{
                            //converting equation
                            final StringBuilder sb = new StringBuilder(cs.length());
                            sb.append(cs);
                            number = (Double.parseDouble(cs.toString()) - 32) * (5/9.0);
                            userOutput.setText(String.valueOf(number));
                        }catch(Exception e){
                            userOutput.setText("Input must be a digit");
                        }
                    }
                });
            }

        });
        //Celsius to Fahrenheit
        RadioButton cToF = (RadioButton) findViewById(R.id.CtoF);
        cToF.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //if user clicks on "Celsius to Fahrenheit"
                final String LOG_TAG = MainActivity.class.getSimpleName();
                Log.d(LOG_TAG, "User Clicked Celsius to Fahrenheit");
                final TextView userInput = (TextView) findViewById(R.id.userTextInput);
                final TextView userOutput = (TextView) findViewById(R.id.output);
                userInput.setHint("Enter Celsius");
                userOutput.setText("Fahrenheit Conversion");


                // if applyButton is clicked, this try- catch statement will run
                applyButton.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // allows user inputted text to be turned into double
                        CharSequence cs = userInput.getText();
                        double number;
                        try {
                            //converting equation
                            final StringBuilder sb = new StringBuilder(cs.length());
                            sb.append(cs);
                            //this is where the celsius conversion takes place
                            number = (Double.parseDouble(cs.toString()) * 1.8) + 32;
                            userOutput.setText(String.valueOf(number));
                        } catch (Exception e) {
                            userOutput.setText("Input must be a digit");
                        }
                    }
                });



            }


        });
    }
}
