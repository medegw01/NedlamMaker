package com.example.user.nedlamworkshop.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.user.nedlamworkshop.R;

public class hammer extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.hammer, container, false);
        TextView txt = (TextView) v.findViewById(R.id.hammer);
        txt.setSelected(true);
        // Inflate the activated for this fragment
        return v;

    }

}