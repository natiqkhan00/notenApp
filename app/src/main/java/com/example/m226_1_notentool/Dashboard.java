package com.example.m226_1_notentool;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Dashboard extends AppCompatActivity {
    ImageView imageView;
    RecyclerView semesterList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        imageView = findViewById(R.id.profilePicture);
        semesterList = findViewById(R.id.semesterList);

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

        semesterList.setLayoutManager(new LinearLayoutManager(this));
        String[] semesters = {"Semester 1", "Semester 2", "Semester 3", "Semester 4", "Semester 5", "Semester 6", "Semester 7", "Semester 8", "Semester 9"};
        semesterList.setAdapter(new SemesterAdapter(semesters));
    }
}
