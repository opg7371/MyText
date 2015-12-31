package com.filmygeekstudio.mytext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by PIYUSH  BADKUL on 12/18/2015.
 */
public class SplashActivity4 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashactivity4);
        final Handler handler = new Handler(Looper.getMainLooper());
    //    Toast.makeText(getApplicationContext(), "Fourth Activity Launched...", Toast.LENGTH_LONG).show();

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(3500);
                } catch (Exception e) {
                    Log.d("av", "In Thrid class Activity");

                    e.printStackTrace();
                }
                Log.d("aa", "First Activity");
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent i = new Intent(SplashActivity4.this, Main_activity_1.class);
                        startActivity(i);
                    }
                });


            }
        };
        timer.start();
    }
}
