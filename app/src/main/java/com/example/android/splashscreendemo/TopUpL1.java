package com.example.android.splashscreendemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class TopUpL1 extends AppCompatActivity {



    private WebView webView3;
    private Button Back1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up_l1);
        getSupportActionBar().hide();

        webView3 = (WebView) findViewById(R.id.webview3);
        webView3.setWebViewClient(new WebViewClient());
        webView3.getSettings().setJavaScriptEnabled(true);
        webView3.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        webView3.setWebViewClient(new WebViewClient());
        webView3.loadUrl("https://www.paypal.me/ezlocker");
        Back1 = (Button)findViewById(R.id.btnBack1);






        Back1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TopUpL1.this,LockUnlockL1.class));
            }
        });



    }



}
