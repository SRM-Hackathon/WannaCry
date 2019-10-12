package com.example.mysrmapp;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowDetails extends AppCompatActivity {
    Pdetails pdetails;
    Passenger artist;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdetails_layout);
        TextView pnr=(TextView) findViewById(R.id.textViewpnr);
        TextView tname=(TextView) findViewById(R.id.textViewtname);
        TextView tno=(TextView) findViewById(R.id.textViewtno);
        TextView reservclass=(TextView) findViewById(R.id.textViewclass);
        TextView age=(TextView) findViewById(R.id.textViewp_age);
        TextView pname=(TextView) findViewById(R.id.textViewp_name);
        TextView coach=(TextView) findViewById(R.id.textViewp_coach);
        TextView seat=(TextView) findViewById(R.id.textViewp_seat);
        TextView sex=(TextView) findViewById(R.id.textViewp_sex);
        TextView source=(TextView) findViewById(R.id.textViewp_source);
        TextView arrival=(TextView) findViewById(R.id.textViewp_arrival);
        TextView bookdate=(TextView) findViewById(R.id.textViewp_bookdate);
        TextView dest=(TextView) findViewById(R.id.textViewp_dest);
        TextView depart=(TextView) findViewById(R.id.textViewp_depart);
        TextView booktime=(TextView) findViewById(R.id.textViewp_booktime);
        TextView conc=(TextView) findViewById(R.id.textViewp_conc);
        TextView ticketno=(TextView) findViewById(R.id.textViewp_ticketno);
        TextView ticketcost=(TextView) findViewById(R.id.textViewp_ticketcost);
        TextView check=(TextView) findViewById(R.id.textViewp_check);

        String position=getIntent().getExtras().getString("position");
        String no=getIntent().getExtras().getString("listno");
        if(no.equals("0"))
        {
            artist=showPList.List1.get(Integer.parseInt(position));
        }
        else
        {
            artist=showPList.List2.get(Integer.parseInt(position));
        }
        for(Pdetails pd:showPList.pDetailsList)
        {
            if(pd.getPnr().equals(artist.getPnrno()))
            {
                pdetails=pd;
                break;
            }
        }

        pnr.setText(pdetails.getPnr());
        tname.setText(pdetails.getTrain_name());
        tno.setText(pdetails.getTrain_no());
        reservclass.setText(pdetails.getReserv_class());
        age.setText(pdetails.getAge());
        pname.setText(pdetails.getPname());
        coach.setText(pdetails.getCoach());
        seat.setText(pdetails.getSeat_no());
        sex.setText(pdetails.getSex());
        source.setText(pdetails.getSrc_stn());
        arrival.setText(pdetails.getArr_time());
        bookdate.setText(pdetails.getBooking_date());
        dest.setText(pdetails.getDest_stn());
        depart.setText(pdetails.getDep_time());
        booktime.setText(pdetails.getBooking_time());
        conc.setText(pdetails.getConc());
        ticketno.setText(pdetails.getTicket_no());
        ticketcost.setText(pdetails.getTcost());
        check.setText(pdetails.getCheck());
    }
}
