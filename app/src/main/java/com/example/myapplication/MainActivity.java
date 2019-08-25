package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button single_video=(Button)findViewById(R.id.single_video);
        Button sub_menu=(Button)findViewById(R.id.sub_menu);

        single_video.setOnClickListener(this);
        sub_menu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=null;
                switch(v.getId()){
                    case R.id.single_video:
                        intent=new Intent(this, YoutubeActivity.class);
                        break;
                    case R.id.sub_menu:
                        intent=new Intent(this, PlaylistActivity.class);
                        break;
                        default:
                }
                if(intent!=null){
                    startActivity(intent);
                }

    }
}
