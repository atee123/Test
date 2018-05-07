package com.fitness.healthapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Spinner;
import android.widget.TextView;

import static com.fitness.healthapp.R.id.spinner1;
import static com.fitness.healthapp.R.id.spinner2;
import static com.fitness.healthapp.R.id.spinner3;


public class SignupActivity extends AppCompatActivity{
    private static TextView tv ;
    private static TextView tv1 ;
    private static TextView tv3 ;
    private static TextView tv2;

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
        tv3 = (TextView)findViewById( R.id.Height_disp );
        tv2 = (TextView)findViewById( R.id.Weight_disp );


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
                final EditText et = (EditText) dialogView.findViewById( R.id.feetText );
                final EditText et1 = (EditText) dialogView.findViewById( R.id.inchText );
                final AlertDialog dialog = builder.create();

                et.addTextChangedListener( new TextWatcher() {
                    private EditText myText;

                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after)
                    {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s)
                    {
                        String str = et.getText().toString();
                        tv1.setText( str );
                    }
                } );

                et1.addTextChangedListener( new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {
                        String str = et1.getText().toString();
                        tv3.setText( str );
                    }
                } );

                    builder.setPositiveButton( android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                } );

                builder.setNegativeButton( android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
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

                final EditText et3 = (EditText)dialogView.findViewById( R.id.weightText );
                final AlertDialog dialog = builder.create();

                et3.addTextChangedListener( new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {

                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                        String str = et3.getText().toString();
                        tv2.setText( str );
                    }
                } );

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
