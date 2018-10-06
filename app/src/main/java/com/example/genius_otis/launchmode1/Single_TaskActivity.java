package com.example.genius_otis.launchmode1;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Single_TaskActivity extends MainActivity {


    private static final String TAG = Standard_ModeActivity.class.getSimpleName();
    private static int instanceCounter = 0;
    private int currentValue;


    private Button singletop;
    private Button standard;
    private Button singletask;
    private Button singleinstance;
    private TextView taskInfoTV, valueTV;

    public Single_TaskActivity() {
        super();
        instanceCounter++;
        currentValue = instanceCounter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard__mode);

        singletask = findViewById(R.id.singleTask);
        singletop = findViewById(R.id.singleTop);
        singleinstance = findViewById(R.id.singleInstanceMode);
        standard = findViewById(R.id.standardMode);

        taskInfoTV = findViewById(R.id.taskInfoTV);
        valueTV = findViewById(R.id.valueTV);
        valueTV.append("Current instance: " + currentValue);

        standard.setOnClickListener(this);
        singletask.setOnClickListener(this);
        singletop.setOnClickListener(this);
        singleinstance.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewId=v.getId();

        switch (viewId) {
            case R.id.standard:
                startActivity(new Intent(this, Standard_ModeActivity.class));
                break;
            case R.id.singleTask:
                startActivity(new Intent(this, Single_TaskActivity.class));
                break;
            case R.id.singleInstanceMode:
                startActivity(new Intent(this, Single_InstanceActivity.class));
                break;
            case R.id.singleTop:
                startActivity(new Intent(this, SingleTopActivity.class));
                break;

            default:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "Instances: " + currentValue);
        taskInfoTV.setText(getAppTaskState());
    }

}



