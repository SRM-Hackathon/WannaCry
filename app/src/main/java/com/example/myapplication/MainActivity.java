package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText ttid;
    EditText ttpassword;
    String id;
    String pass;
    List<tteDetails> detailsList;
    DatabaseReference auth= FirebaseDatabase.getInstance().getReference().child("ttedetails");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailsList=new ArrayList<>();
        setContentView(R.layout.activity_main);
        ttid=findViewById(R.id.tteid);
        ttpassword=findViewById(R.id.ttepassword);
        id=String.valueOf(ttid.getText());
        pass=String.valueOf(ttpassword.getText());
    }
    public  void  onSubmit(View view){
        auth.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                for (DataSnapshot data:dataSnapshot.getChildren()){
                    if(data.)
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
