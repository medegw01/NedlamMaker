package com.example.user.nedlamworkshop.IdeaBoard;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

//import org.apache.http.NameValuePair;
//import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpParams;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
public class upload extends AppCompatActivity{
//public class upload extends AppCompatActivity implements View.OnClickListener {
   /* private static final int IMAGE_ID = 1;
    Button uploadimage;
    ImageView image2upload;
    EditText imagename;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.activated.upload);
        uploadimage = (Button) findViewById(R.id.uploadimage);
        image2upload = (ImageView) findViewById(R.id.image2upload);
        imagename = (EditText) findViewById(R.id.imagename);
        uploadimage.setOnClickListener(this);
        image2upload.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.image2upload:
                Intent gIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gIntent, IMAGE_ID);
                break;
            case R.id.uploadimage:
                Bitmap image = ((BitmapDrawable) image2upload.getDrawable()).getBitmap();
                break;
            }
        }
       @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == IMAGE_ID && resultCode == RESULT_OK && data != null) {
            Uri ImageSelected = data.getData();
            image2upload.setImageURI(ImageSelected);
        }
    }
    private class UploadImage extends AsyncTask<Void, Void, Void>{
        Bitmap image;
        String name;
        public UploadImage(Bitmap image, String name) {
            this.image = image;
            this.name = name;
                    }

        @Override
        protected Void doInBackground(Void... params) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            image.compress(Bitmap.CompressFormat.JPEG, 100,byteArrayOutputStream);
            String encodedImage = Base64.encodeToString(byteArrayOutputStream.toByteArray(),Base64.DEFAULT);

            ArrayList<NameValuePair> dataToSend = new ArrayList<>();
            dataToSend.add(new BasicNameValuePair("image", encodedImage));
            dataToSend.add(new BasicNameValuePair("name", name));
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }

    private HttpParams getHttpRequestParams(){
        HttpParams httpRequestParams = new

    }*/
}



