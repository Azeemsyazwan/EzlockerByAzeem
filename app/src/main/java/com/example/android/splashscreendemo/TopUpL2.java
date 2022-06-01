package com.example.android.splashscreendemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class TopUpL2 extends AppCompatActivity {


    private WebView webView4;
    private Button Back2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up_l2);
        getSupportActionBar().hide();



        webView4 = (WebView) findViewById(R.id.webview4);
        webView4.setWebViewClient(new WebViewClient());
        webView4.loadUrl("https://www.paypal.me/ezlocker");
        webView4.getSettings().setJavaScriptEnabled(true);
        webView4.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView4.setWebViewClient(new WebViewClient());
        Back2 = (Button)findViewById(R.id.btnBack2);


        Back2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TopUpL2.this,LockUnlockL2.class));
            }
        });
    }
}
