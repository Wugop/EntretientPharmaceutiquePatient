package com.entretientPharmaceutiquePatient.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.entretientPharmaceutiquePatient.R;
import com.entretientPharmaceutiquePatient.model.GroupQuestionModel;
import com.entretientPharmaceutiquePatient.model.QuestionModel;

import java.util.ArrayList;

public class QuestionGroupFragment extends Fragment {
    int indexGroupQuestion;

    GroupQuestionModel groupQuestionModel = new GroupQuestionModel();

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        injecterGroupQuestion();


    }


    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_question_group, container, false);
    }


    public void injecterGroupQuestion() {


        //inject les questions dans le groupe de question
        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        GroupQuestionModel groupQuestion = groupQuestionModel;

        for (int i = 0; i < groupQuestion.questionModels.size(); i++) {
            switch(i) {
                case 0:
                    transaction.replace(R.id.Question1, new QuestionFragment(groupQuestion.questionModels.get(i).type));
                    break;
                case 1:
                    transaction.replace(R.id.Question2, new QuestionFragment(groupQuestion.questionModels.get(i).type));
                    break;
                case 2:
                    transaction.replace(R.id.Question3, new QuestionFragment(groupQuestion.questionModels.get(i).type));
                    break;
            }

        }

        transaction.addToBackStack(null);
        transaction.commit();

    }
}
