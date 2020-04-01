package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mWebsiteEditText;
    private EditText mLocationEditText;
    private EditText mShareTextEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebsiteEditText = findViewById(R.id.website_edittext);
        mLocationEditText = findViewById(R.id.location_edittext);
        mShareTextEditText = findViewById(R.id.share_edittext);
    }

    public void openWebsite(View view) {
        String url = mWebsiteEditText.getText().toString();

        //Encode and parse that string into a Uri object
        Uri webpage = Uri.parse(url);
        //Actions are defined by the Intent class and can include
        // ACTION_VIEW (to view the given data), ACTION_EDIT
        // (to edit the given data), or ACTION_DIAL (to dial a phone number).
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        //intent.addCategory("android.intent.category.VOICE");

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void openLocation(View view) {
        // Get the string indicating a location. Input is not validated; it is
        // passed to the location handler intact.
        String loc = mLocationEditText.getText().toString();

        // Parse the location and create the intent.
        Uri addressUri = Uri.parse("geo:0,0?q="+loc);
        Intent intent = new Intent(Intent.ACTION_VIEW,addressUri);

        // Find an activity to handle the intent, and start that activity.
        if(intent.resolveActivity(getPackageManager())!= null) {
            startActivity(intent);
        }else {
            Log.d("ImplicitIntents","Can't handle this intent");
        }
    }

    public void shareText(View view) {
        String txt = mShareTextEditText.getText().toString();
        String mimeType = "text/plain";
        //use ShareCompat.IntentBuilder to build an Intent and
        // launch a chooser to let the user choose the destination app for sharing
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.setChoosterTitle)
                .setText(txt)
                .startChooser();
    }
}
