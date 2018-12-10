package com.example.pei.map;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class addEventActivity1 extends AppCompatActivity {

    myDbAdapter helper;
    EditText TextName, TextHost, TextDesc;
    String StringName, StringHost, StringDesc;
    String StringDate, StringStart, StringEnd;
    //Button createEventButton;
    int location_int;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event1);
        helper = new myDbAdapter(this);


        TextName = (EditText) findViewById(R.id.TextName);
        TextHost = (EditText) findViewById(R.id.TextHost);
        TextDesc = (EditText) findViewById(R.id.TextDesc);



        Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.location_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        // read from spinner
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String location = parent.getItemAtPosition(position).toString();
                //Toast.makeText(parent.getContext(), "Selected: " + location, Toast.LENGTH_LONG).show();
                switch (location) {
                    case "GSU":
                        location_int = 1;
                        break;
                    case "FitRec":
                        location_int = 2;
                        break;
                    case "CAS":
                        location_int = 3;
                        break;
                    case "Questrom":
                        location_int = 4;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(parent.getContext(), "Nothing Selected ", Toast.LENGTH_LONG).show();
            }
        });


        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,
                R.array.month_array, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);


        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,
                R.array.hour_array, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                StringStart = parent.getItemAtPosition(position).toString();
                //Toast.makeText(parent.getContext(), "Selected: " + StringStart, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this,
                R.array.hour_array, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);
        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                StringEnd = parent.getItemAtPosition(position).toString();
                //Toast.makeText(parent.getContext(), "Selected: " + StringEnd, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        Spinner spinner5 = (Spinner) findViewById(R.id.spinner5);
        ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this,
                R.array.date_array, android.R.layout.simple_spinner_item);
        adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter5);
        spinner5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                StringDate = parent.getItemAtPosition(position).toString();
               // Toast.makeText(parent.getContext(), "Selected: " + StringDate, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }

       public void BackToMain(View view) {

           StringName = TextName.getText().toString();
           StringHost = TextHost.getText().toString();
           StringDesc = TextDesc.getText().toString();

        if (StringName.matches("")) {
            Toast.makeText(addEventActivity1.this, "Enter an event name"+StringName, Toast.LENGTH_LONG).show();
        } else if (StringHost.matches("")) {
            Toast.makeText(addEventActivity1.this, "Enter an host name", Toast.LENGTH_LONG).show();
        } else if (StringDesc.matches("")) {
            Toast.makeText(addEventActivity1.this, "Enter a description", Toast.LENGTH_LONG).show();
        } else {

            long id = helper.insertData(TextName.getText().toString(),TextHost.getText().toString(),TextDesc.getText().toString(),
                   location_int, Integer.parseInt(StringDate), Integer.parseInt(StringStart),Integer.parseInt(StringEnd));
             if(id == -1)
                Toast.makeText(addEventActivity1.this, "Add Event Fail",Toast.LENGTH_LONG).show();
             else
             {
                 Intent intent = new Intent(addEventActivity1.this, BackToMainActivity.class);
                 startActivity(intent);
             }
        }
    }
}











