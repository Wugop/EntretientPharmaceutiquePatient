package com.entretientPharmaceutiquePatient.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.nfc.Tag;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.DatePicker;
import android.widget.EditText;

import com.entretientPharmaceutiquePatient.R;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.logging.Logger;

public class InformationPerso extends AppCompatActivity {

    private static final String TAG = "InformationPerso";

    private EditText Date;
    private DatePickerDialog.OnDateSetListener mDateSetListener;



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
        EditText PhoneNumber = (EditText) findViewById(R.id.profil_phone_number);

        PhoneNumber.addTextChangedListener(new TextWatcher() {
            int inputlength = 0;
            String subString;
            char charAt;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { /*Empty*/}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                inputlength = PhoneNumber.getText().toString().length();
                PhoneNumber.setSelection(inputlength);


                if (inputlength != 0) {
                    if (inputlength % 3 == 0 && PhoneNumber.getText().toString().charAt(inputlength - 1) != ' ') {
                        subString = PhoneNumber.getText().toString().substring(0, inputlength - 1);
                        charAt = PhoneNumber.getText().toString().charAt(inputlength - 1);
                        PhoneNumber.setText(subString + ' ' + charAt);
                    }

                    if (inputlength % 3 == 0 && PhoneNumber.getText().toString().charAt(inputlength - 1) == ' ') {
                        PhoneNumber.setText(PhoneNumber.getText().toString().substring(0, inputlength - 1));
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Format numéro de securté social
        EditText SecurityNumber = (EditText) findViewById(R.id.profil_social_security_number);

        SecurityNumber.addTextChangedListener(new TextWatcher() {
            int inputlengthSecurityNumber = 0;
            String subStringSecurityNumber;
            char charAtSecurityNumber;

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { /*Empty*/}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                inputlengthSecurityNumber = SecurityNumber.getText().toString().length();
                SecurityNumber.setSelection(inputlengthSecurityNumber);


                if (inputlengthSecurityNumber != 0) {
                    if ((inputlengthSecurityNumber == 2 || inputlengthSecurityNumber == 5 || inputlengthSecurityNumber == 8 || inputlengthSecurityNumber == 11 || inputlengthSecurityNumber == 15 || inputlengthSecurityNumber == 19) && SecurityNumber.getText().toString().charAt(inputlengthSecurityNumber - 1) != ' ') {
                        subStringSecurityNumber = SecurityNumber.getText().toString().substring(0, inputlengthSecurityNumber - 1);
                        charAtSecurityNumber = SecurityNumber.getText().toString().charAt(inputlengthSecurityNumber - 1);
                        SecurityNumber.setText(subStringSecurityNumber + ' ' + charAtSecurityNumber);
                    }

                    if ((inputlengthSecurityNumber == 2 || inputlengthSecurityNumber == 5 || inputlengthSecurityNumber == 8 || inputlengthSecurityNumber == 11 || inputlengthSecurityNumber == 15 || inputlengthSecurityNumber == 19) && SecurityNumber.getText().toString().charAt(inputlengthSecurityNumber - 1) == ' ') {
                        SecurityNumber.setText(SecurityNumber.getText().toString().substring(0, inputlengthSecurityNumber - 1));
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        //Drop down menu
        AutoCompleteTextView autoCompleteTextView;

        autoCompleteTextView = findViewById(R.id.auto_complete_profil);
        String[]options = {"Regime Général","Regime Agricole","R.A.T.P","C.N.M.S.S","S.N.C.F","Banque de France","E.I.N.M","C.A.N.S.S.M","C.R.P.C.E.N","Professions Indépendantes", "Ministres des cultes","Français de l'étranger", "Chambre de Commerce & de l'Industrie de Paris", "Assemblée Nationale", "Sénat"};
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.option_items_regime_affiliation,options);
        autoCompleteTextView.setAdapter(arrayAdapter);



    }
}