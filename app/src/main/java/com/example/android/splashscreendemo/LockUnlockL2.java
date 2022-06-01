package com.example.android.splashscreendemo;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class LockUnlockL2 extends AppCompatActivity {

    private TextView mTextViewResult2;
    private Button locklocker2;
    private Button Pay2;
    private int mcounter2 = 5;
    private WebView webView2;
    private FirebaseAuth firebaseAuth;
    private Button LGout2;
    private Button TopUp2;
    private Chronometer chronometer2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock_unlock_l2);
        getSupportActionBar().hide();

        locklocker2 = (Button)findViewById(R.id.btnLock2);
        Pay2        = (Button)findViewById(R.id.btnPay2);
        mTextViewResult2 = (TextView)findViewById(R.id.tx2) ;
        firebaseAuth = FirebaseAuth.getInstance();
        LGout2 = (Button)findViewById(R.id.btnLGout2);
        TopUp2 = (Button)findViewById(R.id.btnTopUp2);
        chronometer2 = findViewById(R.id.chronometer2);
        Pay2.setEnabled(false);



        locklocker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder altdial = new AlertDialog.Builder(LockUnlockL2.this);

                altdial.setMessage("Do you wish to continue?").setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();
                                webView2 = (WebView) findViewById(R.id.webview2);
                                webView2.setWebViewClient(new WebViewClient());
                                webView2.loadUrl("http://192.168.43.20/servoonl2");
                                locklocker2.setEnabled(false);
                                Pay2.setEnabled(true);

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
                chronometer2.start();



            }
        });

        Pay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mcounter2 --;

                AlertDialog.Builder altdial = new AlertDialog.Builder(LockUnlockL2.this);

                altdial.setMessage("Click 'Yes' to pay" ).setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.cancel();

                                webView2 = (WebView) findViewById(R.id.webview2);
                                webView2.loadUrl("http://192.168.43.20/servooffl2");
                                Pay2.setEnabled(false);

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
                chronometer2.stop();


                mTextViewResult2.setText(Integer.toString(mcounter2));


                if(mcounter2 == 0){
                    Pay2.setEnabled(false);
                }

                Pay2.setEnabled(false);
                chronometer2.stop();

                // /letak counter unlock method
            }
        });


        LGout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(LockUnlockL2.this,MainActivity.class));
            }
        });

        TopUp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LockUnlockL2.this,TopUpL2.class));
            }
        });


    }
}


