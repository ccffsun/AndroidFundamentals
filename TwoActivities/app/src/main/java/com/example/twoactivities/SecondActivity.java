package com.example.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Set;

public class SecondActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY =
            "com.example.twoactivities.extra.REPLY";
    private EditText mReply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Get the Intent that activated this Activity:
        Intent intent = getIntent();

        //Get the string containing the message from the Intent
        // extras using the MainActivity.EXTRA_MESSAGE static variable as the key:
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.text_message);

        textView.setText(message);
        mReply = findViewById(R.id.editText_second);
    }

    public void returnReply(View view) {
        String reply = mReply.getText().toString();
        //In the returnReply() method, create a new intent for the response—don't reuse
        // the Intent object that you received from the original request.
        Intent replyIntent = new Intent();

        replyIntent.putExtra(EXTRA_REPLY,reply);

        //Set the result to RESULT_OK to indicate that the response was successful. The
        // Activity class defines the result codes, including RESULT_OK and RESULT_CANCELLED.
        setResult(RESULT_OK,replyIntent);

        //Call finish() to close the Activity and return to MainActivity.
        finish();
    }
}
