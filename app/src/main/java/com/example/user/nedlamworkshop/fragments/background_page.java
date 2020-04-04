package com.example.user.nedlamworkshop.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;

import com.example.user.nedlamworkshop.R;

public class background_page extends Fragment implements View.OnClickListener {
    ViewFlipper viewFlipper;
    View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the activated for this fragment

        v = inflater.inflate(R.layout.slideshow, container, false);
        viewFlipper = (ViewFlipper) v.findViewById(R.id.viewFlipper);
        viewFlipper.setOnClickListener(this);
        return v;
    }
    @Override
    public void onClick(View v) {
        viewFlipper.startFlipping();
        viewFlipper.setFlipInterval(3000);
    }
}