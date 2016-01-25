package com.filmygeekstudio.mytext;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by piyush on 15/1/16.
 */
public class popup extends Activity {
    ImageButton bold,italic,under,highlight,listdot,listnumber,checkbox;
    MainActivity mainActivity;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Handler handler = new Handler(Looper.getMainLooper());
        setContentView(R.layout.popup);
        mainActivity = new MainActivity();

       // init();

    }
    public void bold() {
       // View vi = View.inflate(R.layout.activity_main);

       // TextView tv = (TextView)vi.findViewById(R.id.mainText);/*
        //tv.setTypeface(null, Typeface.BOLD);
      //  r1.addView(vi);
    }

    public void Italic() {
        TextView tv = (TextView)findViewById(R.id.mainText);
        tv.setTypeface(null, Typeface.ITALIC);
    }
    public void Underl() {
        TextView tv = (TextView)findViewById(R.id.mainText);

    }

    public void init() {
        bold = (ImageButton) findViewById(R.id.bold);
        italic = (ImageButton)findViewById(R.id.italic);

        RelativeLayout r1 = (RelativeLayout)findViewById(R.id.referenceLayout);
    }
//-+++++++++++++++++++++++++++++++++-


}