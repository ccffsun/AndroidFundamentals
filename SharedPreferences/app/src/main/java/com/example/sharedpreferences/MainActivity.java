package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyData myData = new MyData(getApplicationContext());//here can't use this
        myData.number = 7000;
        myData.save();
        int x = myData.load();
        String TAG = "myLog";
        Log.d(TAG,"on create: "+x);

    }
}
