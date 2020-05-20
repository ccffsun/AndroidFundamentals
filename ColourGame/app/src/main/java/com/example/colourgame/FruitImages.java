package com.example.colourgame;

import android.graphics.drawable.Drawable;


public class FruitImages {
    private int copyFruit;
    private int Fruit;
    private String color;

    public FruitImages(int copyFruit, int fruit, String color) {
        this.copyFruit = copyFruit;
        this.Fruit = fruit;
        this.color = color;

    }

    public int getCopyFruit() {
        return copyFruit;
    }

    public void setCopyFruit(int copyFruit) {
        this.copyFruit = copyFruit;
    }

    public int getFruit() {
        return Fruit;
    }

    public void setFruit(int fruit) {
        Fruit = fruit;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
