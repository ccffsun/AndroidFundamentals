package com.example.kidsLearningMap.TemplateClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllButtonImages {
    List<ButtonImages> allButtonImages = new ArrayList<>();
    ButtonImages buttonImages;

    public void  add(ButtonImages buttonImages) {
        allButtonImages.add(buttonImages);

    }

    public List<ButtonImages> pickUpOptions (ButtonImages answer, List<ButtonImages> allButtons, int n) {
        List<ButtonImages> copy = allButtons;
        copy.remove(answer);
        Collections.shuffle(copy);
        List<ButtonImages> options = copy.subList(0,n-1);
        options.add(answer);
        Collections.shuffle(options);
        return options;
    }
}
