package com.example.m226_1_notentool;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import java.io.IOException;

public class Profile extends AppCompatActivity {

    TextView name, mail;
    Button logout;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        logout = findViewById(R.id.logout);
        name = findViewById(R.id.name);
        mail = findViewById(R.id.mail);
        imageView = findViewById(R.id.imageView);

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccount != null){
            Log.w("All Data", signInAccount.toString() );
            name.setText(signInAccount.getDisplayName());
            mail.setText(signInAccount.getEmail());
            imageView.setBackgroundColor(Color.RED);
            Picasso.get().load("https://ze-robot.com/dl/ul/ultraviolet-4k-wallpaper-3840%C3%972160.jpg").into(imageView);


            Log.w("Profile", "onCreate: " + signInAccount.getPhotoUrl());
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });


    }
}