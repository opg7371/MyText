package com.filmygeekstudio.mytext;

import android.app.Activity;
        import android.content.Context;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.os.Handler;
        import android.os.Looper;
        import android.provider.MediaStore;
        import android.util.Log;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;
        import java.io.FileInputStream;
        import java.io.FileNotFoundException;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.util.AbstractCollection;

/**
 * Created by PIYUSH  BADKUL on 12/18/2015.
 */
public class MainActivity extends Activity {


    EditText maintext,textFile,notebook;
    TextViewUndoRedo mTextViewUndoRedo;
    private static final String NUMBER_OF_TIMES_RUN_KEY = "NUMBER_OF_TIMES_RUN_KEY";
    private static int flag1 = 1;
    private static int howmanytimesbeenrun = 0;
    final static int cameradata = 0;
    String data;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Handler handler = new Handler(Looper.getMainLooper());
        setContentView(R.layout.activity_main);
        try {
            maintext = (EditText) findViewById(R.id.mainText);
            textFile = (EditText)findViewById(R.id.textTitle);
            notebook = (EditText)findViewById(R.id.notebook1);
            mTextViewUndoRedo = new TextViewUndoRedo(maintext);
        }catch(Exception e) {
            Log.d("I", "I wasn't thinking of this");
        }
        SharedPreferences sharedPreferences = getPreferences(Context.MODE_PRIVATE);
        int defaultValue = 0;
        howmanytimesbeenrun = sharedPreferences.getInt(NUMBER_OF_TIMES_RUN_KEY,defaultValue);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(NUMBER_OF_TIMES_RUN_KEY, howmanytimesbeenrun);
        editor.commit();
        Toast.makeText(getApplicationContext(),"MainActivity Launched..",Toast.LENGTH_LONG).show();


        if(howmanytimesbeenrun == 0) {
            Toast.makeText(getApplicationContext(),"Welcome This is your first time",Toast.LENGTH_LONG).show();
        }
        howmanytimesbeenrun++;
    }

    private static final String DATA_FILE = "my file";

    @Override
    protected void onPause() {
        super.onPause();
        saveTextFile(maintext.getText().toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        maintext.setText(getTextFile());
    }

    public String getTextFile() {
        FileInputStream fileInputStream = null;
        String filedata = null;
        try {
            fileInputStream = openFileInput(DATA_FILE);
            int size = fileInputStream.available();
            byte[] buffer = new byte[size];
            fileInputStream.read(buffer);
            fileInputStream.close();
            filedata = new String(buffer,"UTF-8");


        } catch (FileNotFoundException e) {
            Log.d("Hi","Error in SaveTextFile..");
            e.printStackTrace();
        }catch (IOException e) {
            Log.d("Hi","Error in SaveTextFile..");
            e.printStackTrace();
        }
        finally {
            try {
                if(fileInputStream!=null){
                    fileInputStream.close();
                }

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return filedata;
    }

    public String saveTextFile(String content) {
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = openFileOutput(DATA_FILE,Context.MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());

        } catch (FileNotFoundException e) {
            Log.d("Hi","Error in SaveTextFile..");
            e.printStackTrace();
        }catch (IOException e) {
            Log.d("Hi","Error in SaveTextFile..");
            e.printStackTrace();
        }
        finally {
            try {
                if(fileOutputStream!=null){
                    fileOutputStream.close();
                }

            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    // Toast.makeText(getApplicationContext(), "Second Activity Launched..", Toast.LENGTH_LONG).show();


    public void save1(View view) {
        Toast.makeText(getApplicationContext(),"Entering in the Try Block..",Toast.LENGTH_LONG).show();
        try{
            data=maintext.getText().toString();
            FileOutputStream fOut;
            Toast.makeText(getApplicationContext(),"Entering in the Next Try Block..",Toast.LENGTH_LONG).show();
            try {
                notebook.setText(""+textFile.getText());
                fOut = openFileOutput(""+textFile.getText(), Context.MODE_PRIVATE);
                try{
                    fOut.write(data.getBytes());
                    fOut.close();
                    Toast.makeText(getBaseContext(),"file saved",Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),"Failed in the write Try Block..",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(),"Failed in the Reading of first Try Block..",Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }

        }catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Problem is in Save button.",Toast.LENGTH_LONG).show();
            Log.d("HI", "Problem in the save Button");
            e.printStackTrace();
        }
    }

    public void open1(View view) {
        try{
            FileInputStream fin = openFileInput(""+textFile.getText());

            int c;
            String temp="";

            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c);
            }
            maintext.setText(temp);

            Toast.makeText(getBaseContext(),"file read",Toast.LENGTH_LONG).show();

        }catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Problem is in Open button.",Toast.LENGTH_LONG).show();
            Log.d("HI", "Problem in the Open Button");
            e.printStackTrace();
        }
    }
    String emailAdd = "guptatrue18@gmail.com";
    public void email1(View view) {
        String emailAddress[] = {emailAdd};
        String message = ""+maintext.getText();
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.putExtra(Intent.EXTRA_TEXT,message);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT,""+textFile.getText());
        emailIntent.putExtra(Intent.EXTRA_EMAIL,emailAddress);
        emailIntent.setType("plain/text");
        startActivity(emailIntent);
    }

    public void UndoButton(View view) {
        try {
            mTextViewUndoRedo.undo();
        }catch(Exception e) {
            Log.d("I", "I wasn't thinking of this Undo Button");
        }
    }
    public void RedoButton(View view) {
        try {
            mTextViewUndoRedo.redo();
        }catch(Exception e) {
            Log.d("I", "I wasn't thinking of thisRedo Button");
        }
    }

    public void camera1(View view) {
        try {
            Intent icam = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(icam,cameradata);
        }catch (Exception e) {
            Toast.makeText(getApplicationContext(),"Opening of Camera failed",Toast.LENGTH_LONG).show();
            Log.d("Hi", "Problem in camera");
            e.printStackTrace();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK) {
            Bundle extras = data.getExtras();
            /*to be Completed*/
        }
    }

    public void new1(View view) {
        maintext.setText("");
    }


}
