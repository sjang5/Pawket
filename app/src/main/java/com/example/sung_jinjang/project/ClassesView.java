package com.example.sung_jinjang.project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

//Hardware Systems Concentration
public class ClassesView extends AppCompatActivity {

    ArrayList<String> selectedItems=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes_view);

        final ListView ch1 = (ListView) findViewById(R.id.listview_classes);
        ch1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] classes = {
                "CSC 4110 : Introduction to Embedded Systems Laboratory : MW 1:00-2:15", //index 0
                "CSC 4120 : Introduction to Robotics : TR 1:00-2:15",                    //index 1
                "CSC 4220 : Computer Networks : F 3:00-4:15",                            //index 2
                "CSC 4230 : VLSI Design : F 12:00-1:45",                                 //index 3
                "CSC 4270 : Introduction to Digital Signal Processing: MW 3:00-4:15",    //index 4
                "CSC 4630 : Introduction to Matlab Programming : TR 12:00-1:15"          //index 5
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
                //if both classes are selected display toast message "Time Conflict"
                if ((selectedItems.toString().contains("CSC 4630 : Introduction to Matlab Programming : TR 12:00-1:15") && selectedItems.toString().contains("CSC 4120 : Introduction to Robotics : TR 1:00-2:15"))==true) {
                    Toast.makeText(getApplicationContext()  ,"Time conflict",Toast.LENGTH_LONG).show();
                }
                //If this class is selected, disable Index 5 ~ Introductino to Matlab Programming
                if(selectedItems.toString().contains("CSC 4120 : Introduction to Robotics : TR 1:00-2:15")){
                    ch1.getChildAt(5).setEnabled(false);
                } else {
                    ch1.getChildAt(5).setEnabled(true);
                }
                //IF this class is selected, disable Index 1 ~ INtorductino to Robotics
                if(selectedItems.toString().contains("CSC 4630 : Introduction to Matlab Programming : TR 12:00-1:15")){
                    ch1.getChildAt(1).setEnabled(false);
                } else {
                    ch1.getChildAt(1).setEnabled(true);
                }

            }
        });

       //"Back" button intent to return to MajorConcentratino Activity
        Button concen = (Button) findViewById(R.id.button10);
        concen.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent myIntent = new Intent(v.getContext(), MajorConcentration.class);
                        startActivity(myIntent);
                    }
                }
        );
    }

    //"Add Classes" button which will output in a toast the classes selected + if pressed again, will send you to Main4Activity
    //Main4activity is the courses page where a student can view your classes
    public void showSelectedItems(View view){
        String classes="";
        final String data1 = "this is data 1";
        final String data2 = "this is data 2";
        for(String item:selectedItems) {
            classes+="-"+item+"\n";
        }
        final String class1 = classes;
        Button concen2 = (Button)findViewById(R.id.bt);
        concen2.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        Intent myIntent = new Intent(v.getContext(), Main4Activity.class);
                        myIntent.putExtra("cls",class1);
                        myIntent.putExtra("firstdata", data1);
                        myIntent.putExtra("seconddata", data2);
                        startActivity(myIntent);
                    }
                }
        );
        Toast.makeText(this,"You have Added your classes: \n"+classes,Toast.LENGTH_LONG).show();
    }

}

