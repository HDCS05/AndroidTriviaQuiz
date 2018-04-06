package com.example.android.androidtriviaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    /* This 2 global variables are for the seekbar on question #2 */
    TextView gNumberSeekbar;
    SeekBar gSeekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listenSeekbar();

    }

    private void listenSeekbar() {
        gNumberSeekbar = (TextView)findViewById(R.id.number_question2);
        gSeekbar = (SeekBar)findViewById(R.id.seekbar_question2);
        gSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String vSeekbarValue = String.valueOf(i);
                gNumberSeekbar.setText(vSeekbarValue);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void submitAnswers(View view) {

        /*Check if the answers are right or not*/
        int vScore = checkQuestion1();
//        vScore += checkQuestion2();
//        vScore += checkQuestion3();
//        vScore += checkQuestion4();
//        vScore += checkQuestion5();
//        vScore += checkQuestion6();

        /*Create the message to display*/
        String vMessage = "You have " + vScore +" right answers out of 6";
        if ( vScore == 6 ) {
            vMessage += "\nCongratulations!";
        } else {
            vMessage += "\nCheck your answers!";
        }

        /*Display the score in a toast message*/
        Toast.makeText(getApplicationContext(), vMessage, Toast.LENGTH_SHORT).show();

    }

    private int checkQuestion1() {
        RadioButton vRbQuestion1 = (RadioButton) findViewById(R.id.radioButtonQ1);
        boolean isSelected = vRbQuestion1.isChecked();
        RadioGroup vRgQuestion1 = (RadioGroup) findViewById(R.id.radioGroupQ1);
        vRgQuestion1.clearCheck();
        if (isSelected) {
            return 1;
        } else {
            return 0;
        }
    }

//    private int checkQuestion2() {
//
//    }
//
//    private int checkQuestion3() {
//
//    }
//
//    private int checkQuestion4() {
//
//    }
//
//    private int checkQuestion5() {
//
//    }
//
//    private int checkQuestion6() {
//
//    }


}
