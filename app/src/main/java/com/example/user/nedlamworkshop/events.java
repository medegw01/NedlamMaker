package com.example.user.nedlamworkshop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class events extends AppCompatActivity {
    //ImageButton events, projects, floorplan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);
    }
        /*
        events=(ImageButton) findViewById(R.id.event);
        events.setOnClickListener(this);
        projects=(ImageButton) findViewById(R.id.project);
        projects.setOnClickListener(this);
        floorplan=(ImageButton) findViewById(R.id.floorplan);
        floorplan.setOnClickListener(this);


    }
    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.event:
                startActivity(new Intent(this, events.class));
                break;
            case R.id.project:
                startActivity(new Intent(this, projects.class));
                break;

            case R.id.floorplan:
                startActivity(new Intent(this, floorplan.class));
                break;
            }
        }
       */
    }



