package com.entretientPharmaceutiquePatient.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.entretientPharmaceutiquePatient.R;
import com.entretientPharmaceutiquePatient.fragment.*;

public class Questionnaire extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        QuestionGroup questionGroup = new QuestionGroup();

        //inject groupe de question dans l'activity
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.questionGroup, questionGroup);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}