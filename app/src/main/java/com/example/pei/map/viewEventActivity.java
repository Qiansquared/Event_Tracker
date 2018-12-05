package com.example.pei.map;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class viewEventActivity extends AppCompatActivity {

    ListView EventListView;
    String[] event_name;
    String[] event_host;
    String[] event_time;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_event);

        Resources res = getResources();
        EventListView = (ListView) findViewById(R.id.EventListView);
        event_name=res.getStringArray(R.array.event_name);
        event_host=res.getStringArray(R.array.event_host);
        event_time=res.getStringArray(R.array.event_time);

        nameAdapter nameAdapter = new nameAdapter(this,event_name,event_host,event_time);
        EventListView .setAdapter(nameAdapter);

        EventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
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
