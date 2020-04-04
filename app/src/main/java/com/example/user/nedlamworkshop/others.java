package com.example.user.nedlamworkshop;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class others extends AppCompatActivity implements View.OnClickListener {
    ImageButton events, projects, floorplan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.others);
        events=(ImageButton) findViewById(R.id.events);
        events.setOnClickListener(this);
        projects=(ImageButton) findViewById(R.id.projects);
        projects.setOnClickListener(this);
        floorplan=(ImageButton) findViewById(R.id.floorplans);
        floorplan.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.events:
                startActivity(new Intent(this, events.class));
                break;
            case R.id.projects:
                startActivity(new Intent(this, projects.class));
                break;
            case R.id.floorplans:
                startActivity(new Intent(this, floorplan.class));
                break;
            }
        }
    }


