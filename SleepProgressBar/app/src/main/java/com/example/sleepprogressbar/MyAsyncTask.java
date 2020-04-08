package com.example.sleepprogressbar;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class MyAsyncTask extends AsyncTask <Integer,Integer,String>{
    private WeakReference<TextView> mTextView;
    private WeakReference<ProgressBar> mProgressBar;
    Integer count = 1;
    int n;
    int max;

    MyAsyncTask(TextView tv,ProgressBar pb) {
        mTextView = new WeakReference<>(tv);
        mProgressBar= new WeakReference<>(pb);
    }

    @Override
    protected String doInBackground(Integer... params) {
            count = 1;
            max = params[0];
            for(;count<= params[0];count++) {
                Random r = new Random();
                //between 0 (inclusive) and 11 (exclusive).
                n = r.nextInt(11);
                int s = n * 300;

                try {
                    Thread.sleep(s);

                    publishProgress(count);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Task Completed";
    }

    @Override
    protected void onPostExecute(String result) {
        //mProgressBar.get().setVisibility(View.GONE);
        mTextView.get().setText(result);
    }

    @Override
    protected  void onProgressUpdate(Integer...values) {
        mTextView.get().setText("Running..."+values[0]);
        if (n%2==0 || values[0] == max){
            mProgressBar.get().setProgress(values[0]);
        }

    }
}
