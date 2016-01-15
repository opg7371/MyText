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
public class SplashMain extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashmain);
        final Handler handler = new Handler(Looper.getMainLooper());
        Toast.makeText(getApplicationContext(),"Splash main Class Launched", Toast.LENGTH_LONG).show();

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent wqi = new Intent(SplashMain.this, Main_activity_1.class);
                        startActivity(wqi);
                    }
                });
            }
        };
        timer.start();
    }
}
