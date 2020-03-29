package com.example.twoactivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int TEXT_REQUEST = 13;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;
    public static final String EXTRA_MESSAGE =
            "com.example.twoactivities.extra.MESSAGE";
    private EditText mMessageEditText;
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();


    //the only Activity state you're interested in are the TextView
    // elements for the reply header and the reply text in the main
    // Activity. Both TextView elements are invisible by default;
    // they only appear once you send a message back to the main Activity
    // from the second Activity.In this task you add code to preserve the
    // instance state of these two TextView elements using onSaveInstanceState().
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        //Check to see if the header is currently visible, and if so put
        // that visibility state into the state Bundle with the putBoolean()
        // method and the key "reply_visible".
        if(mReplyHeadTextView.getVisibility() == View.VISIBLE) {
        outState.putBoolean("reply_visible",true);

        outState.putString("reply_text",mReplyTextView.getText().toString());
        //Note that the system will save the state of some View elements,
        // such as the contents of the EditText.
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Log the start of the onCreate() method
        Log.d(LOG_TAG,"--------------");
        Log.d(LOG_TAG,"onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize all the view variables
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView = findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);

        //Restore the state
        if(savedInstanceState != null) {
            //Inside that check, get the current visibility (true or false) out of
            // the Bundle with the key "reply_visible".
            boolean isVisible =
                    savedInstanceState.getBoolean("reply_visible");

            // Show both the header and the message views. If isVisible is
            // false or missing from the bundle, use the default layout.
            if(isVisible) {
               mReplyHeadTextView.setVisibility(View.VISIBLE);
               mReplyTextView.setText(savedInstanceState.getString("reply_text"));
               mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy");
    }



    public void launchSecondActivity(View view) {
        Log.d(LOG_TAG, "Button clicked!");
        //The Intent constructor takes two arguments for an explicit Intent: an application Context
        // and the specific component that will receive that Intent. Here you should use this as the Context,
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivityForResult(intent, TEXT_REQUEST); //main activity(a) starts an activity(b) to send message in
        //the intent, and we have a text_request for b. b write messages in the intent then close the activity(b),

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply =
                        data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);
            }
        }
    }

}
