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

    private EditText temperatureEditText;
    private Button celsiusButton;
    private Button fahrenheitButton;
    private TextView showTemperatureTextView;
    private TextView displayResult;

    DecimalFormat round = new DecimalFormat("0.0");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        temperatureEditText = (EditText) findViewById(R.id.editText);
        celsiusButton = (Button) findViewById(R.id.celsiusButtonId);
        fahrenheitButton = (Button) findViewById(R.id.fButtonId);
        showTemperatureTextView = (TextView) findViewById(R.id.textView2);
        displayResult = (TextView) findViewById(R.id.displayResult);

        celsiusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call to convertToCelsius()

                //Always convert EditText to string first or you get gibberish
                String editTextValue = temperatureEditText.getText().toString();

                //First validate that a value has been entered
                if (editTextValue.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter a Value", Toast.LENGTH_LONG).show();
                } else {
                    //convert EditText string into a number
                    double intEditText = Double.parseDouble(editTextValue);

                    double convertedVal = convertToCelsius(intEditText);

                    //converts convertedVal back to a string
                    String stringResult = String.valueOf(round.format(convertedVal));
                    showTemperatureTextView.setText(stringResult + " C");
                }

            }
        });

        fahrenheitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //call to convertToFahrenheit()

                //Always convert EditText to string first or you get gibberish
                String editTextVal = temperatureEditText.getText().toString();

                //First validate that a value has been entered
                if (editTextVal.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Enter a Value", Toast.LENGTH_LONG).show();
                } else {
                    //convert EditText string into a number
                    double intEditText = Double.parseDouble(editTextVal);

                    double convertedVal = convertToFahrenheit(intEditText);

                    //converts convertedVal back to a string
                    String stringResult = String.valueOf(round.format(convertedVal));
                    showTemperatureTextView.setText(stringResult + " F");
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

    public double convertToCelsius(double farenheitValue) {
        // C = ([F] - 32) * 5/9 --> From Fahrenheit to Celsius
        double CelsiusResult = (farenheitValue - 32) * 5/9;
        return CelsiusResult;
    }

    public double convertToFahrenheit(double celsiusValue) {
        // F = [C] * 9/5 + 32 --> From Celsius to Fahrenheit
        double farenheitResult = (celsiusValue * 9/5) + 32;
        return farenheitResult;
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
