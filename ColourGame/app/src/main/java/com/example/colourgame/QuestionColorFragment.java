package com.example.colourgame;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionColorFragment extends Fragment {
    private String color;
    private ImageView fruit;
    private ImageView red;
    private ImageView green;
    private ImageView blue;
    private ImageView purple;
    private ImageView yellow;
    private ImageView orange;
    private ImageView correct;
    private ImageView wrong;
    private TextView textView;
    FruitImages fruitImages;
    AllFruitImages allFruitImages;
    static int questionNo = 0;
    MediaPlayer mediaPlayer;

    boolean clicked = false;

    public QuestionColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        allFruitImages = new AllFruitImages();
        allFruitImages.add(new FruitImages(R.drawable.pear_copy, R.drawable.pear, "GREEN"));
        allFruitImages.add(new FruitImages(R.drawable.blueberry_copy, R.drawable.blueberry, "BLUE"));
        allFruitImages.add(new FruitImages(R.drawable.carrot_copy, R.drawable.carrot, "ORANGE"));
        allFruitImages.add(new FruitImages(R.drawable.mango_copy, R.drawable.mango, "YELLOW"));
        allFruitImages.add(new FruitImages(R.drawable.tomato_copy, R.drawable.tomato, "RED"));
        allFruitImages.add(new FruitImages(R.drawable.grape_copy,R.drawable.grape,"PURPLE"));
        allFruitImages.add(new FruitImages(R.drawable.orangefruit_copy,R.drawable.orangefruit,"ORANGE"));
        allFruitImages.add(new FruitImages(R.drawable.banana_copy,R.drawable.banana,"YELLOW"));
        allFruitImages.add(new FruitImages(R.drawable.pineapple_copy, R.drawable.pineapple, "YELLOW"));
        allFruitImages.add(new FruitImages(R.drawable.kiwi_copy,R.drawable.kiwi,"GREEN"));
        allFruitImages.add(new FruitImages(R.drawable.strawberry_copy,R.drawable.strawberry,"RED"));
        allFruitImages.add(new FruitImages(R.drawable.cherry_copy,R.drawable.cherry,"RED"));
        allFruitImages.add(new FruitImages(R.drawable.plum_copy, R.drawable.plum, "PURPLE"));
        allFruitImages.add(new FruitImages(R.drawable.lemon_copy,R.drawable.lemon,"YELLOW"));
        allFruitImages.add(new FruitImages(R.drawable.pomegranate_copy,R.drawable.pomegranate,"RED"));
        allFruitImages.add(new FruitImages(R.drawable.pumpkin_copy,R.drawable.pumpkin,"ORANGE"));
        allFruitImages.add(new FruitImages(R.drawable.watermelon_copy,R.drawable.watermelon,"RED"));

        allFruitImages.shuffleFruitImages();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        red = view.findViewById(R.id.red_image);
        green = view.findViewById(R.id.green_image);
        blue = view.findViewById(R.id.blue_image);
        purple = view.findViewById(R.id.purple_image);
        yellow = view.findViewById(R.id.yellow_image);
        orange = view.findViewById(R.id.oragne_image);
        textView = view.findViewById(R.id.textView);
        fruit = view.findViewById(R.id.fruit_image);
        correct = view.findViewById(R.id.correct_image);
        wrong = view.findViewById(R.id.wrong_image);
        correct.setVisibility(View.INVISIBLE);
        wrong.setVisibility(View.INVISIBLE);



        red.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = "RED";
                checkAnswer(color);
            }
        });

        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = "GREEN";
                checkAnswer(color);
            }
        });

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = "BLUE";
                checkAnswer(color);
            }
        });

        purple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = "PURPLE";
                checkAnswer(color);
            }
        });

        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = "YELLOW";
                checkAnswer(color);
            }
        });

        orange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                color = "ORANGE";
                checkAnswer(color);
            }
        });
        questionNo = 0;
        nextQuestion(questionNo);
    }

    private void nextQuestion(int i){
        clicked = false;
        if(i<allFruitImages.allFruitImages.size()){
            fruitImages = allFruitImages.allFruitImages.get(i);
            textView.setText(fruitImages.getColor());
            //mediaPlayer
            int resId = 0;
            switch (fruitImages.getColor()) {
                case "GREEN":
                    resId = R.raw.green;
                    break;
                case "RED":
                    resId = R.raw.red;
                    break;
                case "YELLOW":
                    resId = R.raw.yellow;
                    break;
                case "PURPLE":
                    resId = R.raw.purple;
                    break;
                case "BLUE":
                    resId = R.raw.blue;
                    break;
                case "ORANGE":
                    resId = R.raw.orange;
                    break;
            }

            mediaPlayer = MediaPlayer.create(getContext(), resId);

            new Thread(){
                @Override
                public void run() {
                    super.run();
                    for(int count = 0; count< 3; count++)
                    {
                        mediaPlayer.start();
                        while (mediaPlayer.isPlaying()){

                        }
                        mediaPlayer.seekTo(0);
                    }
                }
            }.start();

            fruit.setImageResource(fruitImages.getCopyFruit());

        }else {
            NavController controller = Navigation.findNavController(getActivity(),fruit.getId());
            controller.navigate(R.id.action_questionFragment_to_goodjobFragment);
        }
    }

    public void checkAnswer (String color){
        String answer = textView.getText().toString();
        ImageView currentFruit = fruit;

        if(answer.equals(color)) {
            if(clicked)
                return;



            new CountDownTimer(1000, 100) {
                @Override
                public void onTick(long millisUntilFinished) {

                    fruit.setImageResource(fruitImages.getFruit());
                    correct.setVisibility(View.VISIBLE);
                }
                public void onFinish() {
                    correct.setVisibility(View.INVISIBLE);
                    questionNo++;
                    nextQuestion(questionNo);

                }
            }.start();

            //转到下一图片
            clicked = true;

        }else {
            new CountDownTimer(1000, 100) {
                @Override
                public void onTick(long millisUntilFinished) {
                    wrong.setVisibility(View.VISIBLE);
                }
                public void onFinish() {
                    wrong.setVisibility(View.INVISIBLE);
                }
            }.start();
        }
    }


}
