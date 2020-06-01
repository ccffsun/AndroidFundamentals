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
public class QuestionColorFragment extends QuestionTemplateFragment {

    public QuestionColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        buttons = new AllButtonImages();
        ButtonImages blueButton = new ButtonImages(R.drawable.bluebutton,"BLUE");
        ButtonImages yellowButton = new ButtonImages(R.drawable.yellowbutton,"YELLOW");
        ButtonImages redButton = new ButtonImages(R.drawable.redbutton,"RED");
        ButtonImages purpleButton = new ButtonImages(R.drawable.purplebutton,"PURPLE");
        ButtonImages greenButton = new ButtonImages(R.drawable.greenbutton,"GREEN");
        ButtonImages orangeButton = new ButtonImages(R.drawable.orangebutton,"ORANGE");

        buttons.add(blueButton);
        buttons.add(yellowButton);
        buttons.add(redButton);
        buttons.add(purpleButton);
        buttons.add(greenButton);
        buttons.add(orangeButton);

        cards = new AllCardImages();
        cards.add(new CardImages(R.drawable.pear_copy, R.drawable.pear, "GREEN", greenButton));
        cards.add(new CardImages(R.drawable.banana_copy, R.drawable.banana, "YELLOW", yellowButton));
        cards.add(new CardImages(R.drawable.blueberry_copy, R.drawable.blueberry, "BLUE", blueButton));
        cards.add(new CardImages(R.drawable.carrot_copy, R.drawable.carrot, "ORANGE", orangeButton));
        cards.add(new CardImages(R.drawable.strawberry_copy, R.drawable.strawberry, "RED", redButton));
        cards.add(new CardImages(R.drawable.mango_copy, R.drawable.mango, "YELLOW", yellowButton));
        cards.add(new CardImages(R.drawable.cherry_copy, R.drawable.cherry, "RED", redButton));
        cards.add(new CardImages(R.drawable.lemon_copy, R.drawable.lemon, "YELLOW", yellowButton));
        cards.add(new CardImages(R.drawable.kiwi_copy, R.drawable.kiwi, "GREEN", greenButton));
        cards.add(new CardImages(R.drawable.grape_copy, R.drawable.grape, "PURPLE", purpleButton));
        cards.add(new CardImages(R.drawable.orangefruit_copy, R.drawable.orangefruit, "ORANGE", orangeButton));
        cards.add(new CardImages(R.drawable.pineapple_copy, R.drawable.pineapple, "YELLOW", yellowButton));
        cards.add(new CardImages(R.drawable.pomegranate_copy, R.drawable.pomegranate, "RED", redButton));
        cards.add(new CardImages(R.drawable.pumpkin_copy, R.drawable.pumpkin, "ORANGE", orangeButton));
        cards.add(new CardImages(R.drawable.tomato_copy, R.drawable.tomato, "RED", redButton));
        cards.shuffle();

        return inflater.inflate(R.layout.fragment_question_color, container, false);
    }



    @Override
    public int resIdSwitch(CardImages cardImages) {
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
        return resId;
    }

    @Override
    public void navigation() {
        NavController controller = Navigation.findNavController(getActivity(),card.getId());
        controller.navigate(R.id.action_questionColorFragment_to_goodjobFragment);
    }
}
