package com.entretientPharmaceutiquePatient.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.entretientPharmaceutiquePatient.R;

import org.jetbrains.annotations.NotNull;

public class QuestionFragment extends Fragment {
    String type;

    public QuestionFragment(String type){
        this.type = type;
    }

    @Override
    public View onCreateView(@NonNull @org.jetbrains.annotations.NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        return choixDuLayout(inflater,container);
    }

    private View choixDuLayout(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container){
        switch (type){
            case "short": return inflater.inflate(R.layout.short_question, container, false);
            case "long" : return inflater.inflate(R.layout.long_question, container, false);
        }
        return null;
    }
}
