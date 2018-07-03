package com.handsomemofokeng.quizapp;

import android.app.Application;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class ApplicationClass extends Application {
    static String q1 = "void",
            q2 = "protected, public, private",
            q3 = "@Override",
            q4 = "int x = 3;",
            q5 = "51234";
    public static final String USER_RESPONSE = "user_responses";


    public static String getSelectedRadioButton(RadioButton... rdButtons) {
        String selectedButton = "";
        for (RadioButton rd : rdButtons) {
            if (rd.isSelected())
                selectedButton = rd.getText().toString();
        }
        return selectedButton;
    }

    public static String getSelectedCheckBoxes(CheckBox... checkBoxes) {
        String isCorrect = "";

        for (CheckBox chk : checkBoxes) {
            if (chk.isChecked()){
                isCorrect+= chk.toString();
            }
        }

        return isCorrect;
    }

    public static int generateScore(Answers answers) {
        int score = 0;

        if (answers.getQuestion1().equalsIgnoreCase(q1)) {
            score++;
        }
        if (answers.getQuestion2().equalsIgnoreCase(q2)) {
            score++;
        }
        if (answers.getQuestion3().equalsIgnoreCase(q3)) {
            score++;
        }
        if (answers.getQuestion4().equalsIgnoreCase(q4)) {
            score++;
        }
        if (answers.getQuestion5().equalsIgnoreCase(q5)) {
            score++;
        }

        return score;
    }


}
