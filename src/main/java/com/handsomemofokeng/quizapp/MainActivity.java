package com.handsomemofokeng.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static com.handsomemofokeng.quizapp.ApplicationClass.USER_RESPONSE;
import static com.handsomemofokeng.quizapp.ApplicationClass.getSelectedCheckBoxes;
import static com.handsomemofokeng.quizapp.ApplicationClass.getSelectedRadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton rdVoid, rdStatic, rdInt, rdPublic;
    CheckBox chkProtected, chkString, chkPublic, chkPrivate;
    EditText etQuestion3, etQuestion4, etQuestion5;
    Answers answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rdVoid = findViewById(R.id.rdVoid);
        rdStatic = findViewById(R.id.rdStatic);
        rdInt = findViewById(R.id.rdInt);
        rdPublic = findViewById(R.id.rdPublic);

        chkProtected = findViewById(R.id.chkProtected);
        chkString = findViewById(R.id.chkString);
        chkPublic = findViewById(R.id.chkPublic);
        chkPrivate = findViewById(R.id.chkPrivate);

        etQuestion3 = findViewById(R.id.etQuestion3);
        etQuestion4 = findViewById(R.id.etQuestion4);
        etQuestion5 = findViewById(R.id.etQuestion5);


    }

    public void onClickSubmit(View view) {
        if (isRadioValid(rdPublic, rdInt, rdStatic, rdVoid)) {
            if (isCheckValid(chkPrivate, chkPublic, chkString, chkProtected)) {
                if (isEditTextValid(etQuestion3, etQuestion4, etQuestion5)) {
                    answers = new Answers(getSelectedRadioButton(rdInt, rdPublic,rdStatic, rdVoid),
                            getSelectedCheckBoxes(chkProtected, chkString, chkPublic, chkPrivate),
                            etQuestion3.getText().toString().trim(),
                            etQuestion4.getText().toString().trim(),
                            etQuestion5.getText().toString().trim());
                    Intent results = new Intent(getApplicationContext(), ResultsActivity.class);
                    results.putExtra(USER_RESPONSE, answers);
                    startActivity(results);
                }
            } else {
                showToast("Please tick correct answers for question 2");
            }
        } else {
            showToast("Please select an option on question 1");
        }
    }

    private boolean isEditTextValid(EditText... etQuestions) {
        boolean isValidET = true;
        for (EditText et : etQuestions) {
            if (et.getText().toString().trim().isEmpty()){
                isValidET = false;
            }
        }
        return isValidET;
    }

    private boolean isCheckValid(CheckBox... chkBoxes) {
        boolean isChecked = false;

        for (CheckBox chk : chkBoxes) {
            if (chk.isChecked())
                isChecked = true;
        }

        return isChecked;
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private boolean isRadioValid(RadioButton... rdBtns) {
        boolean isSelected = false;
        for (RadioButton rd : rdBtns) {
            if (rd.isSelected()) {
                isSelected = true;
                break;
            }

        }
        return isSelected;
    }
}
