package com.example.user.nedlamworkshop.intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.user.nedlamworkshop.IdeaBoard.view_IdeaA;
import com.example.user.nedlamworkshop.R;


/**
 * Created by Michael on 7/27/2016.
 */
public class WelcomePage extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);


        //first text
        TextView  txt = (TextView) this.findViewById(R.id.txt);
        txt.setSelected(true);
        //txt.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        //txt.setSingleLine(true);


        //second text
        TextView  txt2 = (TextView) this.findViewById(R.id.txt2);
        txt2.setSelected(true);
        //txt2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        //txt2.setSingleLine(true);

    }


    public void next(View view) {

        startActivity(new Intent(this, login1.class));


    }

}


