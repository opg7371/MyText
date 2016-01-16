package com.filmygeekstudio.mytext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by piyush on 10/1/16.
 */
public class SignUp extends Activity {
    EditText fname,lname,email,pass,cpass,mob,username;
    Button submit;

    com.filmygeekstudio.mytext.DatabaseHelper helper = new com.filmygeekstudio.mytext.DatabaseHelper(this);
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        init();

        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                // EMAIL Validation and Password Valdation
                if ((samePassword(pass.getText().toString(),cpass.getText().toString())&&isEmailValid(email.getText().toString())) && (isPasswordValid(pass.getText().toString())&& checkNum(mob.getText().toString())) ) {
                    Toast.makeText(view.getContext(), "The Email, Password and Mobile Validation are Successful", Toast.LENGTH_LONG).show();

                }
                else {
                    Toast.makeText(view.getContext(),"Please Try Again",Toast.LENGTH_LONG).show();
                }

                if(!(samePassword(pass.getText().toString(),cpass.getText().toString()))) {
                    Toast.makeText(view.getContext(),"Please Try Again",Toast.LENGTH_LONG).show();

                }
                else {
                    //Details will be inserted here
                    Toast.makeText(view.getContext(),"In the database Helper class",Toast.LENGTH_SHORT).show();
                    Contact c = new Contact();
                    c.setEmail(email.getText().toString());
                    c.setFname(fname.getText().toString());
                    c.setLname(lname.getText().toString());
                    c.setPass(pass.getText().toString());
                    c.setUname(username.getText().toString());
                    c.setMobile(Double.parseDouble(String.valueOf(mob.getText().toString())));

                    helper.insertContact(c) ;
                    Toast.makeText(view.getContext(),"Insertion completed",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(view.getContext(),Login.class);
                    startActivity(i);

                }

            }

        });


    }

    void init () {
        fname = (EditText)findViewById(R.id.fname);
        lname = (EditText)findViewById(R.id.lname);
        email = (EditText)findViewById(R.id.email);
        pass = (EditText)findViewById(R.id.pass);
        username = (EditText)findViewById(R.id.username);
        cpass = (EditText)findViewById(R.id.conf_pass);
        mob = (EditText)findViewById(R.id.mobile);
        submit = (Button)findViewById(R.id.submit);
    }

    public boolean isEmailValid(String email) {
        return email.contains("@");
    }
    public boolean isPasswordValid(String password) {
        return password.length() > 8;
    }
    public boolean samePassword(String pass1,String pass2) {
        Toast.makeText(this,"Password 1:  "+pass1+"   Password 2:  "+pass2,Toast.LENGTH_LONG).show();

        return pass1.equals(pass2);
    }
    public boolean checkNum(String number) {
        if(number.length() == 10) {
            return true;
        }
        else
            return false;
    }

    @Override
    public void finish() {
        finish();
    }
}
