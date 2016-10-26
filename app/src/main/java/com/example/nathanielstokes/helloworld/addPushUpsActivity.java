package com.example.nathanielstokes.helloworld;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nathaniel Stokes on 8/11/2016.
 */
public class addPushUpsActivity extends Activity implements SensorEventListener{

        //not currently being used but static so that other activities and classes can access
        //via MainActivity.exerciseNames
        public ArrayList<String> exerciseNames;
        public ArrayList<String> weights;

        public  ArrayList<String> reps;
        public ArrayList<String> formattedString;
        ArrayAdapter<String> adapter;
        //For use with code we deleted
        SimpleCursorAdapter mAdapter;
        public int addExerciseReqCode = 0;
        public int addRunningReqCode = 0;
        public RelativeLayout mainPageLayout;
        public RelativeLayout customLayout;
        public RelativeLayout.LayoutParams params;
        TextView pushUpCounter;
    TextView oldXYZ;
    TextView newXYZ;
        ListView thisScroll;

    public long lastUpdate =0;
    public float last_x, last_y, last_z, x, y, z;
    public static final int SHAKE_THRESHOLD = 600;
    public SensorManager sensorManager;
    public Sensor sensorAccelerometer;
    boolean refresh = false;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.push_up_assistant);

            sensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
            sensorAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            sensorManager.registerListener(this, sensorAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
       }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

        @Override
        protected void onResume() {

            super.onResume();
            //   ViewGroup viewGroup = (ViewGroup) findViewById(R.id.workoutPage);

            sensorManager.registerListener(this, sensorAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
            RelativeLayout viewGroup = (RelativeLayout) findViewById(R.id.pushUp_Page);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);


             pushUpCounter = (TextView) viewGroup.findViewById(R.id.pushUpCounter);
            if(refresh) {
                oldXYZ = (TextView) viewGroup.findViewById(R.id.oldXYZ);
                newXYZ = (TextView) viewGroup.findViewById(R.id.newXYZ);
                oldXYZ.setText(Float.toString(x) + " " + Float.toString(y) + " " + Float.toString(z));
                newXYZ.setText(Float.toString(last_x) + " " + Float.toString(last_y) + " " + Float.toString(last_z));
                refresh = false;
            }

            }

    public void updateUi()
    {
        RelativeLayout viewGroup = (RelativeLayout) findViewById(R.id.pushUp_Page);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);


        pushUpCounter = (TextView) viewGroup.findViewById(R.id.pushUpCounter);
        if(refresh) {
            oldXYZ = (TextView) viewGroup.findViewById(R.id.oldXYZ);
            newXYZ = (TextView) viewGroup.findViewById(R.id.newXYZ);
            oldXYZ.setText(Float.toString(x) + " " + Float.toString(y) + " " + Float.toString(z));
            newXYZ.setText(Float.toString(last_x) + " " + Float.toString(last_y) + " " + Float.toString(last_z));
            refresh = false;
        }




    }
    @Override
    protected void onPause(){


        super.onPause();
        sensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor mySensor = sensorEvent.sensor;

        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {

             x = sensorEvent.values[0];
             y = sensorEvent.values[1];
             z = sensorEvent.values[2];

            long curTime = System.currentTimeMillis();

            if ((curTime - lastUpdate) > 100) {
                long diffTime = (curTime - lastUpdate);
                lastUpdate = curTime;

                last_x = x;
                last_y = y;
                last_z = z;
                refresh = true;
             //   onResume();
                updateUi();

            }


        }
    }




}
