package com.example.pei.map;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MarkerActivity extends AppCompatActivity {

    private TextView temp;
    ListView MarkerEventList;
    String[] event_name;
    String[] event_host;
    String[] event_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marker);

        temp = (TextView) findViewById(R.id.NameTextView);
        temp.setText(getIntent().getExtras().getString("PASS_NAME"));


        Resources res = getResources();
        MarkerEventList = (ListView) findViewById(R.id.MarkerEventList);
        event_name=res.getStringArray(R.array.event_name);
        event_host=res.getStringArray(R.array.event_host);
        event_time=res.getStringArray(R.array.event_time);

        nameAdapter nameAdapter = new nameAdapter(this,event_name,event_host,event_time);
        MarkerEventList.setAdapter(nameAdapter);

        MarkerEventList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent showDetailEvent = new Intent (getApplicationContext(),clickEventActivity.class);
                showDetailEvent.putExtra(" com.example.pei.EVENT_INDEX",i);
                startActivity(showDetailEvent);
            }
        });

    }

    public void BackToMapView(View view)
    {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }


}
