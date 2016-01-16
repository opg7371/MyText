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
public class Login extends Activity {
    EditText email1, pass1;
    String mail, pass, password;
    Button submit1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        init();

        submit1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                DatabaseHelper helper = new DatabaseHelper(view.getContext());
                Toast.makeText(view.getContext(),"Button Pressed",Toast.LENGTH_SHORT).show();
                password = helper.searchUser(mail);

                Toast.makeText(view.getContext(), password,Toast.LENGTH_SHORT).show();
                if (pass.equals(password)) {
                    Toast.makeText(Login.this, "The Passwords were matched.Welcome" + email1.getText().toString(), Toast.LENGTH_LONG).show();
                    Intent i = new Intent(Login.this, MainPage.class);
                    startActivity(i);

                } else {
                    Toast.makeText(Login.this, "The Email and Passwords do not match.Please Try Again", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    void init() {
        pass1 = (EditText) findViewById(R.id.pass1);
        email1 = (EditText) findViewById(R.id.email1);
        submit1 = (Button) findViewById(R.id.login);
        mail = email1.getText().toString();
        pass = pass1.getText().toString();
    }

    @Override
    public void finish() {
        super.finish();
    }
}


