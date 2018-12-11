package com.fitness.healthapp.Activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Entity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.fitness.healthapp.Date;
import com.fitness.healthapp.R;

import java.util.Arrays;
import java.util.Calendar;

public class setting1 extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, AdapterView.OnItemSelectedListener{


    private Switch aSwitch;
    private Spinner spinner_active, BirthSelection, spinnerZodiac;
    private Button bmishowButton, saveButton;
    private RadioButton male, female, rb;
    private String gender, spinnerItem, spinnerLevel;
    private RadioGroup radioGroup;
    private TextView result, result1;
    private EditText height, weight;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String SPINER_ACTIVE = "spinnerActive";
    public static final String SPINER_BIRTH = "spinnerBirth";
    public static final String EDIT_TEXT_HEIGHT = "editTextHeight";
    public static final String EDIT_TEXT_WEIGHT = "editTextWeight";
    public static final String TEXT = "text";
    public static final String TEXT1 = "text";
    public static final String RADIO_GROUP = "radioGroup";
    public static final String RADIO_BUTTON = "radioButton";
    public static final String SWITCH1 = "switch1";
    public static final int CHOICE_ITEM = 0;


    private String text, text1, text2, text3, text4;
    private int choice;
    private boolean switchOnOff;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_setting );
        height = (EditText)findViewById( R.id.height );
        weight = (EditText)findViewById( R.id.weight );
        result = (TextView)findViewById( R.id.Result );
        bmishowButton = (Button)findViewById( R.id.Letsbutton );
        result1 = (TextView)findViewById( R.id.ResultInDialog );
        saveButton = (Button)findViewById( R.id.save_setting_data );
        aSwitch = (Switch)findViewById( R.id.switch1 );

        gender = "";
        spinnerItem = "";
        spinnerLevel = "";


        //Radio Group Method initilization

        RadioGroup radioSex = (RadioGroup) findViewById(R.id.radioSex);
        radioSex.setOnCheckedChangeListener(this);


        // Spinner Initialization

        BirthSelection = (Spinner) findViewById(R.id.spinner_Birth);
        // Populate the spinner with data source
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Select_Birth, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        BirthSelection.setAdapter(adapter);

        BirthSelection.setOnItemSelectedListener(this);



        // spinner 2 initialize

        spinner_active = (Spinner)findViewById( R.id.select_level_spinner );

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource( this, R.array.Level_Select, android.R.layout.simple_spinner_item );
        adapter1.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item );
        spinner_active.setAdapter( adapter1 );

        spinner_active.setOnItemSelectedListener( this );


        /*Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );*/

        /*FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
                        .setAction( "Action", null ).show();
            }
        } );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );*/

        //genderSelection();
        //levelSpinner();
        //selectBirth();
        showBMI();
        saveData();
        loadData();
        updateViews();

        /*selectHeight();
        selectWeight();*/
        //bmiCalculate();





    }
    public void levelSpinner(){



    }


    public void showBMI(){

        bmishowButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI( );
            }
        } );

    }

    public void calculateBMI() {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (heightStr != null && !"".equals(heightStr)
                && weightStr != null  &&  !"".equals(weightStr)) {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);

            float bmi = weightValue / (heightValue * heightValue);

            displayBMI(bmi);
        }
    }

    private void displayBMI(float bmi) {
        String bmiLabel = "";

            if (Float.compare(bmi, 15f) <= 0) {
                bmiLabel = getString(R.string.very_severely_underweight);
            } else if (Float.compare(bmi, 15f) > 0  &&  Float.compare(bmi, 16f) <= 0) {
                bmiLabel = getString(R.string.severely_underweight);
            } else if (Float.compare(bmi, 16f) > 0  &&  Float.compare(bmi, 18.5f) <= 0) {
                bmiLabel = getString(R.string.underweight);
            } else if (Float.compare(bmi, 18.5f) > 0  &&  Float.compare(bmi, 25f) <= 0) {
                bmiLabel = getString(R.string.normal);
            } else if (Float.compare(bmi, 25f) > 0  &&  Float.compare(bmi, 30f) <= 0) {
                bmiLabel = getString(R.string.overweight);
            } else if (Float.compare(bmi, 30f) > 0  &&  Float.compare(bmi, 35f) <= 0) {
                bmiLabel = getString(R.string.obese_class_i);
            } else if (Float.compare(bmi, 35f) > 0  &&  Float.compare(bmi, 40f) <= 0) {
                bmiLabel = getString(R.string.obese_class_ii);
            } else {
                bmiLabel = getString(R.string.obese_class_iii);
            }

        bmiLabel = bmi + "\n\n" + bmiLabel;

        final Dialog dialog = new Dialog (setting1.this);

        dialog.setContentView( R.layout.activity_bmi );
        dialog.setTitle( "Your BMI is " );
        TextView textView = (TextView) dialog.findViewById( R.id.ResultInDialog );

        String bmiLabel2 = bmiLabel;

        textView.setText( bmiLabel2 );

        dialog.show();

        result.setText( bmiLabel2 );
        //onPositionButtonClicked();
    }


    private void onPositionButtonClicked(){

        Intent intent = new Intent( this, MenuBar.class );
        startActivity( intent );

    }

    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this
                , MenuBar.class);
        startActivity(intent);
    }

    public void saveData(){

        saveButton.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                saveInSharedPref();
            }
        } );
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {

        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton)radioGroup.findViewById(radioButtonId);
        gender = radioButton.getText().toString();

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        spinnerItem = parent.getItemAtPosition( position ).toString();

        spinnerLevel = parent.getItemAtPosition( position ).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void saveInSharedPref() {

        SharedPreferences sharedPreferences = getSharedPreferences( SHARED_PREFS, MODE_PRIVATE );
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean( SWITCH1, aSwitch.isChecked());
        editor.putString( TEXT, result.getText().toString() );
        editor.putString( EDIT_TEXT_HEIGHT, height.getText().toString() );
        editor.putString( EDIT_TEXT_WEIGHT, weight.getText().toString() );
        editor.putString( "gender", gender );
        editor.putString( "spinnerItem", spinnerItem );
        editor.putString( "spinnerLevel", spinnerLevel );

        editor.apply();
        Toast.makeText( this, "Data Saved", Toast.LENGTH_SHORT ).show();

    }

    public void loadData(){

        SharedPreferences sharedPreferences = getSharedPreferences( SHARED_PREFS, MODE_PRIVATE );
        text = sharedPreferences.getString( TEXT, "" );
        switchOnOff = sharedPreferences.getBoolean( SWITCH1, false );
        text1 = sharedPreferences.getString( EDIT_TEXT_HEIGHT, "" );
        text2 = sharedPreferences.getString( EDIT_TEXT_WEIGHT, "" );
        gender = sharedPreferences.getString( "gender", "" );
        spinnerItem = sharedPreferences.getString( "spinnerItem", "" );
        spinnerLevel = sharedPreferences.getString( "spinnerLevel", "" );


    }

    public void updateViews(){

        result.setText( text );
        aSwitch.setChecked(switchOnOff);
        height.setText( text1 );
        weight.setText( text2 );

        male = (RadioButton)findViewById( R.id.radioMale );
        female = (RadioButton)findViewById( R.id.radioFemale );

        if(gender.equals( "Male" )){
            male.setChecked( true );
        }
        else if (gender.equals( "Female" )){

            female.setChecked( true );
        }
        else {

            male.setChecked( false );
            female.setChecked( false );
        }


        Resources resources1 = getResources();

        String[] LevelArray = resources1.getStringArray( R.array.Level_Select );

        for(int j = 0; j < LevelArray.length; j++){

            if(LevelArray[j].equals(spinnerLevel)){

                ((Spinner)findViewById(R.id.select_level_spinner)).setSelection(j);

            }

        }

        Resources resources = getResources();

        String[] BirthArray = resources.getStringArray( R.array.Select_Birth );

        for(int i = 0; i < BirthArray.length; i++){

            if(BirthArray[i].equals(spinnerItem)){

                ((Spinner)findViewById(R.id.spinner_Birth)).setSelection(i);

            }

        }







    }









}

