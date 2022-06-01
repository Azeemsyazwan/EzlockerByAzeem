package com.example.android.splashscreendemo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class reg extends AppCompatActivity {

    private EditText username, userPassword, userEmail;
    private Button regButton;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        getSupportActionBar().hide();

        setupUIViews();

        firebaseAuth = FirebaseAuth.getInstance();

        regButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()) {
                    //upload data basee
                      String user_email = userEmail.getText().toString().trim();
                      String user_password = userPassword.getText().toString().trim();

                      firebaseAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                          @Override
                          public void onComplete(@NonNull Task<AuthResult> task) {

                              if (task.isSuccessful()) {
                                  Toast.makeText(reg.this, "Registration Succesful", Toast.LENGTH_SHORT).show();
                                  startActivity(new Intent(reg.this, MainActivity.class));

                              } else {
                                  Toast.makeText(reg.this, "Registration failed", Toast.LENGTH_SHORT).show();

                              }
                          }
                      });

                      }
            }
        });

    }

    private void setupUIViews() {
        username = (EditText)findViewById(R.id.etUserName);
        userPassword = (EditText)findViewById(R.id.etUserPassword);
        userEmail = (EditText)findViewById(R.id.etUserEmail);
        regButton = (Button) findViewById(R.id.btnRegister);


    }

    private Boolean validate(){
        Boolean result = false;

        String name = username.getText().toString();
        String password = userPassword.getText().toString();
        String email = userEmail.getText().toString();

        if (name.isEmpty() || password.isEmpty() || email.isEmpty()){

            Toast.makeText(this,"Register dulu bang!", Toast.LENGTH_SHORT).show();
        }
        {
            result = true;
        }
        return result;
    }

}
