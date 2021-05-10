package com.entretientPharmaceutiquePatient.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;

import com.entretientPharmaceutiquePatient.R;

import java.util.Calendar;

public class InformationPerso extends AppCompatActivity {

    private static final String TAG = "InformationPerso";

    private EditText Date;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    private EditText PhoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_perso);

        //Date Picker
        Date = (EditText) findViewById(R.id.profil_birthday);

        Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        InformationPerso.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month += 1;
                Date.setText(day + "/" + month + "/" + year);
            }
        };

        //Format Number phone
        PhoneNumber = (EditText) findViewById(R.id.profil_phone_number);
        PhoneNumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) { /*Empty*/}

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) { /*Empty*/ }

            @Override
            public void afterTextChanged(Editable s) {

                int inputlength = PhoneNumber.getText().toString().length();

                if (inputlength == 4 ||
                        inputlength == 9 || inputlength == 14){

                    PhoneNumber.setText(PhoneNumber.getText().toString() + " ");

                    int pos = PhoneNumber.getText().length();
                    PhoneNumber.setSelection(pos);
                }
            }
        });
    }
}