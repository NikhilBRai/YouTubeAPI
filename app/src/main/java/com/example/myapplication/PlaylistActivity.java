package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class PlaylistActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        Button single_video=findViewById(R.id.video);
        Button playlist=findViewById(R.id.playlist);

        single_video.setOnClickListener(this);
        playlist.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=null;

        switch(v.getId())
        {
            case R.id.video:
                intent= YouTubeStandalonePlayer.createVideoIntent(this, YoutubeActivity.GOOGLE_API_KEY, YoutubeActivity.YOUTUBE_VIDEO_ID);
                break;
            case R.id.playlist:
                intent=YouTubeStandalonePlayer.createVideoIntent(this,YoutubeActivity.GOOGLE_API_KEY,YoutubeActivity.YOUTUBE_PLAYLIST);
                break;
            default:
        }
        if(intent!=null){
            startActivity(intent);
        }
    }
}
