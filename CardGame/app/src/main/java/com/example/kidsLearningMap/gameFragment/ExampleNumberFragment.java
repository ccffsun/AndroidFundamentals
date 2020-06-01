package com.example.kidsLearningMap.gameFragment;

import android.animation.ObjectAnimator;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.kidsLearningMap.R;



/**
 * A simple {@link Fragment} subclass.
 */
public class ExampleNumberFragment extends Fragment {

    MediaPlayer mediaPlayer;
    public ExampleNumberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_example_number, container, false);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.start_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController controller = Navigation.findNavController(v);
                controller.navigate(R.id.action_exampleNumberFragment_to_questionNumberFragment);
            }
        });

        mediaPlayer = MediaPlayer.create(getContext(),R.raw.number_sound_two);
        new CountDownTimer(2500, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mediaPlayer.setLooping(true);
                mediaPlayer.start();
            }
            public void onFinish() {
                mediaPlayer.stop();
            }
        }.start();


        final ImageView exampleView = view.findViewById(R.id.color_image);

        ImageView handView = view.findViewById(R.id.click_image);
        final ImageView yesView = view.findViewById(R.id.yes_image);
        yesView.setVisibility(View.INVISIBLE);
        ObjectAnimator animation = ObjectAnimator.ofFloat(handView, "translationY", -180f);
        animation.setDuration(1500);
        animation.start();
        animation.setRepeatCount(2);
        new CountDownTimer(4500, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }
            public void onFinish() {
                yesView.setVisibility(View.VISIBLE);
            }
        }.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer.stop();
        //mediaPlayer.release();
    }
}
