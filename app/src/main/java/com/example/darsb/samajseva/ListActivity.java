package com.example.darsb.samajseva;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txt1 , txt2 , txt3 , txt4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initViews();
        getSupportActionBar().hide();
    }

    private void initViews() {
        txt1 = findViewById(R.id.textView3);
        txt2 = findViewById(R.id.textView7);
        txt3 = findViewById(R.id.textView8);
        txt4 = findViewById(R.id.textView9);
        txt4.setOnClickListener(this);
        txt3.setOnClickListener(this);
        txt2.setOnClickListener(this);
        txt1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ListActivity.this,WebActivity.class);
        startActivity(intent);
    }
}
