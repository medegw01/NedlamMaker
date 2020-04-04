package com.example.user.nedlamworkshop.IdeaBoard;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.user.nedlamworkshop.R;
import com.example.user.nedlamworkshop.helperclass.RequestHandler;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class add_idea extends Fragment implements View.OnClickListener {
    public static final String UPLOAD_URL = "http://medegw01.esy.es/UploadNedlam.php";
    public static final String UPLOAD_KEY = "image";
    final int PICK_IMAGE_REQUEST = 1;
    final int CAMERA_REQUEST = 2;
        View v;

    Button gallery,upload_button;
    ImageView diplay_picture, camera;
    EditText description, title;

    private Bitmap bitmap;
    Uri filePath;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the activated for this fragment
        v =  inflater.inflate(R.layout.add_idea, container, false);

        this.gallery = (Button) v.findViewById(R.id.gallery);
        this.upload_button = (Button) v.findViewById(R.id.upload_content);
        this.description = (EditText) v.findViewById(R.id.idea_description);
        this.title = (EditText) v.findViewById(R.id.title_idea);

        this.camera = (ImageView) v.findViewById(R.id.take_image);
        this.diplay_picture = (ImageView) v.findViewById(R.id.idea_image);

        this.gallery.setOnClickListener(this);
        this.upload_button.setOnClickListener(this);
        this.camera.setOnClickListener(this);


        return v;
    }

    private void showFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
   public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == PICK_IMAGE_REQUEST && data != null && data.getData() != null) {

            filePath = data.getData();


            try {
                this.bitmap = MediaStore.Images.Media.getBitmap(v.getContext().getContentResolver(), filePath);
                this.diplay_picture.setImageBitmap(this.bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (requestCode == CAMERA_REQUEST ) {
            String path = "sdcard/camera_app/cam_image.jpg";
            diplay_picture.setImageDrawable(Drawable.createFromPath(path));
        }
        else {
            Toast.makeText(v.getContext(),
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
        bmp.compress(Bitmap.CompressFormat.JPEG, 70, baos);
        byte[] imageBytes = baos.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return encodedImage;
    }

    private void uploadImage(){

        class UploadImage extends AsyncTask<Bitmap,Void,String> {
            Bitmap image;
            String description, title;

            public UploadImage(Bitmap image, String description, String title){
                this.image = image;
                this.description = description;
                this.title= title;
            }

            ProgressDialog loading;
            RequestHandler rh = new RequestHandler();

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(getContext(), "Uploading Image", "Please wait...",true,true);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(v.getContext(),s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Bitmap... params) {

                Bitmap bitmap = params[0];
                String uploadImage = getStringImage(bitmap);



                HashMap<String,String> data = new HashMap<>();
                data.put(UPLOAD_KEY, uploadImage);
                data.put("description", description);
                data.put("title", title);

                String result = rh.sendPostRequest(UPLOAD_URL,data);

                return result;
            }
        }

        String des = description.getText().toString();
        String I_title = title.getText().toString();
        UploadImage ui = new UploadImage(bitmap, des, I_title);
        ui.execute(bitmap);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.gallery:
                showFileChooser();
                break;
            case R.id.upload_content:
                uploadImage();
                break;
            case R.id.take_image:
                Camera(v);
                break;


        }
    }

   }
