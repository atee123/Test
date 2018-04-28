package com.fitness.healthapp;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Spinner;

public class SignupActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //mBuilder.setSingleChoiceItems();

        //ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(SignupActivity.this,
                //android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.namesage));
        //mBuilder.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //mBuilder.setAdapter(myAdapter);

    }


}
