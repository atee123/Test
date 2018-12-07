package com.fitness.healthapp.Activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
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

import com.fitness.healthapp.R;

import java.util.Arrays;

public class setting1 extends AppCompatActivity {


    private Switch aSwitch;
    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Button button;
    private RadioButton maleButton;
    private RadioButton femaleButton;
    private RadioGroup radioGroup;
    private TextView yearDisplay, result, result1;
    private EditText height, weight;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_setting );
        height = (EditText)findViewById( R.id.height );
        weight = (EditText)findViewById( R.id.weight );
        result = (TextView)findViewById( R.id.Result );
        button = (Button)findViewById( R.id.Letsbutton );
        result1 = (TextView)findViewById( R.id.ResultInDialog );


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

        genderSelection();
        levelSpinner();
        selectBirth();
        /*selectHeight();
        selectWeight();*/
        //bmiCalculate();

        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI( );
            }
        } );

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

    public void selectBirth(){

        spinner1 = (Spinner)findViewById( R.id.spinner_Birth );
        yearDisplay = (TextView)findViewById( R.id.dateofbirth );


        spinner1.setOnTouchListener( new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                //Toast.makeText ( setting1.this, "test", Toast.LENGTH_SHORT );
                final Dialog d = new Dialog(setting1.this);
                d.setContentView(R.layout.numberpicker);
                d.setTitle("Birth Year!");
                final NumberPicker np = (NumberPicker)d.findViewById(R.id.numberPicker2);
                np.setMaxValue(1908);
                np.setMinValue(1900);
                np.setValue(1905);
                np.setWrapSelectorWheel(false);

                np.setOnValueChangedListener( new NumberPicker.OnValueChangeListener() {

                    @Override
                    public void onValueChange(final NumberPicker picker, final int oldVal, final int newVal) {
                        yearDisplay.setText( "" + newVal);
                    }
                } );

                d.show();
                return true;
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
}

