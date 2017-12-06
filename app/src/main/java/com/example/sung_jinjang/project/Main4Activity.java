package com.example.sung_jinjang.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


//View your Classes Page, "Courses" button leads to this activity
public class Main4Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

/*
        Bundle bundle = getIntent().getExtras();

        //pass data to string variables
        String data_1 = bundle.getString("cls");
        // String data_2 = bundle.getString("seconddata");

        //assign xml objects  for TextViews into varibles
        TextView textView8 = (TextView) findViewById(R.id.textView8);
        // TextView textView9 = (TextView) findViewById(R.id.textView9);

        textView8.setText(data_1);
        // textView9.setText(data_2);
*/


        //Button for intent
        Button backButton = (Button)findViewById(R.id.button8);

        //Intent to go back to Main2Activity (Three button page)
        backButton.setOnClickListener(
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
