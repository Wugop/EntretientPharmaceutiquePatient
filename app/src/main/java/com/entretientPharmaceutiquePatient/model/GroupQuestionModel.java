package com.entretientPharmaceutiquePatient.model;

import java.util.ArrayList;

public class GroupQuestionModel {
    int ordre;
    String titre;
    public ArrayList<QuestionModel> questionModels = new ArrayList<>();


    public GroupQuestionModel(){
        QuestionModel q1 = new QuestionModel("short", "Je suis la question 1", "Ex: Repondre à la question 1");
        QuestionModel q2 = new QuestionModel("short", "Je suis la question 2", "Ex: Repondre à la question 2");
        QuestionModel q3 = new QuestionModel("short", "Je suis la question 3", "Ex: Repondre à la question 3");

        ajouteQuestion(q1);
        ajouteQuestion(q2);
        ajouteQuestion(q3);
    }

    public void ajouteQuestion(QuestionModel question){
        questionModels.add(question);
    }
}
