package com.fitness.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    public Button btn1;
    public Button btn2;
    public Button btn3;
    public Button btn4;

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

    public void setDate()
    {
        btn4 = (Button)findViewById(R.id.CreateDate);

        btn4.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        Intent intent = new Intent(MainActivity.this, Date.class);
                        startActivity(intent);
                        finish();
                    }
                }
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loginbtn();
        laterbtn();
        createbtn();
        setDate();
    }
}
