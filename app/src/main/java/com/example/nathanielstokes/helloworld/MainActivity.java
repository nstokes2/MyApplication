package com.example.nathanielstokes.helloworld;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;
import java.util.ArrayList;
import java.io.FileOutputStream;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends Activity {
    //not currently being used but static so that other activities and classes can access
    //via MainActivity.exerciseNames
    public static ArrayList<String> exerciseNames;
    public static ArrayList<String> weights;

    public  static ArrayList<String> reps;
    public  ArrayList<String> formattedString;
    ArrayAdapter<String> adapter;
    //For use with code we deleted
    SimpleCursorAdapter mAdapter;
    public int addExerciseReqCode = 0;
    public int addRunningReqCode = 0;
    public int addPushUpsReqCode = 0;
    public RelativeLayout mainPageLayout;
    public RelativeLayout customLayout;
    public RelativeLayout.LayoutParams params;
    ListView thisScroll;
    public boolean refresh=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        exerciseNames = new ArrayList();
        weights = new ArrayList();
        reps = new ArrayList();
        formattedString =new ArrayList();

        formattedString.add("hello");
        adapter = new ArrayAdapter<String>(this, R.layout.textview, formattedString);
        LayoutInflater mainInflater = this.getLayoutInflater();

        View mainView = mainInflater.inflate(R.layout.activity_main, null);


        //RelativeLayout mainSource =(RelativeLayout)findViewById(R.id.mainSource);
        thisScroll = (ListView)findViewById(R.id.workoutList);
        thisScroll.setAdapter(adapter);
      //  mAdapter=new SimpleCursorAdapter(this, )

        //mainPageLayout = (RelativeLayout)findViewById(R.id.workoutPage);
        //   customLayout =new RelativeLayout(this);
        //   customLayout.addView(mainPageLayout);

        for (int i = 0; i < exerciseNames.size(); i++) {
            if (i == 0) {
                //       params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                // params.addRule(RelativeLayout.BELOW, R.id.MainPageTitle);

            }
            if (i > 0) {
                //       params.addRule(RelativeLayout.BELOW, i - 1);
                //     customLayout.setLayoutParams(params);

                //  customLayout.addView(R.id.Cardio);

            }

        }
    }

    public void addRunningActivity(View view){

        Intent intent =new Intent(this, addRunningActivity.class);

        startActivityForResult(intent, addRunningReqCode);




    }

    public File getAlbumStorageDir(String albumName) {
        // Get the directory for the user's public pictures directory.
       // File file = new File(Environment.getExternalStoragePublicDirectory(
            //    Environment.DIRECTORY_PICTURES), albumName);

        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), albumName);
        if (!file.mkdirs()) {
            Log.e("Make dir error", "Directory not created");

        }
        return file;
    }

    public void saveFile(View view){
      //  Dialog myDialog = new Dialog(this);



        String albumName="Nate's Fitness App";

        File file = getAlbumStorageDir(albumName);

        FileOutputStream outputStream;

        try {
            outputStream = new FileOutputStream(file + "/helloworld.txt");
            for(int i =0; i<formattedString.size(); i++)
            outputStream.write(formattedString.get(i).getBytes());
            outputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }

       /* String filename = "myfile.txt";
        String string = "Hello world!";
        FileOutputStream outputStream;

        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(string.getBytes());
            outputStream.close();
           // myDialog.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
*/


    }


    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }


    public void addPushUps(View view)
    {


        Intent intent = new Intent(this, addPushUpsActivity.class);
        startActivityForResult(intent, addPushUpsReqCode);

    }
    //Has to be the same name as the onclick variable in the button
    public void addExercise(View view) {

        //this is just a class that allows you to call a different class
        Intent intent = new Intent(this, addExerciseActivity.class);
        String[] exNamesArray = exerciseNames.toArray(new String[exerciseNames.size()]);
        String[] wtArray = weights.toArray(new String[weights.size()]);
        String[] repsArray = reps.toArray(new String[reps.size()]);

        intent.putExtra ("exerciseNames", exerciseNames);
        intent.putExtra("weights", weights);
        intent.putExtra("reps", reps);
        //intent.putExtra("exerciseNames", exerciseNames.toArray());
        //intent.putExtra("weights", weights.toArray());
        //intent.putExtra("reps", reps.toArray());
        //this result is called there are other ways but this calls the other screen
        startActivityForResult(intent, addExerciseReqCode);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 0) {

            if(resultCode == 0) {

//add 4th to data that signifies if it is addreps or add exercise
                if(data.hasExtra("weights") && data.hasExtra("reps") && data.hasExtra("exerciseNames")) {
                    weights = data.getStringArrayListExtra("weights");
                    reps = data.getStringArrayListExtra("reps");
                    exerciseNames = data.getStringArrayListExtra("exerciseNames");
                    Intent intent = new Intent(this, addExerciseActivity.class);

                    intent.putExtra("exerciseNames", exerciseNames);
                    intent.putExtra("weights", weights);
                    intent.putExtra("reps", reps);
                    // exerciseNames.add("bOO");
                    // exerciseNames.add("BLE");

                  //  startActivityForResult(intent, addExerciseReqCode);
                 //    thisScroll.setAdapter(adapter);
                //    adapter.notifyDataSetChanged();
                }
                refresh = true;
            }
            if(resultCode ==1)
            {
                weights = data.getStringArrayListExtra("weights");
                reps = data.getStringArrayListExtra("reps");
                exerciseNames = data.getStringArrayListExtra("exerciseNames");
                String formatted = exerciseNames.get(0);
                for(int i = 0; i<reps.size(); i++)
                    formatted += " " + weights.get(i) + " " + reps.get(i);

                formattedString.add(formatted);
                Intent intent = new Intent(this, addExerciseActivity.class);

                exerciseNames.clear();
                reps.clear();
                weights.clear();
                // exerciseNames.add("bOO");
                // exerciseNames.add("BLE");

                // startActivityForResult(intent, addExerciseReqCode);
              thisScroll.setAdapter(adapter);
                adapter.notifyDataSetChanged();
                refresh = true;


            }
        }



    }

    @Override
    protected void onResume() {

        super.onResume();
        //   ViewGroup viewGroup = (ViewGroup) findViewById(R.id.workoutPage);

        RelativeLayout viewGroup = (RelativeLayout) findViewById(R.id.workoutPage);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        //    viewGroup.setLayoutParams(params);
        //  params.get

        //    View workoutView = inflater.inflate( , R.layout.main_source_layout);
        //View cardio = workoutView.findViewById(R.id.workoutPage);
        //viewGroup.removeAllViews()
        //  View mainSourceView = inflater.inflate(R.layout.main_source_layout, null, false);
        //  viewGroup.removeAllViews();
        LayoutInflater mainInflater = this.getLayoutInflater();
        View mainView = mainInflater.inflate(R.layout.activity_main, null);
        LayoutInflater inflater = this.getLayoutInflater();
        View workoutView = inflater.inflate(R.layout.main_source_layout, null);
        workoutView.findViewById(R.id.Cardio);

        //RelativeLayout mainSource =(RelativeLayout)findViewById(R.id.mainSource);

        //  viewGroup.addView(cardio, null);
        HorizontalScrollView titleLayout = (HorizontalScrollView) workoutView.findViewById(R.id.ExerciseName);
        HorizontalScrollView thisLayout = (HorizontalScrollView) workoutView.findViewById(R.id.Cardio);
       //  thisScroll = (ListView) mainView.findViewById(R.id.workoutList);


       // mainView.addView(thisScroll);
        if(refresh) {
           adapter = new ArrayAdapter<String>(this, R.layout.textview, formattedString);
            thisScroll.setAdapter(adapter);

            adapter.notifyDataSetChanged();
refresh = false;
        }
        // viewGroup.removeAllViews();
        for (int i = 0; i < exerciseNames.size(); i++) {

            // View cardio = findViewById(R.id.workout/*Page);
            if (i == 0) {


                int resTitleId = getResources().getIdentifier(Integer.toString(i), null, getPackageName());
                titleLayout.setId(resTitleId);
                ((ViewGroup) titleLayout.getParent()).removeView(titleLayout);
                EditText exerciseName = (EditText) titleLayout.findViewById(R.id.editText3);
                exerciseName.setText(exerciseNames.get(i));
                params.addRule(RelativeLayout.BELOW, R.id.MainPageTitle);
                params.addRule(Gravity.CENTER_HORIZONTAL);
                titleLayout.setLayoutParams(params);

                ((ViewGroup) thisScroll.getParent()).removeView(thisScroll);

                //  thisScroll.(titleLayout);

                //viewGroup.addView(titleLayout);


                params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);


                //  params.addRule(RelativeLayout.CENTER_HORIZONTAL, i);
                params.addRule(RelativeLayout.BELOW, 0);
                //params.addRule(HorizontalScrollView.LayoutParams.);
                params.setMargins(0, 125, 0, 0);
                thisLayout.setLayoutParams(params);
                // getResources().
                // or getBaseContext(), or getApplicationContext()
                int resId = getResources().getIdentifier(Integer.toString(i + 1), null, getPackageName());
                thisLayout.setId(resId);
                ((ViewGroup) thisLayout.getParent()).removeView(thisLayout);
                // View nct = View.inflate(this, thisLayout, viewGroup);

                //   nct.

                // thisScroll.addView(thisLayout);


                //viewGroup.addView(thisLayout);
             //   adapter.notifyDataSetChanged();
                ;

                viewGroup.addView(thisScroll);
            } /*else {
                //      HorizontalScrollView thisLayout = (HorizontalScrollView)workoutView.findViewById(R.id.Cardio);

                params.addRule(RelativeLayout.BELOW, i * 2);
                thisLayout.setLayoutParams(params);
                // getResources().
                // or getBaseContext(), or getApplicationContext()
                int resId = getResources().getIdentifier(Integer.toString(i * 2), null, getPackageName());
                thisLayout.setId(resId);
                ((ViewGroup) thisLayout.getParent()).removeView(thisLayout);
                // View nct = View.inflate(this, thisLayout, viewGroup);

                //   nct.

                viewGroup.addView(thisLayout);


            }*/
        }
    }
}
           // cardio.setTag(i);
           // cardio.setId(i);
            //mainSourceView
    //        cardio.setId(i);
      //      viewGroup.removeView(cardio);
        //    if(i==0)
          /*//  viewGroup.addView(cardio, null);


     }
      //  viewGroup.removeAllViews();
    }
  //  protected void onActvitiy(int requestCode, int resultCode, Intent data){

    //    if(requestCode == addExerciseReqCode){

      //      if(resultCode == RESULT_OK){

        //        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.workoutPage);
          //      viewGroup.removeAllViews();

            //    for(int i = 0; i<exerciseNames.size(); i++)
              //  {
                //    viewGroup.addView(findViewById(R.id.Cardio), null);



//                }


  //          }

    //    }



   // }
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.activity_main, menu);
//        return true;
//    }
}*/
