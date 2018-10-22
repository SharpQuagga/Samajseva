package com.example.darsb.samajseva;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText txtName,txtAdd,txtEma,txtSta,txtPass,txtCon,txtPin;
    Button btnRegi;
    DatabaseReference databasePalace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        txtName=findViewById(R.id.editTextName);
        txtAdd=findViewById(R.id.editTextAdd);
        txtCon=findViewById(R.id.editTextCont);
        txtEma=findViewById(R.id.editTextEmai);
        txtSta=findViewById(R.id.editTextSta);
        txtPass=findViewById(R.id.editTextPass);
        txtPin=findViewById(R.id.editTextPin);
        btnRegi = findViewById(R.id.button);
        btnRegi.setOnClickListener(this);
        databasePalace = FirebaseDatabase.getInstance().getReference("gagan");

    }

    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(txtAdd.getText()) || TextUtils.isEmpty(txtSta.getText()) || TextUtils.isEmpty(txtPin.getText()) || TextUtils.isEmpty(txtPass.getText()) || TextUtils.isEmpty(txtEma.getText()) || TextUtils.isEmpty(txtName.getText()) || TextUtils.isEmpty(txtCon.getText())) {
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_LONG).show();

        }else{
            Intent intent = new Intent(MainActivity.this, SwipeActivity.class);
            String name = txtName.getText().toString();
            String address = txtAdd.getText().toString();
            String pin = txtPin.getText().toString();
            String contact = txtCon.getText().toString();
            String state = txtSta.getText().toString();
            String email = txtEma.getText().toString();
            String password = txtPass.getText().toString();

            if (!name.isEmpty()){
                String id = databasePalace.push().getKey();
                users palace = new users(id,pin,name,address,contact,state,email,password);
                databasePalace.child(id).setValue(palace);
                Toast.makeText(this,"data entered",Toast.LENGTH_LONG).show();
                txtName.setText("");
                txtAdd.setText("");
                txtCon.setText("");
                startActivity(intent);
            }else {
                Toast.makeText(this,"Please fill name first",Toast.LENGTH_LONG).show();
            }
        }

        }

    }

