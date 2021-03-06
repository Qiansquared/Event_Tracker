package com.example.pei.map;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class viewEventActivity extends AppCompatActivity {
    //data base
    myDbAdapter helper;

    ListView EventListView;
    String[] event_name;
    String[] event_host;
    String[] event_time;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event);
        helper = new myDbAdapter(this);

        //Calendar calendar = Calendar.getInstance();
       // SimpleDateFormat format = new SimpleDateFormat("MM-dd-YY HH:mm:ss");
       // String time = format.format(calendar.getTime());
       // int day = Integer.parseInt(time.substring(3,5));
        //int hour = Integer.parseInt(time.substring(9,11));

        int day = 10;
        int hour  = 4;


        EventListView = (ListView) findViewById(R.id.EventListView);
        //pass the string here
        //event_name=helper.getAllNamesData(day,hour);
        //= helper.getAllDateData(day,hour);
       // event_time=helper.getAllStartData(day,hour); //?is it a string
        // add id here


        Resources res = getResources();
        event_name=res.getStringArray(R.array.event_name);
        event_host=res.getStringArray(R.array.event_host);
        event_time=res.getStringArray(R.array.event_time);



        nameAdapter nameAdapter = new nameAdapter(this,event_name,event_host,event_time);
        EventListView .setAdapter(nameAdapter);


        EventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                //find thr i th element in id and pass it
                Intent showDetailEvent = new Intent (getApplicationContext(),clickEventActivity.class);
                showDetailEvent.putExtra(" com.example.pei.EVENT_INDEX",i);
                startActivity(showDetailEvent);
            }
        });

    }

    public void LoginPage(View view)
    {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void MapView(View view)
    {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }

}
