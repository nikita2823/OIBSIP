package com.example.stopwatch3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    int seconds=0;
    boolean isRunning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.timerText);

        stratTimer();
    }
    public void onClickStart(View view){
            isRunning=true;
            }

    public void onClickPause(View view) {
            isRunning=false;

        }

    public void onClickReset(View view){
            isRunning=false;
            seconds=0;
        }

    public void stratTimer() {
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                int s = seconds % 60;
                int m = seconds % 60;
                int h = m / 60;
                if (isRunning){
                    seconds++;
                }


                String formatString = String.format(Locale.getDefault(), "%02d:%02d:%02d", h, m, s);

                textView.setText(formatString);
                handler.postDelayed(this, 1000);

            }
        };
        handler.post(runnable);
    }

    }


