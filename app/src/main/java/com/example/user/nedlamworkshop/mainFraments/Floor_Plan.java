package com.example.user.nedlamworkshop.mainFraments;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.example.user.nedlamworkshop.R;
import com.example.user.nedlamworkshop.floorplan;

/**
 * Created by Michael on 7/27/2016.
 */
public class Floor_Plan extends Fragment implements View.OnClickListener {

    View v;
    private Context mContext;
    private LinearLayout absoluteLayout;
    private Button triangle_area, brainstorming_area, woodwork_area, electronic_area, drill_area;
    private Button storage_area, tools_area, metresaw_area,work_area;

    private PopupWindow mPopupWindow;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.mike, container, false);

        //get the required data
        mContext = v.getContext();
        // Get the widgets reference from XML layout
        absoluteLayout = (LinearLayout) v.findViewById(R.id.floorplan_layout);
        //get button data
        tools_area = (Button) v.findViewById(R.id.tools_area);
        tools_area.setOnClickListener(this);
        triangle_area = (Button)v.findViewById(R.id.triangle_area);
        triangle_area.setOnClickListener(this);
        brainstorming_area = (Button)v.findViewById(R.id.brainstorming_area);
        brainstorming_area.setOnClickListener(this);
        woodwork_area = (Button) v.findViewById(R.id.woodwork_area);
        woodwork_area.setOnClickListener(this);
        electronic_area = (Button)v.findViewById(R.id.electronic_area);
        electronic_area.setOnClickListener(this);
        drill_area = (Button) v.findViewById(R.id.drill_area);
        drill_area.setOnClickListener(this);
        storage_area = (Button)v.findViewById(R.id.storage_area);
        storage_area.setOnClickListener(this);
        work_area = (Button)v.findViewById(R.id.work_area);
        work_area.setOnClickListener(this);
        metresaw_area = (Button)v.findViewById(R.id. metresaw_area);
        metresaw_area.setOnClickListener(this);
        return v;
    }



    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.electronic_area:
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
                View customView = inflater.inflate(R.layout.electronic_window, null);
                mPopupWindow = new PopupWindow(
                        customView,
                        ActionBar.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

                // Set an elevation value for popup window
                // Call requires API level 21
                if (Build.VERSION.SDK_INT >= 21) {
                    mPopupWindow.setElevation(5.0f);
                }
                // Get a reference for the custom view close button
                ImageButton electronic_close = (ImageButton) customView.findViewById(R.id.electronic_close);

                // Set a click listener for the popup window close button
                electronic_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();

                    }
                });
                ImageButton electronic_close2 = (ImageButton) customView.findViewById(R.id.electronic2_close);

                // Set a click listener for the popup window close button
                electronic_close2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();

                    }
                });
                mPopupWindow.showAtLocation(absoluteLayout, Gravity.CENTER, 0, 0);
                break;
            case R.id.metresaw_area:
                LayoutInflater inflater1 = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
                View customView1 = inflater1.inflate(R.layout.metresaw_window, null);
                mPopupWindow = new PopupWindow(
                        customView1,
                        ActionBar.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

                // Set an elevation value for popup window
                // Call requires API level 21
                if (Build.VERSION.SDK_INT >= 21) {
                    mPopupWindow.setElevation(5.0f);
                }
                // Get a reference for the custom view close button
                ImageButton metre_close = (ImageButton) customView1.findViewById(R.id.metresaw_close);

                // Set a click listener for the popup window close button
                metre_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();

                    }
                });
                ImageButton metre_close2 = (ImageButton) customView1.findViewById(R.id.metresaw2_close);

                // Set a click listener for the popup window close button
                metre_close2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();

                    }
                });
                ImageButton metre_close3 = (ImageButton) customView1.findViewById(R.id.metresaw3_close);

                // Set a click listener for the popup window close button
                metre_close3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();

                    }
                });
                mPopupWindow.showAtLocation(absoluteLayout, Gravity.CENTER, 0, 0);
                break;

            case R.id.work_area:
                LayoutInflater inflater3 = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
                View customView3 = inflater3.inflate(R.layout.workarea_window, null);
                mPopupWindow = new PopupWindow(
                        customView3,
                        ActionBar.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

                // Set an elevation value for popup window
                // Call requires API level 21
                if (Build.VERSION.SDK_INT >= 21) {
                    mPopupWindow.setElevation(5.0f);
                }
                // Get a reference for the custom view close button
                ImageButton workarea_close = (ImageButton) customView3.findViewById(R.id.workarea_close);
                // Set a click listener for the popup window close button
                workarea_close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();

                    }
                });
                // Set a click listener for the popup window close button
                mPopupWindow.showAtLocation(absoluteLayout, Gravity.CENTER, 0, 0);
                break;
            case R.id.brainstorming_area:
                LayoutInflater inflater4 = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
                View customView4 = inflater4.inflate(R.layout.brainstorming_window, null);
                mPopupWindow = new PopupWindow(
                        customView4,
                        ActionBar.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

                // Set an elevation value for popup window
                // Call requires API level 21
                if (Build.VERSION.SDK_INT >= 21) {
                    mPopupWindow.setElevation(5.0f);
                }
                // Get a reference for the custom view close button
                ImageButton brainstorming = (ImageButton) customView4.findViewById(R.id.brainstorming_close);
                // Set a click listener for the popup window close button
                brainstorming .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();

                    }
                });

                mPopupWindow.showAtLocation(absoluteLayout, Gravity.CENTER, 0, 0);
                break;
            case R.id.drill_area:
                LayoutInflater inflater5 = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
                View customView5 = inflater5.inflate(R.layout.drillpress_window, null);
                mPopupWindow = new PopupWindow(
                        customView5,
                        ActionBar.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

                // Set an elevation value for popup window
                // Call requires API level 21
                if (Build.VERSION.SDK_INT >= 21) {
                    mPopupWindow.setElevation(5.0f);
                }
                // Get a reference for the custom view close button
                ImageButton drillpress = (ImageButton) customView5.findViewById(R.id.drillpress_close);
                // Set a click listener for the popup window close button
                drillpress.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();

                    }
                });
                mPopupWindow.showAtLocation(absoluteLayout, Gravity.CENTER, 0, 0);
                break;

            case R.id.triangle_area:
                LayoutInflater inflater6 = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
                View customView6 = inflater6.inflate(R.layout.triangle_window, null);
                mPopupWindow = new PopupWindow(
                        customView6,
                        ActionBar.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

                // Set an elevation value for popup window
                // Call requires API level 21
                if (Build.VERSION.SDK_INT >= 21) {
                    mPopupWindow.setElevation(5.0f);
                }
                // Get a reference for the custom view close button
                ImageButton triangle = (ImageButton) customView6.findViewById(R.id.triangle_close);
                // Set a click listener for the popup window close button
                triangle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();

                    }
                });
                mPopupWindow.showAtLocation(absoluteLayout, Gravity.CENTER, 0, 0);
                break;
            case R.id.woodwork_area:
                LayoutInflater inflater7 = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
                View customView7 = inflater7.inflate(R.layout.woodwork_window, null);
                mPopupWindow = new PopupWindow(
                        customView7,
                        ActionBar.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

                // Set an elevation value for popup window
                // Call requires API level 21
                if (Build.VERSION.SDK_INT >= 21) {
                    mPopupWindow.setElevation(5.0f);
                }
                // Get a reference for the custom view close button
                ImageButton woodwork = (ImageButton) customView7.findViewById(R.id.woodwork_close);
                ImageButton woodwork2 = (ImageButton) customView7.findViewById(R.id.woodwork2_close);
                // Set a click listener for the popup window close button
                woodwork.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();

                    }
                });
                woodwork2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();

                    }
                });
                mPopupWindow.showAtLocation(absoluteLayout, Gravity.CENTER, 0, 0);
                break;
            case R.id.tools_area:
                LayoutInflater inflater8 = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
                View customView8 = inflater8.inflate(R.layout.tools_window, null);
                mPopupWindow = new PopupWindow(
                        customView8,
                        ActionBar.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

                // Set an elevation value for popup window
                // Call requires API level 21
                if (Build.VERSION.SDK_INT >= 21) {
                    mPopupWindow.setElevation(5.0f);
                }
                // Get a reference for the custom view close button
                ImageButton tools = (ImageButton) customView8.findViewById(R.id.woodwork_close);
                // Set a click listener for the popup window close button
                tools.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();

                    }
                });
                mPopupWindow.showAtLocation(absoluteLayout, Gravity.CENTER, 0, 0);
                break;
            case R.id.storage_area:
                LayoutInflater inflater9 = (LayoutInflater) mContext.getSystemService(mContext.LAYOUT_INFLATER_SERVICE);
                View customView9 = inflater9.inflate(R.layout.storage_window, null);
                mPopupWindow = new PopupWindow(
                        customView9,
                        ActionBar.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

                // Set an elevation value for popup window
                // Call requires API level 21
                if (Build.VERSION.SDK_INT >= 21) {
                    mPopupWindow.setElevation(5.0f);
                }
                // Get a reference for the custom view close button
                ImageButton storage = (ImageButton) customView9.findViewById(R.id.storagearea_close);
                // Set a click listener for the popup window close button
                storage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();

                    }
                });
                mPopupWindow.showAtLocation(absoluteLayout, Gravity.CENTER, 0, 0);
                break;
        }
    }

}

