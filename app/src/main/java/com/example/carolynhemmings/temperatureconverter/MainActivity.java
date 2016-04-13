package com.example.carolynhemmings.temperatureconverter;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    /*
        Formulas:
        C = ([F] - 32) * 5/9 --> From Fahrenheit to Celsius
        F = [C] * 9/5 + 32 --> From Celsius to Fahrenheit
     */

    private EditText tempEditText;
    private Button celButton;
    private Button fButton;
    private TextView showTempTextView;
    private TextView displayResult;

    DecimalFormat round = new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tempEditText = (EditText) findViewById(R.id.editText);
        celButton = (Button) findViewById(R.id.celsiusButtonId);
        fButton = (Button) findViewById(R.id.fButtonId);
        showTempTextView = (TextView) findViewById(R.id.textView2);
        displayResult = (TextView) findViewById(R.id.displayResult);

        celButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call to convertToCelsius()

                //Always convert EditText to string first or you get gibberish
                String editTextVal = tempEditText.getText().toString();

                //First validate that a value has been entered
                if(editTextVal.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter a Value", Toast.LENGTH_LONG).show();
                } else {
                    //convert EditText string into a number
                    double intEditText = Double.parseDouble(editTextVal);

                    double convertedVal = convertToCelsius(intEditText);

                    //converts convertedVal back to a string
                    String stringResult = String.valueOf(round.format(convertedVal));
                    showTempTextView.setText(stringResult + " C");
                }

            }
        });

        fButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call to convertToFahrenheit()

                //Always convert EditText to string first or you get gibberish
                String editTextVal = tempEditText.getText().toString();

                //First validate that a value has been entered
                if(editTextVal.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter a Value", Toast.LENGTH_LONG).show();
                } else {
                    //convert EditText string into a number
                    double intEditText = Double.parseDouble(editTextVal);

                    double convertedVal = convertToFahrenheit(intEditText);

                    //converts convertedVal back to a string
                    String stringResult = String.valueOf(round.format(convertedVal));
                    showTempTextView.setText(stringResult + " F");
                }


            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public double convertToCelsius(double farVal) {
        // C = ([F] - 32) * 5/9 --> From Fahrenheit to Celsius
        double resultCel = (farVal - 32) * 5/9;
        return resultCel;
    }

    public double convertToFahrenheit(double celVal) {
        // F = [C] * 9/5 + 32 --> From Celsius to Fahrenheit
        double resultFahr = (celVal * 9/5) + 32;
        return resultFahr;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
