package com.fitness.healthapp.Activities;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;

import com.fitness.healthapp.R;

public class ActivityFitness extends AppCompatActivity
{
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.main_page, menu);
        return true;
    }


}
