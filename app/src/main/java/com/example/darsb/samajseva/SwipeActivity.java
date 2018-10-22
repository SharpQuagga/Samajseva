package com.example.darsb.samajseva;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;


public class SwipeActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton btnsSer , btnCare , btnNoti , btnPro;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);
        initViews();
        getSupportActionBar().hide();

        ViewAdapter adapter = new ViewAdapter(this);
        viewPager.setAdapter(adapter);

    }

    public void initViews() {
        btnsSer = findViewById(R.id.imageButtonService);
        btnCare = findViewById(R.id.imageButtonCare);
        btnNoti = findViewById(R.id.imageButtonNoti);
        btnPro = findViewById(R.id.imageButtonPro);
        viewPager = findViewById(R.id.ViewPage);
        btnPro.setOnClickListener(this);
        btnNoti.setOnClickListener(this);
        btnCare.setOnClickListener(this);
        btnsSer.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.imageButtonService) {
            final AlertDialog alertDialog = new AlertDialog.Builder(this)
                    //set icon
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    //set title
                    .setTitle("T.G.L.")
                    //set message
                    .setMessage("Installation: For requesting installation/wall mounting/demo of this product " +
                            "once delivered, please directly call TGL support on Toll free no: 8729000838 and provide " +
                            "product's model name as well as seller's details mentioned on the invoice. They will give " +
                            "you an installation reference number which can be used for any further follow up, in case of " +
                            "any further clarification, please contact Amazon customer care")
                    //set positive button
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //set what would happen when positive button is clicked
                        }
                    })
                    .show();

        }


       if (id == R.id.imageButtonCare){
           final AlertDialog alertDialog = new AlertDialog.Builder(this)
                   //set icon
                   .setIcon(android.R.drawable.ic_dialog_alert)
                   //set title
                   .setTitle("T.G.L.")
                   //set message
                   .setMessage("Contact No - 8729000838")
                   //set positive button
                   .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                           //set what would happen when positive button is clicked
                       }
                   })
                   .show();
       }

       if (id == R.id.imageButtonNoti){
           final AlertDialog alertDialog = new AlertDialog.Builder(this)
                   //set icon
                   .setIcon(android.R.drawable.ic_dialog_alert)
                   //set title
                   .setTitle("T.G.L.")
                   //set message
                   .setMessage("Enjoy premium picture quality and tremendous value in a " +
                           "sophisticated design, perfect for bringing entertainment to any room " +
                           "in the house. This flat screen LED HDTV features Full HD (1080p) resolution" +
                           " for brilliant color and contrast. Direct LED backlighting delivers darker black" +
                           "s and luminous brightness, while maintaining superior energy efficiency.")
                   //set positive button
                   .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialogInterface, int i) {
                           //set what would happen when positive button is clicked
                       }
                   })
                   .show();
       }

       if (id == R.id.imageButtonPro){
           Intent intent = new Intent(SwipeActivity.this,ListActivity.class);
           startActivity(intent);
       }

    }

}
