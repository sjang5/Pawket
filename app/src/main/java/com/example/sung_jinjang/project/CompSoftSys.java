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

//Computer Software Concentration
public class CompSoftSys extends AppCompatActivity{

    ArrayList<String> selectedItems=new ArrayList<>();
    public static String classes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comp_soft_sys);

        final ListView ch1 = (ListView)findViewById(R.id.listview_classes);
        ch1.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] classes={
                "CSC 4110 : Introduction to Embedded Systems Laboratory : MW 1:00-2:15",  //index 0
                "CSC 4310 : Parallel and Distributed Computing : TR 3:00-4:15",           //index 1
                "CSC 4320 : Operating Systems : MW 3:00-4:15",                            //index 2
                "CSC 4340 : Introduction to Compilers : TR 1:30-2:45",                    //index 3
                "CSC 4360 : Network-Oriented Software Development : F 3:30-4:45",         //index 4
                "CSC 4370 : Web Programming : TR 12:00-1:15",                             //index 5
                "CSC 4380 : Windows Systems Programming : MW 12:00-1:15",                 //index 6
                "CSC 4630 : Mobile Application Development : F 2:30-3:45"                 //index 7

        };

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, R.layout.rowlayout,R.id.txt_lan,classes);
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
                                            //toast message will display "Time conflict" if these two courses are selected
                                           if ((selectedItems.toString().contains("CSC 4630 : Mobile Application Development : F 2:30-3:45") && selectedItems.toString().contains("CSC 4360 : Network-Oriented Software Development : F 3:30-4:45"))==true) {
                                               Toast.makeText(getApplicationContext()  ,"Time conflict",Toast.LENGTH_LONG).show();
                                           }
                                           //toast message will display "Time conflict" if these two courses are selected
                                           if ((selectedItems.toString().contains("CSC 4380 : Windows Systems Programming : MW 12:00-1:15") && selectedItems.toString().contains("CSC 4110 : Introduction to Embedded Systems Laboratory : MW 1:00-2:15"))==true) {
                                               Toast.makeText(getApplicationContext()  ,"Time conflict",Toast.LENGTH_LONG).show();
                                           }
                                           if (selectedItems.toString().contains("CSC 4630 : Mobile Application Development : F 2:30-3:45")){
                                               ch1.getChildAt(4).setEnabled(false);
                                           } else {
                                               ch1.getChildAt(4).setEnabled(true);
                                           }
                                           if (selectedItems.toString().contains("CSC 4360 : Network-Oriented Software Development : F 3:30-4:45")){
                                               ch1.getChildAt(7).setEnabled(false);
                                           } else {
                                               ch1.getChildAt(7).setEnabled(true);
                                           }
                                           if (selectedItems.toString().contains("CSC 4380 : Windows Systems Programming : MW 12:00-1:15")){
                                               ch1.getChildAt(0).setEnabled(false);
                                           } else {
                                               ch1.getChildAt(0).setEnabled(true);
                                           }
                                           if (selectedItems.toString().contains("CSC 4110 : Introduction to Embedded Systems Laboratory : MW 1:00-2:15")){
                                               ch1.getChildAt(6).setEnabled(false);
                                     //          wk.showCourse();
                                           } else {
                                               ch1.getChildAt(6).setEnabled(true);

                                           }
                                       }
                                   });

        //Back button intent to go back to the MajorConcentration page
        Button concen = (Button)findViewById(R.id.button10);

        concen.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        Intent myIntent = new Intent(v.getContext(), MajorConcentration.class);
                        startActivity(myIntent);
                    }
                }
        );
    }

    //"Add Classes" button which will output in a toast the classes selected + if pressed again, will send you to Main4Activity
    //Main4activity is the courses page where a student can view your classes
    public void showSelectedItems(View view){
        this.classes="";
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
