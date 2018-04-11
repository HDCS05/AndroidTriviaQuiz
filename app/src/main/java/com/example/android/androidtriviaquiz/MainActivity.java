package com.example.android.androidtriviaquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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
        gNumberSeekbar = (TextView) findViewById(R.id.number_question2);
        gSeekbar = (SeekBar) findViewById(R.id.seekbar_question2);
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
        int vRightAnswers = checkQuestion1();
        vRightAnswers += checkQuestion2();
        vRightAnswers += checkQuestion3();
        vRightAnswers += checkQuestion4();
        vRightAnswers += checkQuestion5();
        vRightAnswers += checkQuestion6();

        String vRA = Integer.toString(vRightAnswers);

        /*Create the message to display*/
        String vMessage = getString(R.string.message, vRA);
        if (vRightAnswers == 6) {
            vMessage += "\n" + getString(R.string.congrats);
        } else {
            vMessage += "\n" + getString(R.string.checkAgain);
        }

        /*Display score in a toast message, text will be center aligned in the toast and screen*/
        Toast vTextToast = Toast.makeText(getApplicationContext(), vMessage, Toast.LENGTH_LONG);
        TextView vTextToCenter = (TextView) vTextToast.getView().findViewById(android.R.id.message);
        /*To center the text in the toast*/
        if (vTextToCenter != null) vTextToCenter.setGravity(Gravity.CENTER);
        /*To center the toast on the screen*/
        vTextToast.setGravity(Gravity.CENTER, 0, 0);
        /*Now we show the toast*/
        vTextToast.show();

    }

    private int checkQuestion1() {
        RadioButton vRbQ1 = (RadioButton) findViewById(R.id.radioButtonQ1);
        boolean isSelected = vRbQ1.isChecked();
        RadioGroup vRgQ1 = (RadioGroup) findViewById(R.id.radioGroupQ1);
        vRgQ1.clearCheck();
        if (isSelected) {
            return 1;
        } else {
            return 0;
        }
    }

    private int checkQuestion2() {
        int vNumSeekbar = Integer.parseInt(gNumberSeekbar.getText().toString());
        gSeekbar.setProgress(0);
        if (vNumSeekbar == 50) {
            return 1;
        } else {
            return 0;
        }
    }

    private int checkQuestion3() {
        CheckBox vCbQ3a = (CheckBox) findViewById(R.id.checkbox_question3a);
        boolean isCheckedHoney = vCbQ3a.isChecked();
        CheckBox vCbQ3b = (CheckBox) findViewById(R.id.checkbox_question3b);
        boolean isCheckedDonut = vCbQ3b.isChecked();
        CheckBox vCbQ3c = (CheckBox) findViewById(R.id.checkbox_question3c);
        boolean isCheckedCroissant = vCbQ3c.isChecked();
        vCbQ3a.setChecked(false);
        vCbQ3b.setChecked(false);
        vCbQ3c.setChecked(false);
        if ((isCheckedHoney) && (isCheckedDonut) && (isCheckedCroissant)) {
            return 0;
        } else if ((isCheckedHoney) && (isCheckedDonut)) {
            return 1;
        } else {
            return 0;
        }
    }

    private int checkQuestion4() {
        EditText vNameDessert = (EditText) findViewById(R.id.field_question4);
        String vDessertName = vNameDessert.getText().toString();
        vNameDessert.getText().clear();
        if (vDessertName.equalsIgnoreCase("froyo")) {
            return 1;
        } else {
            return 0;
        }
    }

    private int checkQuestion5() {
        RadioButton vRbQ5 = (RadioButton) findViewById(R.id.radioButtonQ5);
        boolean isSelected = vRbQ5.isChecked();
        RadioGroup vRgQ5 = (RadioGroup) findViewById(R.id.radioGroupQ5);
        vRgQ5.clearCheck();
        if (isSelected) {
            return 1;
        } else {
            return 0;
        }
    }

    private int checkQuestion6() {
        CheckBox vCbQ6a = (CheckBox) findViewById(R.id.checkbox_question6a);
        boolean isCheckedBlogger = vCbQ6a.isChecked();
        CheckBox vCbQ6b = (CheckBox) findViewById(R.id.checkbox_question6b);
        boolean isCheckedGmail = vCbQ6b.isChecked();
        CheckBox vCbQ6c = (CheckBox) findViewById(R.id.checkbox_question6c);
        boolean isCheckedSnapseed = vCbQ6c.isChecked();
        vCbQ6a.setChecked(false);
        vCbQ6b.setChecked(false);
        vCbQ6c.setChecked(false);
        if ((isCheckedBlogger) && (isCheckedGmail) && (isCheckedSnapseed)) {
            return 1;
        } else {
            return 0;
        }
    }

}
