package com.filmygeekstudio.mytext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/**
 * Created by PIYUSH  BADKUL on 12/18/2015.
 */
public class SplashActivity3 extends Activity{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashactivity3);
        final Handler handler = new Handler(Looper.getMainLooper());
    //    Toast.makeText(getApplicationContext(),"Third Activity Launched", Toast.LENGTH_LONG).show();

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(2500);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent wqi = new Intent(SplashActivity3.this, SplashActivity4.class);
                        startActivity(wqi);
                    }
                });
            }
        };
        timer.start();
    }
    }
