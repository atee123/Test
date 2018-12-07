package com.fitness.healthapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;

import com.fitness.healthapp.R;

import java.util.Arrays;

public class Settings extends AppCompatActivity {


    private Switch aSwitch;
    private Spinner spinner;
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Button button;
    private RadioButton maleButton;
    private RadioButton femaleButton;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_setting );

        genderSelection();
        levelSpinner();

    }

    public void levelSpinner(){

        Spinner spinnerlevel = (Spinner) findViewById(R.id.spinner);


        String [] mLevelchoice = getResources().getStringArray(R.array.Level_Select);
        Arrays.sort (mLevelchoice, 1, mLevelchoice.length);
        ArrayAdapter<String> profession = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, mLevelchoice);

        profession.setDropDownViewResource (android.R.layout.simple_list_item_1);
        spinnerlevel.setAdapter(profession);
    }

    public void genderSelection(){

        radioGroup = (RadioGroup) findViewById( R.id.radioSex );
        maleButton = (RadioButton) findViewById( R.id.radioMale );
        femaleButton = (RadioButton)findViewById( R.id.radioFemale );
    }

}
