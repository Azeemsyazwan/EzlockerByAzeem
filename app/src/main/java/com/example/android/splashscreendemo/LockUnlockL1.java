package com.example.android.splashscreendemo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.IOException;


public class LockUnlockL1 extends AppCompatActivity {


    private Button locklocker;
    private Button Pay;
    TextView mTextViewResult;
    private int mcounter = 5;
    private WebView webView;
    private FirebaseAuth firebaseAuth;
    private Button LGout;
    private Button TopUp;
    private Chronometer chronometer;
    private boolean running;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_unlock_l1);
        getSupportActionBar().hide();

        locklocker = (Button)findViewById(R.id.btnLock);
        Pay        = (Button)findViewById(R.id.btnPay);
        mTextViewResult = (TextView) findViewById(R.id.tx);
        firebaseAuth = FirebaseAuth.getInstance();
        LGout = (Button)findViewById(R.id.btnLGout);
        FirebaseUser user = firebaseAuth.getCurrentUser();
        TopUp = (Button)findViewById(R.id.btnTopUp1);
        chronometer = findViewById(R.id.chronometer);

        Pay.setEnabled(false);



         locklocker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 AlertDialog.Builder altdial = new AlertDialog.Builder(LockUnlockL1.this);

                 altdial.setMessage("Do you wish to continue?").setCancelable(false)
                         .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialogInterface, int i) {
                                 dialogInterface.cancel();
                                 webView = (WebView) findViewById(R.id.webview);
                                 webView.loadUrl("http://192.168.43.20/servoon");
                                 locklocker.setEnabled(false);
                                 Pay.setEnabled(true);

                             }
                         })
                         .setNegativeButton("No", new DialogInterface.OnClickListener() {
                             @Override
                             public void onClick(DialogInterface dialogInterface, int i) {
                                 dialogInterface.cancel();

                             }
                         });
                 AlertDialog alert = altdial.create();
                 alert.setTitle("Confirmation");
                 alert.show();
                 Button nbutton = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
                 nbutton.setBackgroundColor(Color.BLACK);
                 Button pbutton = alert.getButton(DialogInterface.BUTTON_POSITIVE);
                 pbutton.setBackgroundColor(Color.BLACK);

                 chronometer.start();



                            }
        });



        Pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mcounter --;
                AlertDialog.Builder altdial = new AlertDialog.Builder(LockUnlockL1.this);

                altdial.setMessage("Click 'Yes' to pay" ).setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                dialogInterface.cancel();

                                webView = (WebView) findViewById(R.id.webview);
                                webView.loadUrl("http://192.168.43.20/servooff");
                                Pay.setEnabled(false);

                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();

                            }
                        });

                AlertDialog alert = altdial.create();
                alert.setTitle("Confirmation");
                alert.show();
                Button nbutton = alert.getButton(DialogInterface.BUTTON_NEGATIVE);
                nbutton.setBackgroundColor(Color.BLACK);
                Button pbutton = alert.getButton(DialogInterface.BUTTON_POSITIVE);
                pbutton.setBackgroundColor(Color.BLACK);
                chronometer.stop();


                mTextViewResult.setText(Integer.toString(mcounter));

                if(mcounter == 0){
                    Pay.setEnabled(false);
                }

                }
        });


        LGout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(LockUnlockL1.this,MainActivity.class));
            }
        });


       TopUp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(LockUnlockL1.this,TopUpL1.class));
           }
       });

    }
}
