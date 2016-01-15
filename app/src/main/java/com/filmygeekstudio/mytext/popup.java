package com.filmygeekstudio.mytext;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageButton;

/**
 * Created by piyush on 15/1/16.
 */
public class popup extends Activity {
    ImageButton bold,italic,under,highlight,listdot,listnumber,checkbox;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Handler handler = new Handler(Looper.getMainLooper());
        setContentView(R.layout.popup);
        init();

    }



    public void init() {
        bold = (ImageButton) findViewById(R.id.bold);
        italic = (ImageButton)findViewById(R.id.italic);
        under = (ImageButton)findViewById(R.id.underline);
        highlight = (ImageButton) findViewById(R.id.highlight);
        listdot = (ImageButton)findViewById(R.id.listdot);
        listnumber= (ImageButton)findViewById(R.id.listnumber);
        checkbox = (ImageButton)findViewById(R.id.checkbox);
    }
}