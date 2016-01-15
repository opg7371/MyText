package com.filmygeekstudio.mytext;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Main_activity_1 extends Activity {




    private static int flag1 = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Toast.makeText(getApplicationContext(), "Succesfully Started", Toast.LENGTH_LONG).show();
        super.onCreate(savedInstanceState);
        Toast.makeText(getApplicationContext(), "MainActivity 11 Launched..", Toast.LENGTH_LONG).show();

        if (flag1 == 1) {
            flag1 = 0;
            try {
                Intent splash = new Intent(Main_activity_1.this, SpashActivity1.class);
                startActivity(splash);
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Opening of Intent failed", Toast.LENGTH_LONG).show();
                Log.d("Hi", "Problem in Splash");
                e.printStackTrace();
            }
        } else {
            try {
                Intent splash1 = new Intent(Main_activity_1.this, SplashMain.class);
                startActivity(splash1);
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Opening of Intent failed", Toast.LENGTH_LONG).show();
                Log.d("Hi", "Problem in Splash");
                e.printStackTrace();
            }
        }
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}

