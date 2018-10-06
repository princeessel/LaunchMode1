package com.example.genius_otis.launchmode1;

import android.app.ActivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import java.util.List;


public abstract class MainActivity extends AppCompatActivity implements View.OnClickListener{

    protected static ActivityManager activityManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(activityManager==null){
            activityManager=(ActivityManager)getSystemService(ACTIVITY_SERVICE);
        }

    }

    protected static String getAppTaskState(){

        StringBuilder stringBuilder=new StringBuilder();
        int totalNumberOfTasks;
        totalNumberOfTasks = activityManager.getRunningTasks(10).size();
        stringBuilder.append("\nTotal Number of Tasks: "+totalNumberOfTasks+"\n\n");

        List<ActivityManager.RunningTaskInfo> taskInfo =activityManager.getRunningTasks(10);//returns List of RunningTaskInfo - corresponding to tasks - stacks

        for(ActivityManager.RunningTaskInfo info:taskInfo){
            stringBuilder.append("Task Id: "+info.id+", Number of Activities : "+info.numActivities+"\n");//Number of Activities in task - stack

           
            stringBuilder.append("TopActivity: "+ info.topActivity.getClassName().replace("com.example.genius_otis.launchmode1","")+"\n");

            stringBuilder.append("MainActivity:"+ info.baseActivity.getClassName().replace("com.example.genius_otis.launchmode1","")+"\n");
            stringBuilder.append("\n\n");
        }
        return stringBuilder.toString();
    }

}