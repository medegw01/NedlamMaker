package com.example.user.nedlamworkshop;

import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by Michael on 7/28/2016.
 */
public class videoplayer extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_view);

        Button buttonPlayVideo2 = (Button) findViewById(R.id.video_button);
        VideoView videoView =(VideoView)findViewById(R.id.video);
        MediaController mediaController= new MediaController(this);
        mediaController.setAnchorView(videoView);
        Uri uri=Uri.parse("rtsp://r1---sn-vgqs7ned.googlevideo.com/Cj0LENy73wIaNAl4IEK2n0FyFxMYDSANFC1mG5pXMOCoAUIASARgopOQz_CgoLtXigELNUFVVGcxSFN3UUUM/730A70239F7CA8FE8A1A944E264FD4183B68C57E.C17AC58CFCAE15C548D4BE85D8733C3F8181AE38/yt6/1/video.3gp");
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();
        }
     }
