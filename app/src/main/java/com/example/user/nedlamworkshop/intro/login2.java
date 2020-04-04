package com.example.user.nedlamworkshop.intro;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.nedlamworkshop.R;
import com.example.user.nedlamworkshop.MainActivity;

public class login2 extends AppCompatActivity {
    EditText password;
    String passt= "hhh";
    EditText title;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login2);
        password=(EditText) findViewById(R.id.pass);
        title = (EditText) findViewById(R.id.ID);


    }
    public void login(View view) {
        String Apass = password.getText().toString();
        if(!Apass.equals(passt)){
            Toast pass = Toast.makeText(login2.this,"Access Denied!", Toast.LENGTH_SHORT);
            pass.show();
        }
        else {
            String name = title.getText().toString();
            Toast yeah = Toast.makeText(login2.this,"Welcome!", Toast.LENGTH_SHORT);
            yeah.show();
            Intent intent = new Intent(login2.this, MainActivity.class);
            intent .putExtra("name",name);
            startActivity(intent);
                                }
    }
}


