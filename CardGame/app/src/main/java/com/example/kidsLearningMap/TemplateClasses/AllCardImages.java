package com.example.kidsLearningMap.TemplateClasses;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllCardImages {
    List<CardImages> allCardImages = new ArrayList<>();

    public void add(CardImages cardImages) {
        allCardImages.add(cardImages);
    }

    public void shuffle() {
        Collections.shuffle(allCardImages);
    }
}
