package com.example.sung_jinjang.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gr.net.maroulis.library.EasySplashScreen;
import android.graphics.Color;
import android.view.View;


//Splash Screen, the first screen you see when you open the app.
//Blue Screen that displays the android Logo, "Welcome Student" and "Team 5 Project"
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EasySplashScreen config = new EasySplashScreen(SplashScreen.this)
                .withFullScreen()
                .withTargetActivity(MainActivity.class)
                .withSplashTimeOut(2000)
                .withBackgroundColor(Color.parseColor("#3957c1"))
                .withBeforeLogoText("PAWKET")
                .withLogo(R.mipmap.ic_launcher);


        //Set to View
        View view = config.create();

        //Set view to content view
        setContentView(view);

    }



}
