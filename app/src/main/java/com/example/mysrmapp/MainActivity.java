package com.example.mysrmapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

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
    String id="";
    String pass;
    List<tteDetails> detailsList;
    String sendId;
    DatabaseReference auth= FirebaseDatabase.getInstance().getReference().child("ttedetails");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        detailsList=new ArrayList<>();
        setContentView(R.layout.activity_main);
        ttid=findViewById(R.id.tteid);
        ttpassword=findViewById(R.id.ttepassword);
    }

    @Override
    protected void onStart() {
        super.onStart();

            auth.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for (DataSnapshot data : dataSnapshot.getChildren()) {
                        tteDetails tdetails=data.getValue(tteDetails.class);
                        detailsList.add(tdetails);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

    public  void  onSubmit(View view){
        id=String.valueOf(ttid.getText());
        pass=String.valueOf(ttpassword.getText());
        int flag=0;
        for(tteDetails tdetails:detailsList) {
            if (id.equals(tdetails.getTte_id()) && pass.equals(tdetails.getPassword())) {
                flag = 1;
                sendId=tdetails.getTte_id();
                break;
            }
        }
        if(flag==1) {
            Intent i=new Intent(this,showTtteDuty.class);
            i.putExtra("id",sendId);
            startActivity(i);
        }
        else
            Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
    }
}
