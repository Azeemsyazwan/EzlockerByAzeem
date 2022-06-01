package com.example.android.splashscreendemo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Lockersatu extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button Logout;
    private EditText Password;
    private Button Proceed;



    @Override
    protected void onCreate(Bundle savedInstanceState) {


        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lockersatu);
        getSupportActionBar().hide();

        Password = (EditText)findViewById(R.id.passCode);
        firebaseAuth = FirebaseAuth.getInstance();
        Logout = (Button)findViewById(R.id.btnLogOut1);
        Proceed =(Button)findViewById(R.id.btnProceed);
        FirebaseUser user = firebaseAuth.getCurrentUser();


        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(Lockersatu.this,MainActivity.class));
            }
        });


   }




}
