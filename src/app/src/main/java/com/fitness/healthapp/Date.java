package com.fitness.healthapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TextView;

import java.util.Calendar;

public class Date extends AppCompatActivity implements NumberPicker.OnValueChangeListener, View.OnClickListener {
    private static final String TAG = "Date";

    private TextView mDisplaydate;
    private DatePickerDialog.OnDateSetListener mDateListener;
    //private NumberPicker.OnClickListener mNumberLitener;

    private static TextView tv;
    static Dialog d ;

    TextView tv1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        tv1 = (TextView)findViewById(R.id.numberView);

        b1 = (Button)findViewById(R.id.Number);

        tv = (TextView)findViewById(R.id.textView1);
        b1.setOnClickListener(this);

        Button b = (Button)findViewById(R.id.button11);

        mDisplaydate = (TextView)findViewById(R.id.tvdate);

        mDisplaydate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();

                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        Date.this,
                            android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                            mDateListener,
                            year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        mDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year );
            }
        };


        b.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v) {
                show();
            }
        });


    }
    @Override
    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {

        Log.i("value is",""+newVal);
    }


    public void show()
    {

        final Dialog d = new Dialog(Date.this);
        d.setTitle("NumberPicker");
        d.setContentView(R.layout.activity_date);
        Button b1 = (Button) d.findViewById(R.id.button1);
        Button b2 = (Button) d.findViewById(R.id.button2);

        final NumberPicker np = (NumberPicker) d.findViewById(R.id.numberPicker1);
        np.setMaxValue(2017);
        np.setMinValue(1908);
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(this);
        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                tv.setText(String.valueOf(np.getValue()));
                d.dismiss();
            }
        });
        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                d.dismiss();
            }
        });
        d.show();


    }

    public void picker(){

        NumberPicker np = new NumberPicker(this);
        np.setMaxValue(1908);
        np.setMinValue(1900);
        np.setValue(1905);
        np.setWrapSelectorWheel(false);
        NumberPicker.OnValueChangeListener myValueChangeListner = new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                tv1.setText("" + newVal);
            }
        };

        np.setOnValueChangedListener(myValueChangeListner);
        AlertDialog.Builder builder = new AlertDialog.Builder(this).setView(np);
        builder.setTitle(" Number Picker");

        builder.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setPositiveButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();
    }

    @Override
    public void onClick(View v) {
        picker();
    }
}
