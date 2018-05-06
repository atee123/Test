package com.fitness.healthapp;

import android.app.Dialog;
import android.util.Log;
import android.widget.TextView;

public class NumberPicker extends SignupActivity implements android.widget.NumberPicker.OnValueChangeListener
{
    private TextView tv;
    static Dialog d ;

    @Override
    public void onValueChange(android.widget.NumberPicker picker, int oldVal, int newVal) {
        Log.i("Value is: ","" +newVal);
    }



    public void displaynp(){

        final Dialog d = new Dialog(NumberPicker.this);
        d.setTitle(" Number Picker");
        d.setContentView(R.layout.numberpicker);
        final android.widget.NumberPicker np = (android.widget.NumberPicker)d.findViewById(R.id.numberPicker2);
        np.setMinValue(1908);
        np.setMaxValue(2017);
        np.setWrapSelectorWheel(false);
        np.setOnValueChangedListener(this);
        d.show();
    }
}
