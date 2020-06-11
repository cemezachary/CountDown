package com.example.countdown;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button startTimer;
    TextView displayText;
    EditText timerLength;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startTimer = findViewById(R.id.startButton);
        displayText = findViewById(R.id.displayText);
        timerLength = findViewById(R.id.timerLength);

        startTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = timerLength.getText().toString();
                int startTime = Integer.parseInt(input);

                new CountDownTimer(startTime*1000, 1000){

                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onTick(long millisUntilFinished) {
                        displayText.setText(millisUntilFinished/1000 + " seconds remaining");
                    }

                    @Override
                    public void onFinish() {
                        displayText.setText("done!");
                    }
                }.start();
            }
        });
    }
}
