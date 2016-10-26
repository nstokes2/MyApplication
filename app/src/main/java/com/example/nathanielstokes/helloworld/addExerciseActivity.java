package com.example.nathanielstokes.helloworld;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow.LayoutParams;
import android.widget.TableRow;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by Nathaniel Stokes on 8/5/2016.
 */
public class addExerciseActivity extends Activity {

    public  ArrayList<String> exerciseNames;
    public ArrayList<String> weights;
    public  ArrayList<String> reps;
    public int addRepsReqCode=0;
    LinearLayout nonCardioLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.non_cardio);
        Intent intent = getIntent();

/*        String[] exerciseNamesArray = intent.getExtras().getStringArray("exerciseNames");

        if(intent.getExtras().getStringArray("weights") != null)
         weights = new ArrayList<>(Arrays.asList(intent.getExtras().getStringArray("weights")));
        else weights = new ArrayList<String>();
        if(intent.getExtras().getStringArray("reps") != null)
        reps = new ArrayList<>(Arrays.asList(intent.getExtras().getStringArray("reps")));
        else
        reps = new ArrayList<String>();
       // exerciseNames= exerciseNamesArray.
        if(intent.getExtras().getStringArray("exerciseNames") != null)
            exerciseNames = Arrays.asList(exerciseNamesArray);
        else
        exerciseNames = new ArrayList<String>();
        */
            //   ViewGroup viewGroup = (ViewGroup) findViewById(R.id.workoutPage);


           LayoutInflater mainInflater = this.getLayoutInflater();
        LayoutInflater inflater = this.getLayoutInflater();
        ViewGroup addExerciseView = (ViewGroup) inflater.inflate(R.layout.non_cardio, null);
        addExerciseView.findViewById(R.id.Cardio);
        LinearLayout nonCardioLayout = (LinearLayout)addExerciseView.findViewById(R.id.non_cardio_Layout);


       // addExerciseView.removeAllViews();
       // nonCardioLayout.removeAllViews();
         /*
TableRow statsTable;
        TableRow statsLayoutRow;
        TableLayout statsLayout;
        TableLayout masterTable;
        EditText weightAmount;
        EditText amountOfReps;
            // viewGroup.removeAllViews();
      // statsTable.removeAllViews();
            for (int i = 0; i < weights.size(); i++) {

                statsTable = new TableRow(this);
                statsLayout = new TableLayout(this);
                masterTable = new TableLayout(this);
                weightAmount = new EditText(this);
                amountOfReps = new EditText(this);
                statsLayoutRow = new TableRow(this);
                if (i == 0) {
                    // View cardio = findViewById(R.id.workoutPage);

                    masterTable = (TableLayout) nonCardioLayout.findViewById(R.id.master_Table);
                    statsTable = new TableRow(this);
                    statsTable = (TableRow) masterTable.findViewById(R.id.EnterStats);

                    statsTable = (TableRow) masterTable.findViewById(R.id.EnterStats);

                    statsLayout = (TableLayout) statsTable.findViewById(R.id.statsLayout);


                    int resTitleId = getResources().getIdentifier(Integer.toString(i), null, getPackageName());
                    statsTable.setId(resTitleId);
                    statsLayoutRow = (TableRow) statsTable.findViewById(R.id.statsLayoutRow);


                    weightAmount = (EditText) statsLayoutRow.findViewById(R.id.enterStatsWeight);
                    amountOfReps = (EditText) statsLayoutRow.findViewById(R.id.enterStatsReps);


                    int weightId = getResources().getIdentifier("weight" + Integer.toString(8000 + i), null, getPackageName());
                    int repsId = getResources().getIdentifier(Integer.toString(9000 + i), null, getPackageName());

                    if (statsTable != null && statsTable.getParent() != null)
                        ((ViewGroup) statsTable.getParent()).removeView(statsTable);
                    if (weightAmount != null && weightAmount.getParent() != null)
                        ((ViewGroup) weightAmount.getParent()).removeView(weightAmount);
                    if (amountOfReps != null && amountOfReps.getParent() != null)
                        ((ViewGroup) amountOfReps.getParent()).removeView(amountOfReps);

                    weightAmount.setId(weightId);
                    amountOfReps.setId(repsId);
                    weightAmount.setText((weights.get(i)));
                    amountOfReps.setText((reps.get(i)));
                    LayoutParams params = new TableRow.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

                    params.weight = 1.0f;
                    weightAmount.setLayoutParams((params));
                    amountOfReps.setLayoutParams((params));
                    statsLayoutRow.addView(weightAmount);
                    statsLayoutRow.addView(amountOfReps);

                    if (statsLayoutRow != null && statsLayoutRow.getParent() != null)
                        ((ViewGroup) statsLayoutRow.getParent()).removeView(statsLayoutRow);
                    if (statsLayout != null && statsLayout.getParent() != null)
                        ((ViewGroup) statsLayout.getParent()).removeView(statsLayout);
                    statsLayout.addView(statsLayoutRow);
                    statsTable.addView(statsLayout);
                    // ((ViewGroup)statsTable.getParent()).removeView(statsTable);
                    if (masterTable != null && masterTable.getParent() != null)
                        ((ViewGroup) masterTable.getParent()).removeView(masterTable);
                    masterTable.addView(statsTable);

                    //    statsLayout.addView(statsTable);

                    // cardio.setTag(i);
                    // cardio.setId(i);
                    //mainSourceView
                    //        cardio.setId(i);
                    //      viewGroup.removeView(cardio);
                    //    if(i==0)
                    //  viewGroup.addView(cardio, null);

                    nonCardioLayout.addView(masterTable);
                   // nonCardioLayout.addView(masterTable);
                  //  nonCardioLayout.removeAllViews();
                }
            }*/
         }
    @Override protected void onResume() {

        super.onResume();
Intent intent = getIntent();
        String[] exerciseNamesArray;

       // if(intent.getExtras().getStringArray("weights") != null)
         //   exerciseNames=new ArrayList<>(Arrays.asList(intent.getExtras().getStringArray("exerciseNames")));
        //if(intent.getExtras().getStringArray("weights") != null)
          //  weights = new ArrayList<>(Arrays.asList(intent.getExtras().getStringArray("weights")));
        //else weights = new ArrayList<String>();
        //if(intent.getExtras().getStringArray("reps") != null)
          //  reps = new ArrayList<>(Arrays.asList(intent.getExtras().getStringArray("reps")));
        //else
          //  reps = new ArrayList<String>();

        if(intent.getExtras().getStringArrayList("weights")!=null)
            weights = intent.getExtras().getStringArrayList("weights");
        if(intent.getExtras().getStringArrayList("reps")!=null)
            reps = intent.getExtras().getStringArrayList("reps");
        if(intent.getExtras().getStringArrayList("exerciseNames")!=null)
            exerciseNames = intent.getExtras().getStringArrayList("exerciseNames");
        // exerciseNames= exerciseNamesArray.

        //   ViewGroup viewGroup = (ViewGroup) findViewById(R.id.workoutPage);





         nonCardioLayout2 = (LinearLayout)findViewById(R.id.non_cardio_Layout);

        TableLayout masterTable2 = (TableLayout)findViewById(R.id.master_Table);

        ScrollView scrollView = (ScrollView)findViewById(R.id.aScroll);

        LinearLayout scrollLayout= (LinearLayout)findViewById(R.id.exerciseScrollLayout);
        nonCardioLayout2.removeAllViews();
      //  ((ViewGroup)masterTable2.getParent()).removeView(masterTable2);
        //nonCardioLayout2.addView(masterTable2);

        // viewGroup.removeAllViews();
        // statsTable.removeAllViews();
        for (int i = -1; i < weights.size(); i++) {


            if(i==-1)
            {

                TableRow statsTable;
                TableRow statsLayoutRow;
                TableRow nameTitleRow;
                TableRow enterNameTitleRow;
                TableRow enterStatsRow;
                LinearLayout enterStatsLayout;
                TableRow weightRepsRow;
                TableRow repsButtonRow;
                TableRow addExerciseButtonRow;
                TableLayout statsLayout;
                TableLayout masterTable;
                EditText exerciseNameEntry;
                EditText weightAmount;
                EditText amountOfReps;
                // View cardio = findViewById(R.id.workoutPage);
                LayoutInflater inflater = this.getLayoutInflater();
                View addExerciseView = inflater.inflate(R.layout.non_cardio, null);
                addExerciseView.findViewById(R.id.Cardio);
                LinearLayout nonCardioLayout = (LinearLayout)addExerciseView.findViewById(R.id.non_cardio_Layout);
                LayoutInflater vi = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View ncL = vi.inflate(R.layout.non_cardio, null);
                LinearLayout scroll2 = (LinearLayout)ncL.findViewById(R.id.exerciseScrollLayout);
                masterTable =  (TableLayout) scroll2.findViewById(R.id.master_Table);
//                nonCardioLayout2.addView(masterTable2);
                statsTable = new TableRow(this);
                //  statsTable = (TableRow) masterTable.findViewById(R.id.EnterStatsRow);

                // statsTable = (TableRow) masterTable.findViewById(R.id.EnterStats);

                statsLayoutRow = (TableRow) masterTable.findViewById(R.id.statsLayoutRow);
                statsLayout = (TableLayout) statsLayoutRow.findViewById(R.id.statsLayout);
                nameTitleRow = (TableRow) masterTable.findViewById(R.id.nameTitleRow);
                enterNameTitleRow= (TableRow) masterTable.findViewById(R.id.enterNameTitleRow);

                exerciseNameEntry = (EditText) enterNameTitleRow.findViewById(R.id.exerciseName);

                if(exerciseNames.size()>0)
                exerciseNameEntry.setText(exerciseNames.get(0).toString());
                //enterStatsRow =  (TableRow) statsLayout.findViewById(R.id.enterStatsRow);
                enterStatsLayout = (LinearLayout) statsLayoutRow.findViewById(R.id.enterStatsLayout);
                weightRepsRow = (TableRow) statsLayout.findViewById(R.id.weightRepsRow);
                repsButtonRow =  (TableRow) masterTable.findViewById(R.id.repsButtonRow);
                addExerciseButtonRow = (TableRow) masterTable.findViewById(R.id.addExerciseButtonRow);



                int resTitleId = getResources().getIdentifier(Integer.toString(i), null, getPackageName());
                statsTable.setId(resTitleId);
                // statsLayoutRow = (TableRow) statsTable.findViewById(R.id.statsLayoutRow);


                weightAmount = (EditText) enterStatsLayout.findViewById(R.id.enterStatsWeight);
                amountOfReps = (EditText) enterStatsLayout.findViewById(R.id.enterStatsReps);


                int weightId = getResources().getIdentifier("weight" + Integer.toString(8000 + i), null, getPackageName());
                int repsId = getResources().getIdentifier(Integer.toString(9000 + i), null, getPackageName());

                masterTable.removeAllViews();
                masterTable.addView(nameTitleRow);
                masterTable.addView(enterNameTitleRow);


                ((ViewGroup) weightRepsRow.getParent()).removeView(weightRepsRow);
                masterTable.addView(weightRepsRow);
                ((ViewGroup) enterStatsLayout.getParent()).removeView(enterStatsLayout);
                masterTable.addView(enterStatsLayout);
                //  ((ViewGroup) repsButtonRow.getParent()).removeView(repsButtonRow);

               /* if (statsTable != null && statsTable.getParent() != null)
                    ((ViewGroup) statsTable.getParent()).removeView(statsTable);
                    */
                if (weightAmount != null && weightAmount.getParent() != null)
                    ((ViewGroup) weightAmount.getParent()).removeView(weightAmount);
                if (amountOfReps != null && amountOfReps.getParent() != null)
                    ((ViewGroup) amountOfReps.getParent()).removeView(amountOfReps);

                //weightAmount.setId(weightId);
                //amountOfReps.setId(repsId);
//                weightAmount.setText((weights.get(i)));
                //              amountOfReps.setText((reps.get(i)));
                LayoutParams params = new TableRow.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

                params.weight = 1.0f;
                weightAmount.setLayoutParams((params));
                amountOfReps.setLayoutParams((params));


                if (statsLayoutRow != null && statsLayoutRow.getParent() != null)
                    ((ViewGroup) statsLayoutRow.getParent()).removeView(statsLayoutRow);
                if (statsLayout != null && statsLayout.getParent() != null)
                    ((ViewGroup) statsLayout.getParent()).removeView(statsLayout);
                if (enterStatsLayout != null && enterStatsLayout.getParent() != null)
                    ((ViewGroup) enterStatsLayout.getParent()).removeView(enterStatsLayout);

                if (weightRepsRow != null && weightRepsRow.getParent() != null)
                    ((ViewGroup) weightRepsRow.getParent()).removeView(weightRepsRow);
                enterStatsLayout.addView(weightAmount);
                enterStatsLayout.addView(amountOfReps);
                // enterStatsLayout.setLayoutParams(params);
                statsLayout.addView(weightRepsRow);
                statsLayout.addView(enterStatsLayout);


                statsLayoutRow.addView(statsLayout);

                masterTable.addView(statsLayoutRow);

                //  LayoutParams params2 = new TableRow.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                // enterStatsLayout.setLayoutParams(params2);
                // statsLayout.addView(enterStatsLayout);
                // enterStatsLayout.setLayoutParams((params2));
//                statsLayout.addView(enterStatsLayout);
                //statsTable.addView(statsLayout);

                if(weights.size()==0)
                {

                    masterTable.addView(repsButtonRow);
                    //  ((ViewGroup) addExerciseButtonRow.getParent()).removeView(addExerciseButtonRow);
                    masterTable.addView(addExerciseButtonRow);
                }


                // statsTable.addView(enterStatsLayout);

                //  masterTable.addView(statsLayout);

                //    statsLayout.addView(statsTable);

                // cardio.setTag(i);
                // cardio.setId(i);
                //mainSourceView
                //        cardio.setId(i);
                //      viewGroup.removeView(cardio);
                //    if(i==0)
                //  viewGroup.addView(cardio, null);

                //   scrollLayout.addView(masterTable);
                // nonCardioLayout.addView(masterTable);
                //  nonCardioLayout.removeAllViews();
                if (masterTable != null && masterTable.getParent() != null)
                    ((ViewGroup) masterTable.getParent()).removeView(masterTable);
                scrollLayout.addView(masterTable);



            }
            else if (i!= -1 && i == weights.size()-1) {
                TableRow statsTable;
                TableRow statsLayoutRow;
                TableRow nameTitleRow;
                TableRow enterNameTitleRow;
                TableRow enterStatsRow;
                LinearLayout enterStatsLayout;
                TableRow weightRepsRow;
                TableRow repsButtonRow;
                TableRow addExerciseButtonRow;
                TableLayout statsLayout;
                TableLayout masterTable;
                EditText weightAmount;
                EditText amountOfReps;
                // View cardio = findViewById(R.id.workoutPage);
                LayoutInflater inflater = this.getLayoutInflater();
                View addExerciseView = inflater.inflate(R.layout.non_cardio, null);
                addExerciseView.findViewById(R.id.Cardio);
                LinearLayout nonCardioLayout = (LinearLayout)addExerciseView.findViewById(R.id.non_cardio_Layout);
                LayoutInflater vi = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View ncL = vi.inflate(R.layout.non_cardio, null);
                LinearLayout scroll2 = (LinearLayout)ncL.findViewById(R.id.exerciseScrollLayout);
                masterTable =  (TableLayout) scroll2.findViewById(R.id.master_Table);
//                nonCardioLayout2.addView(masterTable2);
                statsTable = new TableRow(this);
              //  statsTable = (TableRow) masterTable.findViewById(R.id.EnterStatsRow);

               // statsTable = (TableRow) masterTable.findViewById(R.id.EnterStats);

                statsLayoutRow = (TableRow) masterTable.findViewById(R.id.statsLayoutRow);
                statsLayout = (TableLayout) statsLayoutRow.findViewById(R.id.statsLayout);
                nameTitleRow = (TableRow) masterTable.findViewById(R.id.nameTitleRow);
                enterNameTitleRow= (TableRow) masterTable.findViewById(R.id.enterNameTitleRow);

                //enterStatsRow =  (TableRow) statsLayout.findViewById(R.id.enterStatsRow);
                enterStatsLayout = (LinearLayout) statsLayoutRow.findViewById(R.id.enterStatsLayout);
                weightRepsRow = (TableRow) statsLayout.findViewById(R.id.weightRepsRow);
                repsButtonRow =  (TableRow) masterTable.findViewById(R.id.repsButtonRow);
                addExerciseButtonRow = (TableRow) masterTable.findViewById(R.id.addExerciseButtonRow);



                int resTitleId = getResources().getIdentifier(Integer.toString(i), null, getPackageName());
                statsTable.setId(resTitleId);
               // statsLayoutRow = (TableRow) statsTable.findViewById(R.id.statsLayoutRow);


                weightAmount = (EditText) enterStatsLayout.findViewById(R.id.enterStatsWeight);
                amountOfReps = (EditText) enterStatsLayout.findViewById(R.id.enterStatsReps);



                weightAmount.setText(weights.get(i));
                amountOfReps.setText(reps.get(i));
                int weightId = getResources().getIdentifier("weight" + Integer.toString(8000 + i), null, getPackageName());
                int repsId = getResources().getIdentifier(Integer.toString(9000 + i), null, getPackageName());

                masterTable.removeAllViews();
              //  masterTable.addView(nameTitleRow);
             //   masterTable.addView(enterNameTitleRow);


                ((ViewGroup) weightRepsRow.getParent()).removeView(weightRepsRow);
                masterTable.addView(weightRepsRow);
                ((ViewGroup) enterStatsLayout.getParent()).removeView(enterStatsLayout);
                masterTable.addView(enterStatsLayout);
              //  ((ViewGroup) repsButtonRow.getParent()).removeView(repsButtonRow);

               /* if (statsTable != null && statsTable.getParent() != null)
                    ((ViewGroup) statsTable.getParent()).removeView(statsTable);
                    */
                if (weightAmount != null && weightAmount.getParent() != null)
                    ((ViewGroup) weightAmount.getParent()).removeView(weightAmount);
                if (amountOfReps != null && amountOfReps.getParent() != null)
                    ((ViewGroup) amountOfReps.getParent()).removeView(amountOfReps);

                //weightAmount.setId(weightId);
                //amountOfReps.setId(repsId);
//                weightAmount.setText((weights.get(i)));
  //              amountOfReps.setText((reps.get(i)));
                LayoutParams params = new TableRow.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

                params.weight = 1.0f;
                weightAmount.setLayoutParams((params));
                amountOfReps.setLayoutParams((params));


                if (statsLayoutRow != null && statsLayoutRow.getParent() != null)
                    ((ViewGroup) statsLayoutRow.getParent()).removeView(statsLayoutRow);
                if (statsLayout != null && statsLayout.getParent() != null)
                    ((ViewGroup) statsLayout.getParent()).removeView(statsLayout);
                if (enterStatsLayout != null && enterStatsLayout.getParent() != null)
                    ((ViewGroup) enterStatsLayout.getParent()).removeView(enterStatsLayout);

                if (weightRepsRow != null && weightRepsRow.getParent() != null)
                    ((ViewGroup) weightRepsRow.getParent()).removeView(weightRepsRow);
            enterStatsLayout.addView(weightAmount);
                enterStatsLayout.addView(amountOfReps);
               // enterStatsLayout.setLayoutParams(params);
                statsLayout.addView(weightRepsRow);
                statsLayout.addView(enterStatsLayout);


                statsLayoutRow.addView(statsLayout);

          masterTable.addView(statsLayoutRow);

               masterTable.addView(repsButtonRow);
                //  ((ViewGroup) addExerciseButtonRow.getParent()).removeView(addExerciseButtonRow);
                masterTable.addView(addExerciseButtonRow);
              //  LayoutParams params2 = new TableRow.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
               // enterStatsLayout.setLayoutParams(params2);
               // statsLayout.addView(enterStatsLayout);
               // enterStatsLayout.setLayoutParams((params2));
//                statsLayout.addView(enterStatsLayout);
                //statsTable.addView(statsLayout);



               // statsTable.addView(enterStatsLayout);

              //  masterTable.addView(statsLayout);

                //    statsLayout.addView(statsTable);

                // cardio.setTag(i);
                // cardio.setId(i);
                //mainSourceView
                //        cardio.setId(i);
                //      viewGroup.removeView(cardio);
                //    if(i==0)
                //  viewGroup.addView(cardio, null);

           //   scrollLayout.addView(masterTable);
                // nonCardioLayout.addView(masterTable);
              //  nonCardioLayout.removeAllViews();
                if (masterTable != null && masterTable.getParent() != null)
                    ((ViewGroup) masterTable.getParent()).removeView(masterTable);
                scrollLayout.addView(masterTable);
            }
//middle
           else if( i < weights.size()-1)

            {
                TableRow statsTable;
                TableRow statsLayoutRow;
                TableRow nameTitleRow;
                TableRow enterNameTitleRow;
                TableRow enterStatsRow;
                LinearLayout enterStatsLayout;
                TableRow weightRepsRow;
                TableRow repsButtonRow;
                TableRow addExerciseButtonRow;
                TableLayout statsLayout;
                TableLayout masterTable;
                EditText weightAmount;
                EditText amountOfReps;
                // View cardio = findViewById(R.id.workoutPage);
                LayoutInflater inflater = this.getLayoutInflater();
                View addExerciseView = inflater.inflate(R.layout.non_cardio, null);
                addExerciseView.findViewById(R.id.Cardio);
                LinearLayout nonCardioLayout = (LinearLayout)addExerciseView.findViewById(R.id.non_cardio_Layout);
                LayoutInflater vi = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View ncL = vi.inflate(R.layout.non_cardio, null);
                LinearLayout scroll2 = (LinearLayout)ncL.findViewById(R.id.exerciseScrollLayout);
                masterTable =  (TableLayout) scroll2.findViewById(R.id.master_Table);
//                nonCardioLayout2.addView(masterTable2);
                statsTable = new TableRow(this);
                //  statsTable = (TableRow) masterTable.findViewById(R.id.EnterStatsRow);

                // statsTable = (TableRow) masterTable.findViewById(R.id.EnterStats);

                statsLayoutRow = (TableRow) masterTable.findViewById(R.id.statsLayoutRow);
                statsLayout = (TableLayout) statsLayoutRow.findViewById(R.id.statsLayout);
                nameTitleRow = (TableRow) masterTable.findViewById(R.id.nameTitleRow);
                enterNameTitleRow= (TableRow) masterTable.findViewById(R.id.enterNameTitleRow);

                //enterStatsRow =  (TableRow) statsLayout.findViewById(R.id.enterStatsRow);
                enterStatsLayout = (LinearLayout) statsLayoutRow.findViewById(R.id.enterStatsLayout);
                weightRepsRow = (TableRow) statsLayout.findViewById(R.id.weightRepsRow);
                repsButtonRow =  (TableRow) masterTable.findViewById(R.id.repsButtonRow);
                addExerciseButtonRow = (TableRow) masterTable.findViewById(R.id.addExerciseButtonRow);



                int resTitleId = getResources().getIdentifier(Integer.toString(i), null, getPackageName());
                statsTable.setId(resTitleId);
                // statsLayoutRow = (TableRow) statsTable.findViewById(R.id.statsLayoutRow);


                weightAmount = (EditText) enterStatsLayout.findViewById(R.id.enterStatsWeight);
                amountOfReps = (EditText) enterStatsLayout.findViewById(R.id.enterStatsReps);


                weightAmount.setText(weights.get(i));
                amountOfReps.setText(reps.get(i));

                int weightId = getResources().getIdentifier("weight" + Integer.toString(8000 + i), null, getPackageName());
                int repsId = getResources().getIdentifier(Integer.toString(9000 + i), null, getPackageName());

                masterTable.removeAllViews();



                ((ViewGroup) weightRepsRow.getParent()).removeView(weightRepsRow);
                masterTable.addView(weightRepsRow);
                ((ViewGroup) enterStatsLayout.getParent()).removeView(enterStatsLayout);
                masterTable.addView(enterStatsLayout);

                if (weightAmount != null && weightAmount.getParent() != null)
                    ((ViewGroup) weightAmount.getParent()).removeView(weightAmount);
                if (amountOfReps != null && amountOfReps.getParent() != null)
                    ((ViewGroup) amountOfReps.getParent()).removeView(amountOfReps);

                LayoutParams params = new TableRow.LayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

                params.weight = 1.0f;
                weightAmount.setLayoutParams((params));
                amountOfReps.setLayoutParams((params));


                if (statsLayoutRow != null && statsLayoutRow.getParent() != null)
                    ((ViewGroup) statsLayoutRow.getParent()).removeView(statsLayoutRow);
                if (statsLayout != null && statsLayout.getParent() != null)
                    ((ViewGroup) statsLayout.getParent()).removeView(statsLayout);
                if (enterStatsLayout != null && enterStatsLayout.getParent() != null)
                    ((ViewGroup) enterStatsLayout.getParent()).removeView(enterStatsLayout);

                if (weightRepsRow != null && weightRepsRow.getParent() != null)
                    ((ViewGroup) weightRepsRow.getParent()).removeView(weightRepsRow);
                enterStatsLayout.addView(weightAmount);
                enterStatsLayout.addView(amountOfReps);
                // enterStatsLayout.setLayoutParams(params);
                statsLayout.addView(weightRepsRow);
                statsLayout.addView(enterStatsLayout);


                statsLayoutRow.addView(statsLayout);

                masterTable.addView(statsLayoutRow);


                if (masterTable != null && masterTable.getParent() != null)
                    ((ViewGroup) masterTable.getParent()).removeView(masterTable);
                scrollLayout.addView(masterTable);




            }
        }



            scrollView.removeAllViews();
    // ((ViewGroup)masterTable.getParent()).removeView(masterTable);

        // ((ViewGroup)statsTable.getParent()).removeView(statsTable);



        TableLayout.LayoutParams tab1Param = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT, 50 );

        TableLayout.LayoutParams tab2Param = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT,TableLayout.LayoutParams.WRAP_CONTENT, 50);
     //   masterTable.setLayoutParams((tab1Param));
      //  masterTable2.setLayoutParams(tab2Param);
        //scrollLayout.addView(masterTable);
        if (masterTable2 != null && masterTable2.getParent() != null)
        ((ViewGroup) masterTable2.getParent()).removeView(masterTable2);
      //  scrollLayout.addView(masterTable2);
        //scrollLayout.getOrientation();
        scrollView.addView(scrollLayout);

        //nonCardioLayout2.addView(masterTable);
        nonCardioLayout2.addView(scrollView);//, new ScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT, ScrollView.LayoutParams.MATCH_PARENT));
        //(nonCardioLayout2).addView(masterTable2);
       // nonCardioLayout.removeAllViews();

    }


    public void addReps(View view){


      //  LayoutInflater mainInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       // LayoutInflater inflater = this.getLayoutInflater();
       // View addExerciseView = inflater.inflate(R.layout.non_cardio, null);
      //  addExerciseView.findViewById(R.id.Cardio);
        //LinearLayout nonCardioLayout = (LinearLayout)mainInflater.inflate(R.layout.non_cardio, null);

       // LinearLayout nonCardioLayout2 = (LinearLayout)findViewById(R.id.non_cardio_Layout);

      //  TableLayout masterTable2 = (TableLayout)findViewById(R.id.master_Table);

        ScrollView scrollView = (ScrollView)nonCardioLayout2.findViewById(R.id.aScroll);

        LinearLayout scrollLayout= (LinearLayout)scrollView.findViewById(R.id.exerciseScrollLayout);

        TableLayout masterTable = (TableLayout)scrollLayout.findViewById(R.id.master_Table);

       TableRow enterNameTitleRow= (TableRow) masterTable.findViewById(R.id.enterNameTitleRow);

        EditText exerciseName = (EditText)enterNameTitleRow.findViewById(R.id.exerciseName);

        TableRow statsLayoutRow = (TableRow)masterTable.findViewById(R.id.statsLayoutRow);
        TableLayout statsLayout = (TableLayout)statsLayoutRow.findViewById(R.id.statsLayout);

        LinearLayout enterStatsLayout = (LinearLayout)statsLayout.findViewById(R.id.enterStatsLayout);

        EditText enterStatsWeight = (EditText) enterStatsLayout.findViewById(R.id.enterStatsWeight);
        EditText enterStatsReps = (EditText) enterStatsLayout.findViewById(R.id.enterStatsReps);

        String exerciseString = exerciseName.getText().toString();
        String weightString = enterStatsWeight.getText().toString();
        String repString = enterStatsReps.getText().toString();
        if(weightString == null || weightString.isEmpty())
            enterStatsWeight.setText("0.0");
        if(repString == null || repString.isEmpty())
            enterStatsReps.setText("0");

        if(exerciseString == null || exerciseString.isEmpty())
            exerciseName.setText("0");
        weights.add((enterStatsWeight.getText().toString()));
        reps.add((enterStatsReps.getText().toString()));
        exerciseNames.add(exerciseName.getText().toString());
       // weights.add(enterStatsWeight.getText().toString());
      //  reps.add(enterStatsReps.getText().toString());
     /*   statsLayoutRow = (TableRow) masterTable2.findViewById(R.id.statsLayoutRow);
        statsLayout = (TableLayout) findViewById(R.id.statsLayout);
        nameTitleRow = (TableRow) masterTable2.findViewById(R.id.nameTitleRow);
        enterNameTitleRow= (TableRow) masterTable2.findViewById(R.id.enterNameTitleRow);

        enterStatsLayout = (LinearLayout) findViewById(R.id.enterStatsLayout);
        //enterStatsRow =  (TableRow) enterStatsLayout.findViewById(R.id.enterStatsRow);
        weightRepsRow = (TableRow) findViewById(R.id.weightRepsRow);

      //  TableLayout masterTable= (TableLayout) nonCardioLayout.findViewById(R.id.master_Table);
     //   statsTable = (TableRow) masterTable.findViewById(R.id.statsLayoutRow);
     //   statsLayout = (TableLayout)statsTable.findViewById(R.id.statsLayout);

      //  int resTitleId = getResources().getIdentifier(Integer.toString(weights.size()), null, getPackageName());
      //  statsTable.setId(resTitleId);
       // ((ViewGroup)statsTable.getParent()).removeView(statsTable);
      //  statsLayoutRow = (TableRow)statsTable.findViewById(R.id.statsLayoutRow);

        EditText weightAmount = (EditText)findViewById(R.id.enterStatsWeight);
        EditText amountOfReps = (EditText)findViewById(R.id.enterStatsReps);


     /*   String weightString = weightAmount.getText().toString();
        String repString = amountOfReps.getText().toString();
        if(weightString == null || weightString.isEmpty())
            weightAmount.setText("0.0");
        if(repString == null || repString.isEmpty())
            amountOfReps.setText("0");
        weights.add((weightAmount.getText().toString()));
        reps.add((amountOfReps.getText().toString()));
*/
       // weights.add("0.0");
       // reps.add("0");
      //  exerciseNames.add("go");
//        weightAmount.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
     //   ((ViewGroup)weightAmount.getParent()).removeView(weightAmount);
//
      //  nonCardioLayout.addView(weightAmount);
      //  nonCardioLayout.removeAllViews();
        //this is just a class that allows you to call a different class
        Intent intent = new Intent();
        //this result is called there are other ways but this calls the other screen
     //   String[] exNamesArray = exerciseNames.toArray(new String[exerciseNames.size()]);
       // String[] wtArray =weights.toArray(new String[weights.size()]);
        //String[] repsArray= reps.toArray(new String[reps.size()]);

       // ArrayList<String> exNamesArray = ex
        intent.putExtra("exerciseNames", exerciseNames);
        intent.putExtra("weights", weights );
        intent.putExtra("reps", reps);
        setResult(0, intent);
        finish();

    }

    //when you add a button in the design view add a attribute onClick="addExerciseName"
    //it will call this function as a callback
    public void addExerciseToList(View view){

        ScrollView scrollView = (ScrollView)nonCardioLayout2.findViewById(R.id.aScroll);

        LinearLayout scrollLayout= (LinearLayout)scrollView.findViewById(R.id.exerciseScrollLayout);

        TableLayout masterTable = (TableLayout)scrollLayout.findViewById(R.id.master_Table);

        TableRow enterNameTitleRow= (TableRow) masterTable.findViewById(R.id.enterNameTitleRow);

        EditText exerciseName = (EditText)enterNameTitleRow.findViewById(R.id.exerciseName);

        TableRow statsLayoutRow = (TableRow)masterTable.findViewById(R.id.statsLayoutRow);
        TableLayout statsLayout = (TableLayout)statsLayoutRow.findViewById(R.id.statsLayout);

        LinearLayout enterStatsLayout = (LinearLayout)statsLayout.findViewById(R.id.enterStatsLayout);

        EditText enterStatsWeight = (EditText) enterStatsLayout.findViewById(R.id.enterStatsWeight);
        EditText enterStatsReps = (EditText) enterStatsLayout.findViewById(R.id.enterStatsReps);

        String exerciseString = exerciseName.getText().toString();
        String weightString = enterStatsWeight.getText().toString();
        String repString = enterStatsReps.getText().toString();
        if(weightString == null || weightString.isEmpty())
            enterStatsWeight.setText("0.0");
        if(repString == null || repString.isEmpty())
            enterStatsReps.setText("0");

        if(exerciseString == null || exerciseString.isEmpty())
            exerciseName.setText("0");

        weights.add((enterStatsWeight.getText().toString()));
        reps.add((enterStatsReps.getText().toString()));
        exerciseNames.add(exerciseName.getText().toString());
        //unimplemented
        //  EditText edit = (EditText)findViewById(R.id.exerciseName);
        //unimplemented
        // exerciseNames.add(edit.getText().toString());
        //gets rid of the second screen
        Intent intent = new Intent();
        intent.putExtra("exerciseNames", exerciseNames);
        intent.putExtra("weights", weights );
        intent.putExtra("reps", reps);
        setResult(1, intent);
        finish();
      //  MainActivity.exerciseNames.add((Button)findViewById(R.))
    }

}
