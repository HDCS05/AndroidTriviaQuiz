package com.example.android.androidtriviaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    /* This 2 global variables are for the seekbar on question #2 */
    TextView gNumberSeekbar;
    SeekBar gSeekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gNumberSeekbar = (TextView)findViewById(R.id.number_question2);
        gSeekbar = (SeekBar)findViewById(R.id.seekbar_question2);
        gSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String seekbarValue = String.valueOf(i);
                gNumberSeekbar.setText(seekbarValue);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

    }
}
