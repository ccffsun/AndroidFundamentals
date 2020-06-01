package com.example.kidsLearningMap.gameFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kidsLearningMap.R;
import com.example.kidsLearningMap.TemplateClasses.AllButtonImages;
import com.example.kidsLearningMap.TemplateClasses.AllCardImages;
import com.example.kidsLearningMap.TemplateClasses.ButtonImages;
import com.example.kidsLearningMap.TemplateClasses.CardImages;
import com.example.kidsLearningMap.TemplateClasses.QuestionTemplateFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionAlphabetFragment extends QuestionTemplateFragment {

    public QuestionAlphabetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        buttons = new AllButtonImages();
        ButtonImages aButton = new ButtonImages(R.drawable.alphabet_a,"ant");
        ButtonImages bButton = new ButtonImages(R.drawable.alphabet_b,"balloon");
        ButtonImages cButton = new ButtonImages(R.drawable.alphabet_c,"cupcake");
        ButtonImages dButton = new ButtonImages(R.drawable.alphabet_d,"duck");
        ButtonImages eButton = new ButtonImages(R.drawable.alphabet_e,"envelope");
        ButtonImages fButton = new ButtonImages(R.drawable.alphabet_f,"fire");
        ButtonImages gButton = new ButtonImages(R.drawable.alphabet_g,"gate");
        ButtonImages hButton = new ButtonImages(R.drawable.alphabet_h,"hat");
        ButtonImages iButton = new ButtonImages(R.drawable.alphabet_i,"ice cream");
        ButtonImages jButton = new ButtonImages(R.drawable.alphabet_j,"jellyfish");
        ButtonImages kButton = new ButtonImages(R.drawable.alphabet_k,"key");
        ButtonImages lButton = new ButtonImages(R.drawable.alphabet_l,"lollipop");
        ButtonImages mButton = new ButtonImages(R.drawable.alphabet_m,"moon");
        ButtonImages nButton = new ButtonImages(R.drawable.alphabet_n,"nest");
        ButtonImages oButton = new ButtonImages(R.drawable.alphabet_o,"octopus");
        ButtonImages pButton = new ButtonImages(R.drawable.alphabet_p,"pail");
        ButtonImages qButton = new ButtonImages(R.drawable.alphabet_q,"quarter");
        ButtonImages rButton = new ButtonImages(R.drawable.alphabet_r,"robot");
        ButtonImages sButton = new ButtonImages(R.drawable.alphabet_s,"seal");
        ButtonImages tButton = new ButtonImages(R.drawable.alphabet_t,"teeth");
        ButtonImages uButton = new ButtonImages(R.drawable.alphabet_u,"unicorn");
        ButtonImages vButton = new ButtonImages(R.drawable.alphabet_v,"violin");
        ButtonImages wButton = new ButtonImages(R.drawable.alphabet_w,"watch");
        ButtonImages xButton = new ButtonImages(R.drawable.alphabet_x,"xylophone");
        ButtonImages yButton = new ButtonImages(R.drawable.alphabet_y,"yarn");
        ButtonImages zButton = new ButtonImages(R.drawable.alphabet_z,"zeppelin");



        buttons.add(aButton);
        buttons.add(bButton);
        buttons.add(cButton);
        buttons.add(dButton);
        buttons.add(eButton);
        buttons.add(fButton);
        buttons.add(gButton);
        buttons.add(hButton);
        buttons.add(iButton);
        buttons.add(jButton);
        buttons.add(kButton);
        buttons.add(lButton);
        buttons.add(mButton);
        buttons.add(nButton);
        buttons.add(oButton);
        buttons.add(pButton);
        buttons.add(qButton);
        buttons.add(rButton);
        buttons.add(sButton);
        buttons.add(tButton);
        buttons.add(uButton);
        buttons.add(vButton);
        buttons.add(wButton);
        buttons.add(xButton);
        buttons.add(yButton);
        buttons.add(zButton);


        cards = new AllCardImages();
        cards.add(new CardImages(R.drawable.alph_ant, R.drawable.alph_ant, "ant", aButton));
        cards.add(new CardImages(R.drawable.alph_balloon, R.drawable.alph_balloon, "balloon", bButton));
        cards.add(new CardImages(R.drawable.alph_cupcake, R.drawable.alph_cupcake, "cupcake", cButton));
        cards.add(new CardImages(R.drawable.alph_duck, R.drawable.alph_duck, "duck", dButton));
        cards.add(new CardImages(R.drawable.alph_envelope, R.drawable.alph_envelope, "envelope", eButton));
        cards.add(new CardImages(R.drawable.alph_fire, R.drawable.alph_fire, "fire", fButton));
        cards.add(new CardImages(R.drawable.alph_gate, R.drawable.alph_gate, "gate", gButton));
        cards.add(new CardImages(R.drawable.alph_hat, R.drawable.alph_hat, "hat", hButton));
        cards.add(new CardImages(R.drawable.alph_icecream, R.drawable.alph_icecream, "ice cream", iButton));
        cards.add(new CardImages(R.drawable.alph_jellyfish, R.drawable.alph_jellyfish, "jellyfish", jButton));
        cards.add(new CardImages(R.drawable.alph_key, R.drawable.alph_key, "key", kButton));
        cards.add(new CardImages(R.drawable.alph_lollipop, R.drawable.alph_lollipop, "lollipop", lButton));
        cards.add(new CardImages(R.drawable.alph_moon, R.drawable.alph_moon, "moon", mButton));
        cards.add(new CardImages(R.drawable.alph_nest, R.drawable.alph_nest, "nest", nButton));
        cards.add(new CardImages(R.drawable.alph_octopus, R.drawable.alph_octopus, "octopus", oButton));
        cards.add(new CardImages(R.drawable.alph_pail, R.drawable.alph_pail, "pail", pButton));
        cards.add(new CardImages(R.drawable.alph_quarter, R.drawable.alph_quarter, "quarter", qButton));
        cards.add(new CardImages(R.drawable.alph_robot, R.drawable.alph_robot, "robot", rButton));
        cards.add(new CardImages(R.drawable.alph_seal, R.drawable.alph_seal, "seal", sButton));
        cards.add(new CardImages(R.drawable.alph_teeth, R.drawable.alph_teeth, "teeth", tButton));
        cards.add(new CardImages(R.drawable.alph_unicorn, R.drawable.alph_unicorn, "unicorn", uButton));
        cards.add(new CardImages(R.drawable.alph_violin, R.drawable.alph_violin, "violin", vButton));
        cards.add(new CardImages(R.drawable.alph_watch, R.drawable.alph_watch, "watch", wButton));
        cards.add(new CardImages(R.drawable.alph_xylophone, R.drawable.alph_xylophone, "xylophone", xButton));
        cards.add(new CardImages(R.drawable.alph_yarn, R.drawable.alph_yarn, "yarn", yButton));
        cards.add(new CardImages(R.drawable.alph_zeppelin, R.drawable.alph_zeppelin, "zeppelin", zButton));

        cards.shuffle();

        return inflater.inflate(R.layout.fragment_question_alphabet, container, false);
    }



    @Override
    public int resIdSwitch(CardImages cardImages) {
        int resId = 0;
        switch (cardImages.getCardItem()) {
            case "ant":
                resId = R.raw.alph_sound_ant;
                break;
            case "balloon":
                resId = R.raw.alph_sound_balloon;
                break;
            case "cupcake":
                resId = R.raw.alph_sound_cupcake;
                break;
            case "duck":
                resId = R.raw.alph_sound_duck;
                break;
            case "envelope":
                resId = R.raw.alph_sound_envelope;
                break;
            case "fire":
                resId = R.raw.alph_sound_fire;
                break;
            case "gate":
                resId = R.raw.alph_sound_gate;
                break;
            case "hat":
                resId = R.raw.alph_sound_hat;
                break;
            case "ice cream":
                resId = R.raw.alph_sound_icecream;
                break;
            case "jellyfish":
                resId = R.raw.alph_sound_jellyfish;
                break;
            case "key":
                resId = R.raw.alph_sound_key;
                break;
            case "lollipop":
                resId = R.raw.alph_sound_lollipop;
                break;
            case "moon":
                resId = R.raw.alph_sound_moon;
                break;

            case "nest":
                resId = R.raw.alph_sound_nest;
                break;
            case "octopus":
                resId = R.raw.alph_sound_octopus;
                break;
            case "pail":
                resId = R.raw.alph_sound_pail;
                break;
            case "quarter":
                resId = R.raw.alph_sound_quarter;
                break;
            case "robot":
                resId = R.raw.alph_sound_robot;
                break;
            case "seal":
                resId = R.raw.alph_sound_seal;
                break;
            case "teeth":
                resId = R.raw.alph_sound_teeth;
                break;
            case "unicorn":
                resId = R.raw.alph_sound_unicorn;
                break;
            case "violin":
                resId = R.raw.alph_sound_violin;
                break;
            case "watch":
                resId = R.raw.alph_sound_watch;
                break;
            case "xylophone":
                resId = R.raw.alph_sound_xylophone;
                break;
            case "yarn":
                resId = R.raw.alph_sound_yarn;
                break;
            case "zeppelin":
                resId = R.raw.alph_sound_zeppelin;
                break;
        }
        return resId;
    }

    @Override
    public void navigation() {
        NavController controller = Navigation.findNavController(getActivity(),card.getId());
        controller.navigate(R.id.action_questionAlphabetFragment_to_goodjobFragment);
    }
}
