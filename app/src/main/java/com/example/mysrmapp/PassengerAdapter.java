package com.example.mysrmapp;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.annotations.Nullable;

import java.util.List;

public class PassengerAdapter extends ArrayAdapter<Passenger> {
    private Activity context;
    private List<Passenger> artistList;
    public CheckBox checkbox;
    int flag;
    int count = 0;

    public PassengerAdapter( Activity context, List<Passenger> artistList, int flag) {
        super(context, R.layout.list_layout, artistList);
        this.context = context;
        this.artistList = artistList;
        this.flag = flag;
    }

    //@NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);

        TextView textViewPnr = (TextView) listViewItem.findViewById(R.id.textViewPnr);
        TextView textViewName = (TextView) listViewItem.findViewById(R.id.textViewName);
        Button mybutton = (Button) listViewItem.findViewById(R.id.detailButton);
        checkbox = (CheckBox) listViewItem.findViewById(R.id.checkBox);

        mybutton.setTag(position);
        mybutton.setOnClickListener(myButtonClickListener);


        if (flag == 0) {
            checkbox.setTag(position);
            //checkbox.setOnClickListener(myCheckboxClickListener);
            checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    Passenger artist=showPList.List1.get(position);
                    if(isChecked)
                    {
                        showPList.checkCount.add(artist.getPnrno());

                    }
                    else{
                        showPList.checkCount.remove(artist.getPnrno());
                    }



                }
            });

        }


        Passenger artist = artistList.get(position);

        textViewName.setText(artist.getPname());
        textViewPnr.setText(artist.getPnrno());

        if (flag == 1)
            checkbox.setChecked(true);

        return listViewItem;

    }

    private View.OnClickListener myButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position = (Integer) v.getTag();
            Intent i = new Intent(v.getContext(), ShowDetails.class);
            i.putExtra("position", Integer.toString(position));
            if (flag == 0)
                i.putExtra("listno", "0");
            else
                i.putExtra("listno", "1");
            v.getContext().startActivity(i);

        }
    };
}
