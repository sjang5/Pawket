/*
package com.example.sung_jinjang.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Button majorButton = (Button) findViewById(R.id.button7);
        final EditText un = (EditText) findViewById(R.id.userName);
        final EditText pw = (EditText) findViewById(R.id.passWord);

        majorButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if (un.getText().toString().equals("admin@student.gsu.edu") && pw.getText().toString().equals("admin")) {
                            Intent myIntent = new Intent(v.getContext(), Main2Activity.class);
                            startActivity(myIntent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Invalid Username/Password", Toast.LENGTH_LONG).show();
                        }

                    }
                });

    }
}

*/

