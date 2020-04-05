package com.example.pickerfordate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void showDatePicker(View view) {
        DialogFragment newFragment =  new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), getString(R.string.datepicker));
    }

    public void processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month+1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string+"/"+day_string+"/"+year_string);
        Toast.makeText(this,getString(R.string.date)+ " "+dateMessage,Toast.LENGTH_SHORT).show();

    }

    public void showTimePicker(View view) {
        DialogFragment newFragment2 = new TimePickerFragment();
        newFragment2.show(getSupportFragmentManager(),getString(R.string.timepicker));

    }

    public void processTimePickerResult(int hour, int minute) {
        String hour_string = Integer.toString(hour);
        String minute_string = Integer.toString(minute);

        String timeMessage = (hour_string + " : "+minute_string);
        Toast.makeText(this,"Time:"+" "+timeMessage,Toast.LENGTH_SHORT).show();
    }
}
