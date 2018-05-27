package com.fitness.healthapp.DataBase;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class Control extends AsyncTask<String, String, String> {

    Context ctx;
    public Control(Context ctx){
        this.ctx = ctx;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... voids)
    {

        String reg_url = "http://localhost:3310/app/register.php";
        String login_url = "http://localhost:3310/app/login.php";
        String method = voids[0];
        if(method.equals( "register" ))
        {
            String name = voids[1];
            String email = voids[2];
            String password = voids[3];
            try
            {
                URL url = new URL( reg_url );
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod( "POST" );
                httpURLConnection.setDoOutput( true );
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter( new OutputStreamWriter( OS, "UTF-8" ) );

                String data = URLEncoder.encode( "user_name", "UTF-8" ) + " = " + URLEncoder.encode( name,"UTF-8" )+"&"+
                        URLEncoder.encode( "user_email", "UTF-8" ) + " = " + URLEncoder.encode( email,"UTF-8" )+"&"+
                        URLEncoder.encode( "user_pass", "UTF-8" ) + " = " + URLEncoder.encode( password,"UTF-8" );

                bufferedWriter.write( data );
                bufferedWriter.flush();
                bufferedWriter.close();
                OS.close();

                InputStream IS = httpURLConnection.getInputStream();
                IS.close();

                return "Registration Success....";

            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate( values );
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText( ctx, result, Toast.LENGTH_LONG ).show();
    }
}



