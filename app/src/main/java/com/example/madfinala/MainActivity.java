package com.example.madfinala;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView ageCounter; // THIS IS THE COUNTER FOR THE AGE
    private Button plusButton; // THIS IS FOR THE PLUS BUTTON
    private Button minusButton; // THIS IS FOR THE MINUS BUTTON
    private Button clearButton; // THIS IS FOR THE CLEAR BUTTON
    private Button maxButton; // this is for the MAX HEART RATE BUTTON
    private TextView maxRate; // this is the your MAX HEART RATE
    private int counter;
    private int maxHeartRate;
    private Button targetButton;
    private TextView targetRate;
    private double targetHeartRateHigh;
    private double targetHeartRateLow;

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            switch(view.getId())
            {
                case R.id.minusButton :
                    minusCounter();
                    break;
                case R.id.plusButton :
                    plusCounter();
                    break;
                case R.id.clearButton :
                    clear(); // this function will always make the age value start at "0"
                    break;
                case R.id.CalculateMaxHeartRateButton :
                    maxHeartBeat();
                    break;
                case R.id.Calculate_Target_Heart_Rate :
                    targetHeartRate();
                    break;
            }


        }

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ageCounter = (TextView) findViewById(R.id.ageValue); // assigns ageCounter to my "ageValue TextView"
        maxRate = (TextView) findViewById(R.id.MaxHeartBeatView);// assigns maxRate to my "MaxHeartBeatView TextView"
        targetRate = (TextView) findViewById(R.id.targetHeartBeatView);// assigns targetRate to my "targetHeartBeatViewTextView"

        minusButton = (Button) findViewById(R.id.minusButton);// assigns minusButton to my "minusButton"
        minusButton.setOnClickListener(clickListener); // this is waiting for the click!

        plusButton = (Button) findViewById(R.id.plusButton); // assigns plusButton to my plusButton
        plusButton.setOnClickListener(clickListener); // this is waiting for the click!

        clearButton = (Button) findViewById(R.id.clearButton);//assigns clearButton to my clearButton
        clearButton.setOnClickListener(clickListener); // this is waiting for the click!

        maxButton = (Button) findViewById(R.id.CalculateMaxHeartRateButton);//assign maxButton to my CalculateMaxHeartRateButton
        maxButton.setOnClickListener(clickListener); // this is waiting for the click!

        targetButton = (Button) findViewById(R.id.Calculate_Target_Heart_Rate);// assigns targetButton to my Calculate_Target_Heart_Rate
        targetButton.setOnClickListener(clickListener); // this is waiting for the click!


        clear();// this is a function call to my function clear()
    }

    private void clear() // this function will always set the age value to "0"
    {
        counter = 0; // this sets the age value to "0" by default.
        maxHeartRate = 0; // sets maxHeartRate to 0
        ageCounter.setText(counter + ""); // this updates the age value once "+" or "-" button is clicked.
        maxRate.setText(maxHeartRate + "");
        targetRate.setText(maxHeartRate + "");
    }

    private void plusCounter() // this function increments the counter when the plus button is being clicked
    {
        if (counter < 220) // can go over 220 because that'll mean your heartbeat will be 0 beats per-minute LOL
        {
            counter++; // this increments the age value when the "+" button is pressed.
            ageCounter.setText(counter + ""); // this updates the age value when the "+" button is pressed.
        }
    }

    private void minusCounter()// this function decrements the counter when the plus button is being clicked
    {
        if( counter > 1) {// wont go lower than one if you go passed 0
            counter--;
            ageCounter.setText(counter + ""); // this updates the age value when the "-" button is pressed.
        }
    }

    private void maxHeartBeat()
    {
        maxHeartRate = 220 - counter; // basically hard codes "your heartbeat"
        maxRate.setText(maxHeartRate  + "");// outputs the maxHeartRate ... when clicked though
    }

    private void targetHeartRate()
    {
        maxHeartRate = 220 - counter;
        targetHeartRateLow = maxHeartRate * 0.5; // This code multiplies your age with 0.5 to get the lower end of the range
        targetHeartRateHigh = maxHeartRate * 0.85;// this code multiplies your age with 0.85 to get the higher end of the range
        targetRate.setText("Your heart beats from: "+ targetHeartRateLow + " to " + targetHeartRateHigh + " Per Minute!"); // this is the output
    }
}