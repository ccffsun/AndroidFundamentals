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
public class QuestionShapeFragment extends QuestionTemplateFragment {

    public QuestionShapeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        buttons = new AllButtonImages();
        ButtonImages circleButton = new ButtonImages(R.drawable.shapeitem_circle, "circle");
        ButtonImages crescentButton = new ButtonImages(R.drawable.shapeitem_crescent, "crescent");
        ButtonImages diamondButton = new ButtonImages(R.drawable.shapeitem_diamond, "diamond");
        ButtonImages heartButton = new ButtonImages(R.drawable.shapeitem_heart, "heart");
        ButtonImages ovalButton = new ButtonImages(R.drawable.shapeitem_oval, "oval");
        ButtonImages pentagonButton = new ButtonImages(R.drawable.shapeitem_pentagon, "pentagon");
        ButtonImages rectangleButton = new ButtonImages(R.drawable.shapeitem_rectangle, "rectangle");
        ButtonImages squareButton = new ButtonImages(R.drawable.shapeitem_square, "square");
        ButtonImages starButton = new ButtonImages(R.drawable.shapeitem_star, "star");
        ButtonImages triangleButton = new ButtonImages(R.drawable.shapeitem_triangle, "triangle");


        buttons.add(circleButton);
        buttons.add(crescentButton);
        buttons.add(diamondButton);
        buttons.add(heartButton);
        buttons.add(ovalButton);
        buttons.add(pentagonButton);
        buttons.add(rectangleButton);
        buttons.add(squareButton);
        buttons.add(starButton);
        buttons.add(triangleButton);


        cards = new AllCardImages();
        cards.add(new CardImages(R.drawable.shape_circle, R.drawable.shape_circle, "circle", circleButton));
        cards.add(new CardImages(R.drawable.shape_crescent, R.drawable.shape_crescent, "crescent", crescentButton));
        cards.add(new CardImages(R.drawable.shape_diamond, R.drawable.shape_diamond, "diamond", diamondButton));
        cards.add(new CardImages(R.drawable.shape_heart, R.drawable.shape_heart, "heart", heartButton));
        cards.add(new CardImages(R.drawable.shape_oval, R.drawable.shape_oval, "oval", ovalButton));
        cards.add(new CardImages(R.drawable.shape_pentagon, R.drawable.shape_pentagon, "pentagon", pentagonButton));
        cards.add(new CardImages(R.drawable.shape_rectangle, R.drawable.shape_rectangle, "rectangle", rectangleButton));
        cards.add(new CardImages(R.drawable.shape_square, R.drawable.shape_square, "square", squareButton));
        cards.add(new CardImages(R.drawable.shape_star, R.drawable.shape_star, "star", starButton));
        cards.add(new CardImages(R.drawable.shape_triangle, R.drawable.shape_triangle, "triangle", triangleButton));

        cards.shuffle();

        return inflater.inflate(R.layout.fragment_question_shape, container, false);
    }

    @Override
    public int resIdSwitch(CardImages images) {
        int resId = 0;
        switch (cardImages.getCardItem()) {
            case "circle":
                resId = R.raw.shape_sound_circle;
                break;
            case "crescent":
                resId = R.raw.shape_sound_crescent;
                break;
            case "diamond":
                resId = R.raw.shape_sound_diamond;
                break;
            case "heart":
                resId = R.raw.shape_sound_heart;
                break;
            case "oval":
                resId = R.raw.shape_sound_oval;
                break;
            case "pentagon":
                resId = R.raw.shape_sound_pentagon;
                break;
            case "rectangle":
                resId = R.raw.shape_sound_rectangle;
                break;
            case "square":
                resId = R.raw.shape_sound_square;
                break;
            case "star":
                resId = R.raw.shape_sound_star;
                break;
            case "triangle":
                resId = R.raw.shape_sound_triangle;
                break;

        }
        return resId;
    }

    @Override
    public void navigation() {
        NavController controller = Navigation.findNavController(getActivity(),card.getId());
        controller.navigate(R.id.action_questionShapeFragment2_to_goodjobFragment);
    }
}
