package com.example.mysrmapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
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

import java.util.ArrayList;
import java.util.List;

public class showPList extends AppCompatActivity {
    String[] coachno;
    DatabaseReference databasePList;
    public static DatabaseReference databaseDetails;
    ListView listView1,listView2;
    Button submitbtn;
    public static TextView check;
    List<Passenger> PassengerList;
    public static List<Passenger> List1;
    public static List<Passenger> List2;
    public static List<String> checkCount;
    Pdetails pdetails;
    public static List<Pdetails> pDetailsList;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        coachno= getIntent().getExtras().getStringArray("coachnos");

        setContentView(R.layout.plistlayout);

        listView1=(ListView) findViewById(R.id.listView1);
        listView2=(ListView) findViewById(R.id.listView2);
        submitbtn=(Button) findViewById(R.id.submitbtn);
        PassengerList=new ArrayList<>();
        List1=new ArrayList<>();
        List2=new ArrayList<>();
        pDetailsList=new ArrayList<>();
        checkCount=new ArrayList<>();
        databasePList= FirebaseDatabase.getInstance().getReference().child("passengers");
        databaseDetails= FirebaseDatabase.getInstance().getReference().child("pdetails");
        submitbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                sendChecked();
                Toast.makeText(getApplicationContext(),"Submitted",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseDetails.addValueEventListener(new ValueEventListener() {
            int c;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pDetailsList.clear();
                for(DataSnapshot data:dataSnapshot.getChildren()) {
                    pdetails = data.getValue(Pdetails.class);
                    String pcoach=pdetails.getCoach();
                    int i;
                    for(i=0;i<coachno.length;i++)
                    {

                        if(Integer.parseInt(pcoach.trim())==Integer.parseInt(coachno[i].trim()))
                        {
                            pDetailsList.add(pdetails);
                            break;
                        }
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        databasePList.addValueEventListener(new ValueEventListener() {
            int c;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                List1.clear();
                List2.clear();
                PassengerList.clear();
                for (DataSnapshot artistsnapshot : dataSnapshot.getChildren()) {
                    Passenger passenger = artistsnapshot.getValue(Passenger.class);
                    for(c=0;c<pDetailsList.size();c++)
                    {
                        if(passenger.getPnrno().equals(pDetailsList.get(c).getPnr()))
                        {
                            if(pDetailsList.get(c).getCheck().equals("no"))
                                List1.add(passenger);
                            else
                                List2.add(passenger);
                        }
                    }
                    PassengerList.add(passenger);
                }
                PassengerAdapter adapter1= new PassengerAdapter(showPList.this, List1,0);
                PassengerAdapter adapter2= new PassengerAdapter(showPList.this, List2,1);
                listView1.setAdapter(adapter1);
                listView2.setAdapter(adapter2);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    public void sendChecked() {
        int c;
        for (String str : checkCount)
        {
            c=0;
            for(Pdetails pd:pDetailsList)
            {
                if(str.equals(pd.getPnr()))
                {
                    pd.check="yes";
                    databaseDetails.child(Integer.toString(c)).setValue(pd);
                    onStart();
                    break;
                }
                c++;
            }
        }

    }
}


