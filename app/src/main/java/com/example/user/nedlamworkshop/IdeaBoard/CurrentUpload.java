package com.example.user.nedlamworkshop.IdeaBoard;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.user.nedlamworkshop.R;
import com.example.user.nedlamworkshop.helperclass.RequestHandler;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class CurrentUpload extends AppCompatActivity implements View.OnClickListener {

    public static final String UPLOAD_URL = "http://medegw01.esy.es/upload.php";
    public static final String UPLOAD_KEY = "image";
    final int PICK_IMAGE_REQUEST = 1;
    final int CAMERA_REQUEST = 2;

    Button buttonChoose,download;
    ImageView imageView,buttonUpload, buttonTake;
    Bitmap bitmap;
    Uri filePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.upload);

        buttonChoose = (Button) findViewById(R.id.chooseimage);
        download = (Button) findViewById(R.id.downloadimage);

        buttonUpload = (ImageView) findViewById(R.id.uploadimage);
        buttonTake = (ImageView) findViewById(R.id.takeimage);
        imageView = (ImageView) findViewById(R.id.image);


        buttonChoose.setOnClickListener(this);
        download.setOnClickListener(this);
        buttonUpload.setOnClickListener(this);
        buttonTake.setOnClickListener(this);


    }
    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {

            filePath = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (requestCode == CAMERA_REQUEST ) {
            String path = "sdcard/camera_app/cam_image.jpg";
            imageView.setImageDrawable(Drawable.createFromPath(path));
        }
        else {
            Toast.makeText(getApplicationContext(),
                    "Something Wrong while loading photos", Toast.LENGTH_SHORT).show();
        }
    }
    public void Camera(View v){

        Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File file = getfile();
        camera_intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
        startActivityForResult(camera_intent,CAMERA_REQUEST);
    }
    private File getfile() {

        File folder = new File("sdcard/camera_app");
        if (!folder.exists()) {
            folder.mkdir();
        }
        File image_file = new File(folder, "cam_image.jpg");
        return image_file;
    }

    public String getStringImage(Bitmap bmp){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    private void uploadImage(){
        class UploadImage extends AsyncTask<Bitmap,Void,String>{

            ProgressDialog loading;
            RequestHandler rh = new RequestHandler();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(CurrentUpload.this, "Uploading Image", "Please wait...",true,true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Bitmap... params) {
                Bitmap bitmap = params[0];
                String uploadImage = getStringImage(bitmap);

                HashMap<String,String> data = new HashMap<>();
                data.put(UPLOAD_KEY, uploadImage);

                String result = rh.sendPostRequest(UPLOAD_URL,data);

                return result;
            }
        }

        UploadImage ui = new UploadImage();
        ui.execute(bitmap);
    }
    @Override
    public void onClick(View v) {
                switch (v.getId()) {
            case R.id.chooseimage:
                showFileChooser();
                break;
            case R.id.uploadimage:
                uploadImage();
                break;
            case R.id.downloadimage:
                startActivity(new Intent(this, ViewImage.class));
                break;
            case R.id.takeimage:
                //startActivity(new Intent(this, camera.class));
                Camera(v);
                break;


        }
    }

}