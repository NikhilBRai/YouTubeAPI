package com.example.myapplication;

import android.support.constraint.ConstraintLayout;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    static final String GOOGLE_API_KEY="AIzaSyDW5gy1D289EuyHz048f_IE5EKsw1Mql90";
    static final String YOUTUBE_VIDEO_ID="YYmADaFxQ8E";
    static final String YOUTUBE_PLAYLIST="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayout l=(ConstraintLayout)getLayoutInflater().inflate(R.layout.activity_youtube,null);
        setContentView(l);
        YouTubePlayerView y=new YouTubePlayerView(this);
        y.setLayoutParams(new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        l.addView(y);
        y.initialize(GOOGLE_API_KEY,this);
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        Toast.makeText(this, "intialized",Toast.LENGTH_LONG);
        youTubePlayer.setPlaybackEventListener(p);
        youTubePlayer.setPlayerStateChangeListener(m);
        if(!b)
        {
            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
        }

    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        final int REQUEST_CODE=1;

        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this,REQUEST_CODE).show();
        }else{
            String errorMessage=String.format("There was an error in intializing The YoutubePlayer (l$s)", youTubeInitializationResult.toString());
            Toast.makeText(this,errorMessage,Toast.LENGTH_LONG).show();
        }
    }
    private YouTubePlayer.PlaybackEventListener p=new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {

        }

        @Override
        public void onPaused() {

        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };
    private YouTubePlayer.PlayerStateChangeListener m= new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {

        }

        @Override
        public void onVideoEnded() {

        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };
}
