package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences shp = getSharedPreferences("data_name", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = shp.edit();
        editor.putInt("my_key",900);
        editor.apply();
        int x = shp.getInt("my_key",0);
        String TAG = "myLog";
        Log.d(TAG,"onCreate: "+x);

    }
}
