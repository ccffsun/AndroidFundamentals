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
public class QuestionAnimalFragment extends QuestionTemplateFragment {

    public QuestionAnimalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        buttons = new AllButtonImages();
        ButtonImages bearButton = new ButtonImages(R.drawable.animal_tagbear, "bear");
        ButtonImages catButton = new ButtonImages(R.drawable.animal_tagcat, "cat");
        ButtonImages dogButton = new ButtonImages(R.drawable.animal_tagdog, "dog");
        ButtonImages elephantButton = new ButtonImages(R.drawable.animal_tagelephant, "elephant");
        ButtonImages frogButton = new ButtonImages(R.drawable.animal_tagfrog, "frog");
        ButtonImages horseButton = new ButtonImages(R.drawable.animal_taghorse, "horse");
        ButtonImages monkeyButton = new ButtonImages(R.drawable.animal_tagmonkey, "monkey");
        ButtonImages owlButton = new ButtonImages(R.drawable.animal_tagowl, "owl");
        ButtonImages pandaButton = new ButtonImages(R.drawable.animal_tagpanda, "panda");
        ButtonImages tigerButton = new ButtonImages(R.drawable.animal_tagtiger, "tiger");


        buttons.add(bearButton);
        buttons.add(catButton);
        buttons.add(dogButton);
        buttons.add(elephantButton);
        buttons.add(frogButton);
        buttons.add(horseButton);
        buttons.add(monkeyButton);
        buttons.add(owlButton);
        buttons.add(pandaButton);
        buttons.add(tigerButton);


        cards = new AllCardImages();
        cards.add(new CardImages(R.drawable.ani_bear, R.drawable.ani_bear, "bear", bearButton));
        cards.add(new CardImages(R.drawable.ani_cat, R.drawable.ani_cat, "cat", catButton));
        cards.add(new CardImages(R.drawable.ani_dog, R.drawable.ani_dog, "dog", dogButton));
        cards.add(new CardImages(R.drawable.ani_elephent, R.drawable.ani_elephent, "elephant", elephantButton));
        cards.add(new CardImages(R.drawable.ani_frog, R.drawable.ani_frog, "frog", frogButton));
        cards.add(new CardImages(R.drawable.ani_horse, R.drawable.ani_horse, "horse", horseButton));
        cards.add(new CardImages(R.drawable.ani_monkey, R.drawable.ani_monkey, "monkey", monkeyButton));
        cards.add(new CardImages(R.drawable.ani_owl, R.drawable.ani_owl, "owl", owlButton));
        cards.add(new CardImages(R.drawable.ani_panda, R.drawable.ani_panda, "panda", pandaButton));
        cards.add(new CardImages(R.drawable.ani_tiger, R.drawable.ani_tiger, "tiger", tigerButton));

        cards.shuffle();

        return inflater.inflate(R.layout.fragment_question_animal, container, false);
    }

    @Override
    public int resIdSwitch(CardImages images) {
        int resId = 0;
        switch (cardImages.getCardItem()) {
            case "bear":
                resId = R.raw.animal_sound_bear;
                break;
            case "cat":
                resId = R.raw.animal_sound_cat;
                break;
            case "dog":
                resId = R.raw.animal_sound_dog;
                break;
            case "elephant":
                resId = R.raw.animal_sound_elephant;
                break;
            case "frog":
                resId = R.raw.animal_sound_frog;
                break;
            case "horse":
                resId = R.raw.animal_sound_horse;
                break;
            case "monkey":
                resId = R.raw.animal_sound_monkey;
                break;
            case "owl":
                resId = R.raw.animal_sound_owl;
                break;
            case "panda":
                resId = R.raw.animal_sound_panda;
                break;
            case "tiger":
                resId = R.raw.animal_sound_tiger;
                break;

        }
        return resId;
    }
        @Override
        public void navigation() {
            NavController controller = Navigation.findNavController(getActivity(),card.getId());
            controller.navigate(R.id.action_questionAnimalFragment_to_goodjobFragment);
        }
    }
