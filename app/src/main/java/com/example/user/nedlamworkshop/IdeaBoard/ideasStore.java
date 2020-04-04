package com.example.user.nedlamworkshop.IdeaBoard;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * Created by Michael on 8/2/2016.
 */
public class ideasStore {
    private String title, description;
    private Bitmap image;
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setImg(Bitmap image) {
        /*byte[] decodedString = Base64.decode(img_string, Base64.DEFAULT);
        Bitmap image = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);*/
                this.image = image;
    }
    public Bitmap getImg() {
                return image;
    }
    public String getDescription() {
        return description;
    }
    public String getTitle() {
        return title;
    }
}
