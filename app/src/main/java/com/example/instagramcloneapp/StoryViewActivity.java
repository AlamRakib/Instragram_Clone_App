package com.example.instagramcloneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class StoryViewActivity extends AppCompatActivity {

    ProgressBar progressBar;
    ImageView imageView;
    int progress;

    public static Bitmap MyBitmap = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_view);


        progressBar = findViewById(R.id.progressBarId);
        imageView = findViewById(R.id.imageView);

        if(MyBitmap!=null)
        {
            imageView.setImageBitmap(MyBitmap);
        }



        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
            }
        });
        thread.start();
    }

    void doWork()
    {

        for(progress=10; progress<=100; progress = progress+30)
        {
            try {
                Thread.sleep(1500);
                progressBar.setProgress(progress);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    void startApp()
    {
        finish();

    }
    
}