package com.example.m226_1_notentool;

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

        ImageLoader imageLoader = new ImageLoader();
        Thread thread = new Thread(imageLoader);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Bitmap bmp = imageLoader.getImage();
        imageView.setImageBitmap(bmp);
    }
}
