package com.filmygeekstudio.mytext;

import android.app.Activity;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageButton;
import android.widget.TextView;

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

    public void bold() {
        TextView tv = (TextView)findViewById(R.id.mainText);
        tv.setTypeface(null, Typeface.BOLD);
    }

    public void Italic() {
        TextView tv = (TextView)findViewById(R.id.mainText);
        tv.setTypeface(null, Typeface.ITALIC);
    }
    public void Underl() {
        TextView tv = (TextView)findViewById(R.id.mainText);
        tv.setPaintFlags(tv.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

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