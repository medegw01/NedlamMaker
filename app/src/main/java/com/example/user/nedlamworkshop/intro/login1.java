package com.example.user.nedlamworkshop.intro;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.user.nedlamworkshop.R;

public class login1 extends AppCompatActivity implements View.OnClickListener {
    Button members, others;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login1);
        members = (Button) findViewById(R.id.member);
        members.setOnClickListener(this);
        others = (Button) findViewById(R.id.others);
        others.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.member:
                startActivity(new Intent(this, login2.class));
                break;
            case R.id.others:
                Toast.makeText(login1.this,"Welcome to Nedlam's Facebook page!", Toast.LENGTH_LONG).show();
                browser("https://www.facebook.com/nelamsworkshop/?fref=ts");
                break;
        }
    }

    private void browser(String s) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(s));
        startActivity(browserIntent);
    }
}