package com.example.android.splashscreendemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class Lockerdua extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private Button Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lockerdua);
        getSupportActionBar().hide();

        firebaseAuth = FirebaseAuth.getInstance();
        Logout = (Button)findViewById(R.id.btnLogOut2);

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(Lockerdua.this,MainActivity.class));
            }
        });
    }
}
