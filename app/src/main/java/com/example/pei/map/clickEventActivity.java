package com.example.pei.map;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class clickEventActivity extends AppCompatActivity {

    myDbAdapter helper;

    String [] event_name;
    String [] event_host;
    String [] event_startTime;
    String [] event_endTime;
   // String [] event_des;
    String [] event_loc;

    private TextView temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_event);
        helper = new myDbAdapter(this);

        Intent in = getIntent();
        //get id here
        int index = in.getIntExtra(" com.example.pei.EVENT_INDEX",-1);


        //Calendar calendar = Calendar.getInstance();
       // SimpleDateFormat format = new SimpleDateFormat();
       // String time = format.format(calendar.getTime());
        int day = 10;
        int hour = 3;


        Resources res = getResources();
        event_name=res.getStringArray(R.array.event_name);
        event_host=res.getStringArray(R.array.event_host);
        event_startTime=res.getStringArray(R.array.event_time);

        //set the names correspods to that id
        String name = event_name[index];
        String host = event_host[index];
        String time = event_startTime[index];

        TextView nameTextView = (TextView)findViewById(R.id.NameTextView);
        TextView hostTextView = (TextView)findViewById(R.id.HostTextView);
        TextView timeTextView = (TextView)findViewById(R.id.TimeTextView);

        nameTextView.setText(name);
        hostTextView.setText(host);
        timeTextView.setText(time);



    }

}
