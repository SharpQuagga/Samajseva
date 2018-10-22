package com.example.darsb.samajseva;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtC;      users users11;
    Button btnLo;       Context context;
    EditText etxtName , etxtPass;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
        txtC = findViewById(R.id.textView2);
        txtC.setOnClickListener(this);
        btnLo = findViewById(R.id.buttonlo);
        btnLo.setOnClickListener(this);
        databaseReference = FirebaseDatabase.getInstance().getReference("gagan");

        etxtName = findViewById(R.id.editText);
        etxtPass = findViewById(R.id.editText2);

        String Contact = etxtName.getText().toString();
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.textView2) {
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else {
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {

                    for (DataSnapshot doctorsSnapshot : dataSnapshot.getChildren()) {
                        users palace = doctorsSnapshot.getValue(users.class);
                        if (palace.password.equals(etxtPass.getText().toString())) {
                               Intent intent = new Intent(LoginActivity.this, SwipeActivity.class);
                               startActivity(intent);
                           } else {
                               Toast.makeText(getApplicationContext(), "Password is wrong", Toast.LENGTH_LONG).show();
                           }

                    }

                }@Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });



//            Query query = databaseReference.child("gagan").equalTo(etxtName.getText().toString());

//            query.addValueEventListener(new ValueEventListener() {
//               @Override
//               public void onDataChange( DataSnapshot dataSnapshot) {
//
//                   if (dataSnapshot.exists()) {
//                       // dataSnapshot is the "issue" node with all children with id 0
//                          Toast.makeText(getApplicationContext(),"sdvdsvdsdd",Toast.LENGTH_LONG).show();
//                       for (DataSnapshot doctorsSnapshot : dataSnapshot.getChildren()) {
//                           // do something with the individual "issues"
//                           users usersBean = dataSnapshot.getValue(users.class);
//                           if (usersBean.password.equals(etxtPass.getText().toString())) {
//                               Intent intent = new Intent(LoginActivity.this, SwipeActivity.class);
//                               startActivity(intent);
//                           } else {
//                               Toast.makeText(getApplicationContext(), "Password is wrong", Toast.LENGTH_LONG).show();
//                           }
//                       }
//                   }
//                   else {
//                       Toast.makeText(getApplicationContext(), "User not found", Toast.LENGTH_LONG).show();
//                   }
//               }
//
//               @Override
//               public void onCancelled(@NonNull DatabaseError databaseError) {
//
//               }
//           });

        }
    }
}
