package com.example.sung_jinjang.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

//Three Button Page - This page is shown after logging in
public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Button for intent
        Button majorButton = (Button)findViewById(R.id.button);

        //Intent to go to MajorConcentration page
        majorButton.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        Intent myIntent = new Intent(v.getContext(), MajorConcentration.class);
                        startActivity(myIntent);
                    }
                }
        );

        //Button for intent
        Button logOut = (Button)findViewById(R.id.button5);

        //Intent to logout
        logOut.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        Intent myIntent = new Intent(v.getContext(), MainActivity.class);
                        startActivity(myIntent);
                    }
                }
        );

        //Button for intent
        Button yourCourses = (Button)findViewById(R.id.button2);

        //Intent to view your courses
        yourCourses.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        Intent myIntent = new Intent(v.getContext(), Main4Activity.class);
                        startActivity(myIntent);
                    }
                }
        );

        //Button for intent
        Button weekView = (Button)findViewById(R.id.button3);

        //Intent to go to week view
        weekView.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        Intent myIntent = new Intent(v.getContext(), WeekView.class);
                        startActivity(myIntent);
                    }
                }
        );


    }
}
