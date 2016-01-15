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
public class SplashActivity2 extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashactivity2);
        final Handler handler=new Handler(Looper.getMainLooper());
       // Toast.makeText(getApplicationContext(), "Second Activity Launched..", Toast.LENGTH_LONG).show();

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(2500);
                }catch(Exception e) {
                    e.printStackTrace();
                }
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Intent it = new Intent(SplashActivity2.this, SplashActivity3.class);
                        startActivity(it);
                    }
                });
            }
        };
        timer.start();
    }
    protected void onPause() {
        super.onPause();
        finish();
    }

}
