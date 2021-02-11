package com.example.m226_1_notentool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.IOException;
import java.net.URL;

public class ImageLoader implements Runnable {
    FirebaseAuth mAuth;
    FirebaseUser user;
    Bitmap bmp;

    @Override
    public void run() {
        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();

        try {
            if (user != null && user.getPhotoUrl() != null) {
                URL url = new URL(user.getPhotoUrl().toString());
                this.bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bitmap getImage() {
        return bmp;
    }
}
