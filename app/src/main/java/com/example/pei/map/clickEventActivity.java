package com.example.pei.map;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class clickEventActivity extends AppCompatActivity {

    String [] event_name;
    String [] event_host;
    String [] event_time;

    private TextView temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_event);

        Intent in = getIntent();
        int index = in.getIntExtra(" com.example.pei.EVENT_INDEX",-1);

        // displaying the event at index
        Resources res = getResources();
        event_name=res.getStringArray(R.array.event_name);
        event_host=res.getStringArray(R.array.event_host);
        event_time=res.getStringArray(R.array.event_time);

        String name = event_name[index];
        String host = event_host[index];
        String time = event_time[index];

        TextView nameTextView = (TextView)findViewById(R.id.NameTextView);
        TextView hostTextView = (TextView)findViewById(R.id.HostTextView);
        TextView timeTextView = (TextView)findViewById(R.id.TimeTextView);

        nameTextView.setText(name);
        hostTextView.setText(host);
        timeTextView.setText(time);

    }

}
