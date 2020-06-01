package com.example.kidsLearningMap;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.DialogInterface;
import android.os.Bundle;

import com.example.kidsLearningMap.R;


public class MainActivity extends AppCompatActivity {

    NavController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        controller = Navigation.findNavController(this, R.id.fragment1);
        NavigationUI.setupActionBarWithNavController(this, controller);

    }

    @Override
    public boolean onSupportNavigateUp() {
        if(controller.getCurrentDestination().getId() != R.id.homeFragment || controller.getCurrentDestination().getId() != R.id.goodjobFragment)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(getString(R.string.quit_dialog_title));
            builder.setPositiveButton(R.string.dialog_positive_message, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    controller.navigate(R.id.homeFragment);

                }
            });
            builder.setNegativeButton(R.string.dialog_negative_message, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            AlertDialog dialog = builder.create();
            dialog.show();
        } else if(controller.getCurrentDestination().getId() == R.id.homeFragment) {
            finish();
        } else {
            controller.navigate(R.id.homeFragment);
        }
        return super.onSupportNavigateUp();
    }

    @Override
    public void onBackPressed() {
        onSupportNavigateUp();
    }
}
