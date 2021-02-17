package com.m226b.notentool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.io.IOException;
import java.net.URL;

public class ProfilePictureLoader implements Runnable {
    Bitmap bitmap;

    @Override
    public void run() {
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        try {
            if (user != null && user.getPhotoUrl() != null) {
                URL url = new URL(user.getPhotoUrl().toString());
                this.bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bitmap getImage() {
        return bitmap;
    }
}
