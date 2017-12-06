package com.example.sung_jinjang.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import android.widget.TextView;
import android.widget.Toast;

//Theoretical CompSci concentration activity
public class TheoreticalCompSci extends AppCompatActivity {

    ArrayList<String> selectedItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theoretical_comp_sci);

        final ListView ch1 = (ListView) findViewById(R.id.listview_classes);
        ch1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] classes = {
                "CSC 4340 : Introduction to Compilers : MW 1:00-2:15",  //index 0
                "CSC 4510 : Automata : TR 1:00-2:15",                   //index 1
                "CSC 4610 : Numerical Analysis I : MW 3:00-4:15",       //index 2
                "CSC 4620 : Numerical Analysis II : TR 1:30-2:45",      //index 3
                "CSC 4370 : Web Programming : F 12:00-1:15 (FULL) WaitList Enabled"

        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.rowlayout, R.id.txt_lan, classes);
        ch1.setAdapter(adapter);
        ch1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = ((TextView) view).getText().toString();
                //If item is checked, clicking it again will uncheck it
                if (selectedItems.contains(selectedItem)) {
                    selectedItems.remove(selectedItem);
                } else
                    selectedItems.add(selectedItem);
                //If these two courses are selected at the same time, display Toast "Time Conflict"
                if ((selectedItems.toString().contains("CSC 4620 : Numerical Analysis II : TR 1:30-2:45") && selectedItems.toString().contains("CSC 4510 : Automata : TR 1:00-2:15")) == true) {
                    Toast.makeText(getApplicationContext(), "Time conflict", Toast.LENGTH_LONG).show();
                }
                //If this course is selected, Disable index 1 or "Automata"
                if (selectedItems.toString().contains("CSC 4620 : Numerical Analysis II : TR 1:30-2:45")) {
                    ch1.getChildAt(1).setEnabled(false);
                } else {
                    ch1.getChildAt(1).setEnabled(true);
                }
                //If this course ise selected, disable index 3 or "Numerical Analysis II
                if (selectedItems.toString().contains("CSC 4510 : Automata : TR 1:00-2:15")) {
                    ch1.getChildAt(3).setEnabled(false);

                } else {
                    ch1.getChildAt(3).setEnabled(true);
                }
            }
        });

        //Button for intent
        Button concen = (Button) findViewById(R.id.button10);
        //Intent to go back to MajorConcentration Class
        concen.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(v.getContext(), MajorConcentration.class);
                        startActivity(myIntent);
                    }
                }
        );

        Button courseV = (Button) findViewById(R.id.courseView);
        //Intent to go back to MajorConcentration Class
        courseV.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        if ((selectedItems.toString().contains("CSC 4620 : Numerical Analysis II : TR 1:30-2:45")) && (selectedItems.toString().contains("CSC 4610 : Numerical Analysis I : MW 3:00-4:15")) && (selectedItems.toString().contains("CSC 4340 : Introduction to Compilers : MW 1:00-2:15")) && (selectedItems.toString().contains("CSC 4370 : Web Programming : F 12:00-1:15 (FULL) WaitList Enabled"))) {
                            setContentView(R.layout.activity_main4);
                            TextView a = (TextView) findViewById(R.id.csc4620);
                            a.setVisibility(View.VISIBLE);
                            TextView b = (TextView) findViewById(R.id.csc4610);
                            b.setVisibility(View.VISIBLE);
                            TextView c = (TextView) findViewById(R.id.csc4340);
                            c.setVisibility(View.VISIBLE);
                            TextView d = (TextView) findViewById(R.id.csc4370);
                            d.setVisibility(View.VISIBLE);
                        }
                        else if ((selectedItems.toString().contains("CSC 4620 : Numerical Analysis II : TR 1:30-2:45")) && (selectedItems.toString().contains("CSC 4610 : Numerical Analysis I : MW 3:00-4:15")) && (selectedItems.toString().contains("CSC 4340 : Introduction to Compilers : MW 1:00-2:15"))) {
                            setContentView(R.layout.activity_main4);
                            TextView a = (TextView) findViewById(R.id.csc4620);
                            a.setVisibility(View.VISIBLE);
                            TextView b = (TextView) findViewById(R.id.csc4610);
                            b.setVisibility(View.VISIBLE);
                            TextView c = (TextView) findViewById(R.id.csc4340);
                            c.setVisibility(View.VISIBLE);
                        } else if ((selectedItems.toString().contains("CSC 4510 : Automata : TR 1:00-2:15")) && (selectedItems.toString().contains("CSC 4610 : Numerical Analysis I : MW 3:00-4:15")) && (selectedItems.toString().contains("CSC 4340 : Introduction to Compilers : MW 1:00-2:15")) && (selectedItems.toString().contains("CSC 4370 : Web Programming : F 12:00-1:15 (FULL) WaitList Enabled"))) {
                            setContentView(R.layout.activity_main4);
                            TextView a = (TextView) findViewById(R.id.csc4510);
                            a.setVisibility(View.VISIBLE);
                            setContentView(R.layout.activity_main4);
                            TextView b = (TextView) findViewById(R.id.csc4610);
                            b.setVisibility(View.VISIBLE);
                            TextView c = (TextView) findViewById(R.id.csc4340);
                            c.setVisibility(View.VISIBLE);
                            TextView d = (TextView) findViewById(R.id.csc4370);
                            d.setVisibility(View.VISIBLE);
                        }
                        else if ((selectedItems.toString().contains("CSC 4510 : Automata : TR 1:00-2:15")) && (selectedItems.toString().contains("CSC 4610 : Numerical Analysis I : MW 3:00-4:15")) && (selectedItems.toString().contains("CSC 4340 : Introduction to Compilers : MW 1:00-2:15"))) {
                            setContentView(R.layout.activity_main4);
                            TextView a = (TextView) findViewById(R.id.csc4510);
                            a.setVisibility(View.VISIBLE);
                            setContentView(R.layout.activity_main4);
                            TextView b = (TextView) findViewById(R.id.csc4610);
                            b.setVisibility(View.VISIBLE);
                            TextView c = (TextView) findViewById(R.id.csc4340);
                            c.setVisibility(View.VISIBLE);
                        } else if ((selectedItems.toString().contains("CSC 4620 : Numerical Analysis II : TR 1:30-2:45")) && (selectedItems.toString().contains("CSC 4610 : Numerical Analysis I : MW 3:00-4:15")) && (selectedItems.toString().contains("CSC 4370 : Web Programming : F 12:00-1:15 (FULL) WaitList Enabled"))) {
                            setContentView(R.layout.activity_main4);
                            TextView a = (TextView) findViewById(R.id.csc4610);
                            a.setVisibility(View.VISIBLE);
                            TextView b = (TextView) findViewById(R.id.csc4620);
                            b.setVisibility(View.VISIBLE);
                            TextView c = (TextView) findViewById(R.id.csc4370);
                            c.setVisibility(View.VISIBLE);
                        }
                        else if ((selectedItems.toString().contains("CSC 4620 : Numerical Analysis II : TR 1:30-2:45")) && (selectedItems.toString().contains("CSC 4610 : Numerical Analysis I : MW 3:00-4:15"))) {
                            setContentView(R.layout.activity_main4);
                            TextView a = (TextView) findViewById(R.id.csc4610);
                            a.setVisibility(View.VISIBLE);
                            TextView b = (TextView) findViewById(R.id.csc4620);
                            b.setVisibility(View.VISIBLE);
                        }  else if ((selectedItems.toString().contains("CSC 4510 : Automata : TR 1:00-2:15")) && (selectedItems.toString().contains("CSC 4610 : Numerical Analysis I : MW 3:00-4:15")) && (selectedItems.toString().contains("CSC 4370 : Web Programming : F 12:00-1:15 (FULL) WaitList Enabled"))) {
                            setContentView(R.layout.activity_main4);
                            TextView a = (TextView) findViewById(R.id.csc4510);
                            a.setVisibility(View.VISIBLE);
                            TextView b = (TextView) findViewById(R.id.csc4610);
                            b.setVisibility(View.VISIBLE);
                            TextView c = (TextView) findViewById(R.id.csc4370);
                            c.setVisibility(View.VISIBLE);
                        } else if ((selectedItems.toString().contains("CSC 4510 : Automata : TR 1:00-2:15")) && (selectedItems.toString().contains("CSC 4610 : Numerical Analysis I : MW 3:00-4:15"))) {
                            setContentView(R.layout.activity_main4);
                            TextView a = (TextView) findViewById(R.id.csc4510);
                            a.setVisibility(View.VISIBLE);
                            TextView b = (TextView) findViewById(R.id.csc4610);
                            b.setVisibility(View.VISIBLE);
                        } else if ((selectedItems.toString().contains("CSC 4620 : Numerical Analysis II : TR 1:30-2:45")) && (selectedItems.toString().contains("CSC 4370 : Web Programming : F 12:00-1:15 (FULL) WaitList Enabled"))) {
                            setContentView(R.layout.activity_main4);
                            TextView a = (TextView) findViewById(R.id.csc4620);
                            a.setVisibility(View.VISIBLE);
                            TextView b = (TextView) findViewById(R.id.csc4370);
                            b.setVisibility(View.VISIBLE);
                        } else if (selectedItems.toString().contains("CSC 4620 : Numerical Analysis II : TR 1:30-2:45")) {
                            setContentView(R.layout.activity_main4);
                            TextView a = (TextView) findViewById(R.id.csc4620);
                            a.setVisibility(View.VISIBLE);
                        } else if (selectedItems.toString().contains("CSC 4610 : Numerical Analysis I : MW 3:00-4:15")) {
                            setContentView(R.layout.activity_main4);
                            TextView a = (TextView) findViewById(R.id.csc4610);
                            a.setVisibility(View.VISIBLE);
                        } else if (selectedItems.toString().contains("CSC 4510 : Automata : TR 1:00-2:15")) {
                            setContentView(R.layout.activity_main4);
                            TextView a = (TextView) findViewById(R.id.csc4510);
                            a.setVisibility(View.VISIBLE);
                        } else if (selectedItems.toString().contains("CSC 4340 : Introduction to Compilers : MW 1:00-2:15")) {
                            setContentView(R.layout.activity_main4);
                            TextView a = (TextView) findViewById(R.id.csc4340);
                            a.setVisibility(View.VISIBLE);
                        } else if (selectedItems.toString().contains("CSC 4370 : Web Programming : F 12:00-1:15 (FULL) WaitList Enabled")) {
                            setContentView(R.layout.activity_main4);
                            TextView a = (TextView) findViewById(R.id.csc4370);
                            a.setVisibility(View.VISIBLE);
                        }
                    }
                });

    }



    //"Add Classes" button which will output in a toast the classes selected + if pressed again, will send you to Main4Activity
    //Main4activity is the courses page where a student can view your classes
    public void showSelectedItems(View view) {
        String classes = "";
        final String data1 = "this is data 1";
        final String data2 = "this is data 2";
        for (String item : selectedItems) {
            classes += "-" + item + "\n";
        }
        final String class1 = classes;
        Button concen2 = (Button) findViewById(R.id.bt);
        concen2.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(v.getContext(), Main4Activity.class);
                        myIntent.putExtra("cls", class1);
                        myIntent.putExtra("firstdata", data1);
                        myIntent.putExtra("seconddata", data2);
                        startActivity(myIntent);
                    }
                }
        );
        Toast.makeText(this, "You have Added your classes: \n" + classes, Toast.LENGTH_LONG).show();
         if ((selectedItems.toString().contains("CSC 4620 : Numerical Analysis II : TR 1:30-2:45")) && (selectedItems.toString().contains("CSC 4610 : Numerical Analysis I : MW 3:00-4:15")) && (selectedItems.toString().contains("CSC 4340 : Introduction to Compilers : MW 1:00-2:15"))) {
            setContentView(R.layout.activity_week_view);
            Button bwv = (Button) findViewById(R.id.buttonWeekView);
            Button bwv2 = (Button) findViewById(R.id.buttonWeekView2);
            Button m = (Button) findViewById(R.id.m1215);
            Button m2 = (Button) findViewById(R.id.m12152);
            Button mw = (Button) findViewById(R.id.m3415);
            Button mw2 = (Button) findViewById(R.id.m34152);
            bwv.setVisibility(View.VISIBLE);
            bwv2.setVisibility(View.VISIBLE);
            mw.setVisibility(View.VISIBLE);
            mw2.setVisibility(View.VISIBLE);
            m.setVisibility(View.VISIBLE);
            m2.setVisibility(View.VISIBLE);
        } else if ((selectedItems.toString().contains("CSC 4510 : Automata : TR 1:00-2:15")) && (selectedItems.toString().contains("CSC 4610 : Numerical Analysis I : MW 3:00-4:15")) && (selectedItems.toString().contains("CSC 4340 : Introduction to Compilers : MW 1:00-2:15"))) {
             setContentView(R.layout.activity_week_view);
             Button m = (Button) findViewById(R.id.m1215);
             Button m2 = (Button) findViewById(R.id.m12152);
             Button mw = (Button) findViewById(R.id.m3415);
             Button mw2 = (Button) findViewById(R.id.m34152);
             Button t = (Button) findViewById(R.id.t1215);
             Button t2 = (Button) findViewById(R.id.t12152);
             t.setVisibility(View.VISIBLE);
             t2.setVisibility(View.VISIBLE);
             mw.setVisibility(View.VISIBLE);
             mw2.setVisibility(View.VISIBLE);
             m.setVisibility(View.VISIBLE);
             m2.setVisibility(View.VISIBLE);
        }
         else if ((selectedItems.toString().contains("CSC 4620 : Numerical Analysis II : TR 1:30-2:45")) && (selectedItems.toString().contains("CSC 4610 : Numerical Analysis I : MW 3:00-4:15")) && (selectedItems.toString().contains("CSC 4370 : Web Programming : F 12:00-1:15 (FULL) WaitList Enabled"))) {
             setContentView(R.layout.activity_week_view);
             Button bwv = (Button) findViewById(R.id.buttonWeekView);
             Button bwv2 = (Button) findViewById(R.id.buttonWeekView2);
             bwv.setVisibility(View.VISIBLE);
             bwv2.setVisibility(View.VISIBLE);
             Button mw = (Button) findViewById(R.id.m3415);
             Button mw2 = (Button) findViewById(R.id.m34152);
             mw.setVisibility(View.VISIBLE);
             mw2.setVisibility(View.VISIBLE);
             Button m = (Button) findViewById(R.id.f1215);
             m.setVisibility(View.VISIBLE);
         } else if ((selectedItems.toString().contains("CSC 4620 : Numerical Analysis II : TR 1:30-2:45")) && (selectedItems.toString().contains("CSC 4610 : Numerical Analysis I : MW 3:00-4:15"))) {
            setContentView(R.layout.activity_week_view);
            Button bwv = (Button) findViewById(R.id.buttonWeekView);
            Button bwv2 = (Button) findViewById(R.id.buttonWeekView2);
            bwv.setVisibility(View.VISIBLE);
            bwv2.setVisibility(View.VISIBLE);
            Button mw = (Button) findViewById(R.id.m3415);
            Button mw2 = (Button) findViewById(R.id.m34152);
            mw.setVisibility(View.VISIBLE);
            mw2.setVisibility(View.VISIBLE);
        } else if ((selectedItems.toString().contains("CSC 4510 : Automata : TR 1:00-2:15")) && (selectedItems.toString().contains("CSC 4610 : Numerical Analysis I : MW 3:00-4:15"))) {
             setContentView(R.layout.activity_week_view);
             Button t = (Button) findViewById(R.id.t1215);
             Button t2 = (Button) findViewById(R.id.t12152);
             t.setVisibility(View.VISIBLE);
             t2.setVisibility(View.VISIBLE);
             Button mw = (Button) findViewById(R.id.m3415);
             Button mw2 = (Button) findViewById(R.id.m34152);
             mw.setVisibility(View.VISIBLE);
             mw2.setVisibility(View.VISIBLE);
         } else if ((selectedItems.toString().contains("CSC 4620 : Numerical Analysis II : TR 1:30-2:45")) && (selectedItems.toString().contains("CSC 4370 : Web Programming : F 12:00-1:15 (FULL) WaitList Enabled"))) {
             setContentView(R.layout.activity_week_view);
             Button bwv = (Button) findViewById(R.id.buttonWeekView);
             Button bwv2 = (Button) findViewById(R.id.buttonWeekView2);
             bwv.setVisibility(View.VISIBLE);
             bwv2.setVisibility(View.VISIBLE);
             Button m = (Button) findViewById(R.id.f1215);
             m.setVisibility(View.VISIBLE);
        } else if (selectedItems.toString().contains("CSC 4620 : Numerical Analysis II : TR 1:30-2:45")) {
            setContentView(R.layout.activity_week_view);
            Button bwv = (Button) findViewById(R.id.buttonWeekView);
            Button bwv2 = (Button) findViewById(R.id.buttonWeekView2);
            bwv.setVisibility(View.VISIBLE);
            bwv2.setVisibility(View.VISIBLE);
        } else if (selectedItems.toString().contains("CSC 4610 : Numerical Analysis I : MW 3:00-4:15")) {
            setContentView(R.layout.activity_week_view);
            Button mw = (Button) findViewById(R.id.m3415);
            Button mw2 = (Button) findViewById(R.id.m34152);
            mw.setVisibility(View.VISIBLE);
            mw2.setVisibility(View.VISIBLE);
        } else if (selectedItems.toString().contains("CSC 4510 : Automata : TR 1:00-2:15")) {
            setContentView(R.layout.activity_week_view);
            Button t = (Button) findViewById(R.id.t1215);
            Button t2 = (Button) findViewById(R.id.t12152);
            t.setVisibility(View.VISIBLE);
            t2.setVisibility(View.VISIBLE);
        } else if (selectedItems.toString().contains("CSC 4340 : Introduction to Compilers : MW 1:00-2:15")) {
            setContentView(R.layout.activity_week_view);
            Button m = (Button) findViewById(R.id.m1215);
            Button m2 = (Button) findViewById(R.id.m12152);
            m.setVisibility(View.VISIBLE);
            m2.setVisibility(View.VISIBLE);
        } else if (selectedItems.toString().contains("CSC 4370 : Web Programming : F 12:00-1:15 (FULL) WaitList Enabled")) {
             setContentView(R.layout.activity_week_view);
             Button m = (Button) findViewById(R.id.f1215);
             m.setVisibility(View.VISIBLE);

         }
    }
}