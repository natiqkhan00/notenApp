package com.m226b.notentool;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Dashboard extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        imageView = findViewById(R.id.profilePicture);

        ProfilePictureLoader profilePictureLoader = new ProfilePictureLoader();
        Thread thread = new Thread(profilePictureLoader);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Bitmap bmp = profilePictureLoader.getImage();
        imageView.setImageBitmap(bmp);
    }
}
