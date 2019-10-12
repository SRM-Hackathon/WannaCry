package com.example.mysrmapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class showTtteDuty extends AppCompatActivity {
    String id ;
    DatabaseReference dutyList;
    tteDutyDetail detail;
    TextView trainno;
    TextView trainname;
    TextView srcstn;
    TextView deststn;
    TextView coach;
    String coachtext;
    Button fetchPassengers;
    String[] values;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dutylayout);
        trainno=(TextView)findViewById(R.id.trainnoText);
        trainname=(TextView)findViewById(R.id.trainnameText);
        srcstn=(TextView)findViewById(R.id.srcstnText);
        deststn=(TextView)findViewById(R.id.deststnText);
        coach=(TextView) findViewById(R.id.coachText);
        fetchPassengers=(Button) findViewById(R.id.plistbtn);
        id= getIntent().getExtras().getString("id");
        dutyList= FirebaseDatabase.getInstance().getReference().child("tteduty");


    }
    protected void onStart() {
        super.onStart();

        dutyList.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    if (data.getKey().equals(id)) {
                        detail = data.getValue(tteDutyDetail.class);
                        //Toast.makeText(getApplicationContext(),String.valueOf(detail.getCoach()),Toast.LENGTH_SHORT).show();
                        trainname.setText(detail.getTrain_name());
                        trainno.setText(detail.getTrain_no());
                        srcstn.setText(detail.getSrc_stn());
                        deststn.setText(detail.getDest_stn());
                        coachtext = String.valueOf(detail.getCoach());
                        int i = 0;
                        String coachset = "";
                        for (i = 1; i < coachtext.length() - 1; i++) {
                            coachset += coachtext.charAt(i);

                        }
                        coach.setText(coachset);
                        values = coachset.split(",");
                        break;
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void fetchPList(View view)
    {

        Intent i=new Intent(this,showPList.class);
        i.putExtra("coachnos",values);
        startActivity(i);

    }
}
