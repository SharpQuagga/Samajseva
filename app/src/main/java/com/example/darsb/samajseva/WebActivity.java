package com.example.darsb.samajseva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {

    WebView webView;
    WebViewClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        getSupportActionBar().hide();


        webView = findViewById(R.id.webView);
        client = new WebViewClient();
        webView.setWebViewClient(client);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.amazon.in/s/ref=nb_sb_ss_c_1_4?url=search-alias%3Daps&field-keywords=t.g.l+led+tv&sprefix=T.G.%2Caps%2C380&crid=1F3J4GCKU75RF");
    }
}
