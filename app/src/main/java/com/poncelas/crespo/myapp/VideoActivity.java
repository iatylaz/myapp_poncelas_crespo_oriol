package com.poncelas.crespo.myapp;

import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {

    WebView webView;
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_video);

        videoView = findViewById(R.id.videoView);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() +"/"+ R.raw.video_j1));
        MediaController mediaController = new MediaController(this);

        videoView.setMediaController(mediaController);
        videoView.start();
atras();
    }
    private void atras(){
        getSupportActionBar().setTitle("VIDEO PLAYER");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
