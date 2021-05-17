package com.entretientPharmaceutiquePatient.model;

public class QuestionModel {
    public String titre;
    public String type;
    public String placeholder;

    public QuestionModel(String type, String titre, String placeholder){
        this.type = type;
        this.titre = titre;
        this.placeholder = placeholder;
    }
}
