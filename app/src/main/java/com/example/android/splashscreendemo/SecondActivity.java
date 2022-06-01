package com.example.android.splashscreendemo;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class SecondActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {

    private ZXingScannerView zXingScannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().hide();
    }


    public void scan(View view){
    zXingScannerView =new ZXingScannerView(getApplicationContext());
    setContentView(zXingScannerView);
    zXingScannerView.setResultHandler(this);
    zXingScannerView.startCamera();
    }

    @Override
    protected void onPause() {
        super.onPause();
        zXingScannerView.stopCamera();
    }

    @Override
    public void handleResult(Result result) {
        if(Patterns.WEB_URL.matcher(result.getText()).matches()) {
            // Open URL
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(result.getText()));
            startActivity(new Intent(SecondActivity.this,LockUnlockL1.class));
        }
        else {
            startActivity(new Intent(SecondActivity.this, LockUnlockL2.class));
        }

    }
}
