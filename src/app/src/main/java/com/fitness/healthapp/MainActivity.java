package com.fitness.healthapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.app.Activity;
import android.util.Log;


public class MainActivity extends AppCompatActivity {

    public Button btn1;
    public Button btn2;
    public Button btn3;

    public void loginbtn()
    {
        btn1 = (Button)findViewById(R.id.loginbutton);

        btn1.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
        );

    }

    public void laterbtn()
    {
        btn2 = (Button) findViewById(R.id.laterbutton);

        btn2.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        finish();
                        System.exit(0);
                    }
                }
        );
    }


    public void createbtn()
    {
        btn3 = (Button)findViewById(R.id.createbutton);

        btn3.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent(MainActivity.this, SignupActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginbtn();
        laterbtn();
        createbtn();
    }
}
