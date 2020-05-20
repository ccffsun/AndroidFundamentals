package com.example.colourgame;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AllFruitImages {
    List<FruitImages> allFruitImages = new ArrayList<>();

    public void add(FruitImages fruitImages) {
        allFruitImages.add(fruitImages);
    }

    public void shuffleFruitImages() {
        Collections.shuffle(allFruitImages);
    }
}

