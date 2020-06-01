package com.example.kidsLearningMap.gameFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.kidsLearningMap.TemplateClasses.AllButtonImages;
import com.example.kidsLearningMap.TemplateClasses.AllCardImages;
import com.example.kidsLearningMap.TemplateClasses.ButtonImages;
import com.example.kidsLearningMap.TemplateClasses.CardImages;
import com.example.kidsLearningMap.TemplateClasses.QuestionTemplateFragment;
import com.example.kidsLearningMap.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionNumberFragment extends QuestionTemplateFragment {

    public QuestionNumberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        buttons = new AllButtonImages();
        ButtonImages oneButton = new ButtonImages(R.drawable.numbers_one, "one");
        ButtonImages twoButton = new ButtonImages(R.drawable.numbers_two, "two");
        ButtonImages threeButton = new ButtonImages(R.drawable.numbers_three, "three");
        ButtonImages fourButton = new ButtonImages(R.drawable.numbers_four, "four");
        ButtonImages fiveButton = new ButtonImages(R.drawable.numbers_five, "five");
        ButtonImages sixButton = new ButtonImages(R.drawable.numbers_six, "six");
        ButtonImages sevenButton = new ButtonImages(R.drawable.numbers_seven, "seven");
        ButtonImages eightButton = new ButtonImages(R.drawable.numbers_eight, "eight");
        ButtonImages nineButton = new ButtonImages(R.drawable.numbers_nine, "nine");
        ButtonImages tenButton = new ButtonImages(R.drawable.numbers_ten, "ten");


        buttons.add(oneButton);
        buttons.add(twoButton);
        buttons.add(threeButton);
        buttons.add(fourButton);
        buttons.add(fiveButton);
        buttons.add(sixButton);
        buttons.add(sevenButton);
        buttons.add(eightButton);
        buttons.add(nineButton);
        buttons.add(tenButton);


        cards = new AllCardImages();
        cards.add(new CardImages(R.drawable.numberimage_one, R.drawable.numberimage_one, "one", oneButton));
        cards.add(new CardImages(R.drawable.numberimage_two, R.drawable.numberimage_two, "two", twoButton));
        cards.add(new CardImages(R.drawable.numberimage_three, R.drawable.numberimage_three, "three", threeButton));
        cards.add(new CardImages(R.drawable.numberimage_four, R.drawable.numberimage_four, "four", fourButton));
        cards.add(new CardImages(R.drawable.numberimage_five, R.drawable.numberimage_five, "five", fiveButton));
        cards.add(new CardImages(R.drawable.numberimage_six, R.drawable.numberimage_six, "six", sixButton));
        cards.add(new CardImages(R.drawable.numberimage_seven, R.drawable.numberimage_seven, "seven", sevenButton));
        cards.add(new CardImages(R.drawable.numberimage_eight, R.drawable.numberimage_eight, "eight", eightButton));
        cards.add(new CardImages(R.drawable.numberimage_nine, R.drawable.numberimage_nine, "nine", nineButton));
        cards.add(new CardImages(R.drawable.numberimage_ten, R.drawable.numberimage_ten, "ten", tenButton));

        cards.shuffle();

        return inflater.inflate(R.layout.fragment_question_number, container, false);
    }

    @Override
    public int resIdSwitch(CardImages images) {
        int resId = 0;
        switch (cardImages.getCardItem()) {
            case "one":
                resId = R.raw.number_sound_one;
                break;
            case "two":
                resId = R.raw.number_sound_two;
                break;
            case "three":
                resId = R.raw.number_sound_three;
                break;
            case "four":
                resId = R.raw.number_sound_four;
                break;
            case "five":
                resId = R.raw.number_sound_five;
                break;
            case "six":
                resId = R.raw.number_sound_six;
                break;
            case "seven":
                resId = R.raw.number_sound_seven;
                break;
            case "eight":
                resId = R.raw.number_sound_eight;
                break;
            case "nine":
                resId = R.raw.number_sound_nine;
                break;
            case "ten":
                resId = R.raw.number_sound_ten;
                break;

        }
        return resId;
    }

    @Override
    public void navigation() {
        NavController controller = Navigation.findNavController(getActivity(),card.getId());
        controller.navigate(R.id.action_questionNumberFragment_to_goodjobFragment);
    }
}
