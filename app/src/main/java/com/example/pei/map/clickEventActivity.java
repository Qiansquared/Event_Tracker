package com.example.pei.map;

import android.content.Intent;
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
        int index = in.getIntExtra(" com.example.pei.EVENT_INDEX",-1);

        // displaying the event at index

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat format = new SimpleDateFormat("MM-dd-YY HH:mm:ss");
        String time = format.format(calendar.getTime());
        int day = Integer.parseInt(time.substring(3,5));
        int hour = Integer.parseInt(time.substring(9,11));

        //event_name=helper.getAllNamesData(day,hour);
        //event_host= helper.getAllDateData(day,hour);
        //event_startTime=helper.getAllStartData(day,hour);
        //event_endTime=helper.getAllEndData(day,hour);
        //event_des =
        //event_loc;



        String name = event_name[index];
        String host = event_host[index];
        //String time = event_time[index];

        TextView nameTextView = (TextView)findViewById(R.id.NameTextView);
        TextView hostTextView = (TextView)findViewById(R.id.HostTextView);
        TextView timeTextView = (TextView)findViewById(R.id.TimeTextView);

        nameTextView.setText(name);
        hostTextView.setText(host);
        timeTextView.setText(time);



    }

}
