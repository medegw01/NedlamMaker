package com.example.user.nedlamworkshop.IdeaBoard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.user.nedlamworkshop.R;

import java.io.File;
import java.io.IOException;

/**
 * Created by Michael on 7/21/2016.
 */
public class camera extends AppCompatActivity {

    private Button camera;
    private ImageView imageView;
    final int CAMERA_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);
        camera = (Button) findViewById(R.id.camera);
        imageView = (ImageView) findViewById(R.id.image1);

        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getfile();
                camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(camera_intent,CAMERA_REQUEST);
            }
        });

    }
    private File getfile(){

        File folder = new File("sdcard/camera_app");
        if(!folder.exists()){
            folder.mkdir();
        }
        File image_file = new File(folder, "cam_image.jpg");
        return image_file;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String path = "sdcard/camera_app/cam_image.jpg";
        if (requestCode == CAMERA_REQUEST ) {
            imageView.setImageDrawable(Drawable.createFromPath(path));
        } else {
            Toast.makeText(getApplicationContext(),
            "Something Wrong while loading photos", Toast.LENGTH_SHORT).show();
        }
    }
}