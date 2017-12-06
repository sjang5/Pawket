package com.example.sung_jinjang.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class WeekView extends AppCompatActivity {

    public static Button buttonWeekView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_view);

        buttonWeekView = (Button) findViewById(R.id.buttonWeekView);

        Button yourCourses = (Button)findViewById(R.id.button9);

        yourCourses.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        Intent myIntent = new Intent(v.getContext(), Main2Activity.class);
                        startActivity(myIntent);
                    }
                }

        );
    }

}
