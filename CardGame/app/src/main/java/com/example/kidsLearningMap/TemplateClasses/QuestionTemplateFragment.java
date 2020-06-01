package com.example.kidsLearningMap.TemplateClasses;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kidsLearningMap.R;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public abstract class QuestionTemplateFragment extends Fragment {

    public AllButtonImages buttons;
    public TextView textView;
    public boolean clicked = false;
    public ImageView card;
    public ImageView correct;
    public ImageView wrong;
    public ImageView[] optionImages;
    public CardImages cardImages;
    public AllCardImages cards;
    public MediaPlayer mediaPlayer;
    public static int questionNo = 0;

    public QuestionTemplateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    /*

        cards = new AllCardImages();
        cards.add(new CardImages(R.drawable.pear_copy, R.drawable.pear, "GREEN", buttionImage));

        buttons = new AllButtonImages();
        buttons.add(new ButtonImages(R.drawable.pear_copy,"ITEM");

        2.buttons.PickUpOptions(ImageView answer, List<ImageView> allButton, int n)
        //获得一个list 里面包含一个正确答案red，还有另外三个选项，4代表一共有四个选项，并且shuffle过
        List<ButtonImages> options = buttons.pickUpOptions(answer,buttons.allButtonImages,4)

        for(int i=0; i< options.size();i++){
            ImageView option = options.get(i);

            option.setOnClickListener((v)->{
                String item = String.valueOf(option.getContentDescription);
                checkAnswer(item);

            });

            questionNo = 0;
            nextQuestion(questionNo);

         *每个项目1 只需要一次全部添加好，此处2每次出题都需要刷新一次



        */
        return inflater.inflate(R.layout.fragment_template, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView option1 = view.findViewById(R.id.optionOne);
        ImageView option2 = view.findViewById(R.id.optionTwo);
        ImageView option3 = view.findViewById(R.id.optionThree);
        ImageView option4 = view.findViewById(R.id.optionFour);
        optionImages = new ImageView[]{option1,option2,option3,option4};
        correct = view.findViewById(R.id.correct_image);
        wrong = view.findViewById(R.id.wrong_image);
        textView = view.findViewById(R.id.textViewTemplate);
        card = view.findViewById(R.id.cardTemplate);
        correct.setVisibility(View.INVISIBLE);
        wrong.setVisibility(View.INVISIBLE);

        questionNo = 0;
        nextQuestion(questionNo);

    }




    //以下要重写  针对不同的item 发出不同的声音
    public abstract int resIdSwitch (CardImages images);
       /*
        int resId = 0;
        switch (cardImages.getCardItem()) {
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

        */


     public abstract void navigation();

    private void nextQuestion(int i){
        clicked = false;
        if(i < cards.allCardImages.size()){
            cardImages = cards.allCardImages.get(i);
            textView.setText(cardImages.getCardItem());
            //mediaPlayer
            int resId = resIdSwitch(cardImages);
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



            int newPuzzleCard = cardImages.getPuzzleCard();

            card.setImageResource(newPuzzleCard);

            List<ButtonImages> options = buttons.pickUpOptions(cardImages.getButtonImages(),buttons.allButtonImages,4);

            for(int k=0; k< options.size();k++) {
                ImageView currentOption = optionImages[k];
                final ButtonImages option = options.get(k);
                currentOption.setImageResource(option.getButtonImages());
                currentOption.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String item = option.getItem();
                        checkAnswer(item);
                    }
                });
            }
        }else {
            /*
            NavController controller = Navigation.findNavController(requireActivity(),card.getId());
            controller.navigate(R.id.action_questionShapeFragment_to_goodjobFragment);
             */
            navigation();
        }
    }



    public void checkAnswer(String item){
        String answer = textView.getText().toString();

        if(answer.equals(item)) {
            if(clicked)
                return;



            new CountDownTimer(1000, 100) {
                @Override
                public void onTick(long millisUntilFinished) {

                    card.setImageResource(cardImages.getSolvedCard());
                    correct.setVisibility(View.VISIBLE);
                }
                public void onFinish() {
                    correct.setVisibility(View.INVISIBLE);
                    questionNo++;
                    nextQuestion(questionNo);

                }
            }.start();
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

