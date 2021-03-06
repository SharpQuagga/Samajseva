package com.example.darsb.samajseva;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AllUsersActivity extends AppCompatActivity {

    DatabaseReference databasePalace;
    ListView listView;
    List<users> palaceList;

    public void initViews(){
        palaceList= new ArrayList<>();
        listView = findViewById(R.id.listviewA);
        databasePalace = FirebaseDatabase.getInstance().getReference("gagan");
    }

    public AllUsersActivity(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_users);
        initViews();
    }

    @Override
    protected void onStart() {
        super.onStart();


        databasePalace.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                palaceList.clear();
                for (DataSnapshot doctorsSnapshot : dataSnapshot.getChildren()){
                    users palace = doctorsSnapshot.getValue(users.class);
                    palaceList.add(palace);
                }

//                doctorsList adapter = new doctorsList(AllUsersActivity.this,palaceList);
//                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

