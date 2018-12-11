package com.fitness.healthapp.Activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Entity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
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

public class setting1 extends AppCompatActivity{


    private Switch aSwitch;
    private Spinner spinner_active, BirthSelection;
    private Button bmishowButton, saveButton;
    private RadioButton maleButton;
    private RadioButton femaleButton;
    private RadioButton rb;
    private RadioGroup radioGroup;
    private TextView result, result1;
    private EditText height, weight;

    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String SPINER_ACTIVE = "spinnerActive";
    public static final String SPINER_BIRTH = "spinnerBirth";
    public static final String EDIT_TEXT_HEIGHT = "editTextHeight";
    public static final String EDIT_TEXT_WEIGHT = "editTextWeight";
    public static final String TEXT = "text";
    public static final String RADIO_GROUP = "radioGroup";
    public static final String SWITCH1 = "switch1";


    private String text, text1, text2, text3, text4;
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
        radioGroup = (RadioGroup) findViewById( R.id.radioSex );
        saveButton = (Button)findViewById( R.id.save_setting_data );
        aSwitch = (Switch)findViewById( R.id.switch1 );




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
        levelSpinner();
        selectBirth();
        showBMI();
        saveData();
        loadData();
        updateViews();

        /*selectHeight();
        selectWeight();*/
        //bmiCalculate();





    }
    public void levelSpinner(){

        spinner_active = (Spinner)findViewById( R.id.spinner );


        String [] mLevelchoice = getResources().getStringArray(R.array.Level_Select);
        Arrays.sort (mLevelchoice, 1, mLevelchoice.length);
        ArrayAdapter<String> profession = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, mLevelchoice);

        profession.setDropDownViewResource (android.R.layout.simple_list_item_1);
        spinner_active.setAdapter(profession);

        //String age = String.valueOf( spinnerlevel.getSelectedItem() );
    }

    public void genderSelection(){


        maleButton = (RadioButton) findViewById( R.id.radioMale );
        femaleButton = (RadioButton)findViewById( R.id.radioFemale );

        Toast.makeText( getBaseContext(), maleButton.getText(), Toast.LENGTH_LONG ).show();
        Toast.makeText( getBaseContext(), femaleButton.getText(), Toast.LENGTH_LONG ).show();
    }

    public void rbclick(View view) {
        int radiobutton = radioGroup.getCheckedRadioButtonId();
        rb = (RadioButton) findViewById( radiobutton );


        Toast.makeText( getBaseContext(),rb.getText(), Toast.LENGTH_SHORT ).show();
    }

    public void selectBirth(){

        BirthSelection = (Spinner)findViewById( R.id.spinner_Birth );
        String [] mYearchoice = getResources().getStringArray(R.array.Select_Birth);
        Arrays.sort (mYearchoice, 1, mYearchoice.length);
        ArrayAdapter<String> profession = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, mYearchoice);

        profession.setDropDownViewResource (android.R.layout.simple_list_item_1);
        BirthSelection.setAdapter(profession);
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

    public void saveInSharedPref() {

        SharedPreferences sharedPreferences = getSharedPreferences( SHARED_PREFS, MODE_PRIVATE );
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean( SWITCH1, aSwitch.isChecked());
        editor.putString( TEXT, result.getText().toString() );
        editor.putString( EDIT_TEXT_HEIGHT, height.getText().toString() );
        editor.putString( EDIT_TEXT_WEIGHT, weight.getText().toString() );
        /*int selectedPosition = BirthSelection.getSelectedItemPosition();
        editor.putInt( "selectedPosition", selectedPosition );*/

        editor.commit();




        editor.apply();
        Toast.makeText( this, "Data Saved", Toast.LENGTH_SHORT ).show();

    }

    public void loadData(){

        SharedPreferences sharedPreferences = getSharedPreferences( SHARED_PREFS, MODE_PRIVATE );

        text = sharedPreferences.getString( TEXT, "" );
        switchOnOff = sharedPreferences.getBoolean( SWITCH1, false );
        text1 = sharedPreferences.getString( EDIT_TEXT_HEIGHT, "" );
        text2 = sharedPreferences.getString( EDIT_TEXT_WEIGHT, "" );
        BirthSelection.setSelection( sharedPreferences.getInt( "spinnerSelection", 0 ) );

    }

    public void updateViews(){

        result.setText( text );
        aSwitch.setChecked(switchOnOff);
        height.setText( text1 );
        weight.setText( text2 );


    }

}

