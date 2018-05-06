package com.fitness.healthapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import static com.fitness.healthapp.R.id.spinner1;
import static com.fitness.healthapp.R.id.spinner2;
import static com.fitness.healthapp.R.id.spinner3;


public class SignupActivity extends AppCompatActivity{
    private static TextView tv ;
    private static TextView tv1 ;
    private static TextView tv2 ;
    private static TextView tv3 ;
    private static TextView tv4 ;

    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final Spinner startTime = ( Spinner ) findViewById ( spinner1);

        final Spinner setHeight = (Spinner) findViewById( spinner2 );

        final Spinner setWeight = (Spinner)findViewById( spinner3 );

        tv = (TextView)findViewById(R.id.Birthdisp);

        tv1 = (TextView)findViewById( R.id.Heightdisp );
        tv2 = (TextView)findViewById( R.id.height_feet );
        tv3 = (TextView)findViewById( R.id.Height_disp );
        tv4 = (TextView)findViewById( R.id.Height_inch );


        startTime.setOnTouchListener(new View.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //Toast.makeText ( SignupActivity.this, "test", Toast.LENGTH_SHORT );
                picker();
                return false;
            }

        });

        setHeight.setOnTouchListener( new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                AlertDialog.Builder builder = new AlertDialog.Builder( SignupActivity.this );
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.height_dialog,null);
                builder.setTitle( "Height Set" );
                builder.setView(dialogView);

                builder.setPositiveButton( android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                } );

                builder.setNegativeButton( android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                } );

                builder.show();
                return false;
            }
        } );

        setWeight.setOnTouchListener( new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                AlertDialog.Builder builder = new AlertDialog.Builder( SignupActivity.this );
                LayoutInflater inflater = getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.weight_dialog,null);
                builder.setTitle( "Height Set" );
                builder.setView(dialogView);

                builder.setPositiveButton( android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                } );

                builder.setNegativeButton( android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                } );

                builder.show();

                return false;
            }
        } );

    }


    public AlertDialog picker(){

        final NumberPicker np = new NumberPicker(this);
        np.setMaxValue(1908);
        np.setMinValue(1900);
        np.setValue( 1901 );
        np.setWrapSelectorWheel(false);
        final NumberPicker.OnValueChangeListener myValueChangeListner = new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, final int newVal) {
                tv.setText("" + newVal);

            }

        };


        np.setOnValueChangedListener(myValueChangeListner);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this).setView(np);
        builder.setTitle(" Number Picker");

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                TextView textView = (TextView)np.findViewById( R.id.Birthdisp );

            }
        });

        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        });
        builder.show();
        return builder.create();

    }




}
