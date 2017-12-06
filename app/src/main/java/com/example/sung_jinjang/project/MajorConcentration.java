package com.example.sung_jinjang.project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.content.Intent;

//Major Concentration Screen, Clicking "Register" Under Look Up Classes leads to this activity
public class MajorConcentration extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_major_concentration);


        //Button for Intent
        Button majorButton = (Button)findViewById(R.id.button6);
        //Intent to go back to three button screen
        majorButton.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        Intent myIntent = new Intent(v.getContext(), Main2Activity.class);
                        startActivity(myIntent);
                    }
                }
        );

        //Spinner or Drop Down Menu 1 "Choose a Major"
        final Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MajorConcentration.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.majors));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        //Spinner or Drop Down Menu 2 "Choose a concentration"
        final Spinner mySpinner2 = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(MajorConcentration.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.concentration));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(myAdapter2);
        mySpinner2.setEnabled(false);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mySpinner2.setSelection(position);

                //Enable "Choose a Concentration or mySpinner2 only if "B.C. Computer Science" is selected from Spinner 1
                String enableSpinner = mySpinner.getSelectedItem().toString();
                if(enableSpinner.equals("B.S. Computer Science")) {
                    mySpinner2.setEnabled(true);

                            mySpinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    mySpinner2.setSelection(position);
                                    String classV = mySpinner2.getSelectedItem().toString();
                                    //If HardWare Systems is selected in Spinner 2 and the user clicks search, start its activity to view its courses
                                    if(classV.equals("Hardware Systems")){
                                        Button searchButton = (Button)findViewById(R.id.sbutton);
                                        searchButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                Intent intent = new Intent(MajorConcentration.this, ClassesView.class);
                                                startActivity(intent);
                                            }
                                        });
                                    }
                                    //If Theoretical Computer Science is selected in Spinner 2 and the user clicks search, start its activity to view its courses
                                    if(classV.equals("Theoretical Computer Science")){
                                        Button searchButton = (Button)findViewById(R.id.sbutton);
                                        searchButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                Intent intent = new Intent(MajorConcentration.this, TheoreticalCompSci.class);
                                                startActivity(intent);
                                            }
                                        });
                                    }
                                    //If Computer Software Systems is selected in Spinner 2 and the user clicks search, start its activity to view its courses
                                    if(classV.equals("Computer Software Systems")){
                                        Button searchButton = (Button)findViewById(R.id.sbutton);
                                        searchButton.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view) {
                                                Intent intent = new Intent(MajorConcentration.this, CompSoftSys.class);
                                                startActivity(intent);
                                            }
                                        });
                                    }
                                }
                                @Override
                                public void onNothingSelected(AdapterView<?> adapterView) {
                                }
                            });
                } else {
                    mySpinner2.setEnabled(false);
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        mySpinner2.setAdapter(myAdapter2);
    }


}

