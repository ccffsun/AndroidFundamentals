package com.example.kidsLearningMap.TemplateClasses;

public class CardImages {

        private int puzzleCard;
        private int solvedCard;
        private ButtonImages buttonImages;
        private String cardItem;

        public CardImages(int puzzleCard, int solvedCard, String cardItem, ButtonImages buttonImages) {
            this.puzzleCard = puzzleCard;
            this.solvedCard = solvedCard;
            this.cardItem = cardItem;
            this.buttonImages = buttonImages;
        }

    public ButtonImages getButtonImages() {
        return buttonImages;
    }

    public void setButtonImages(ButtonImages buttonImages) {
        this.buttonImages = buttonImages;
    }

    public int getPuzzleCard() {
        return puzzleCard;
    }

    public void setPuzzleCard(int puzzleCard) {
        this.puzzleCard = puzzleCard;
    }

    public int getSolvedCard() {
        return solvedCard;
    }

    public void setSolvedCard(int solvedCard) {
        this.solvedCard = solvedCard;
    }

    public String getCardItem() {
        return cardItem;
    }

    public void setCardItem(String cardItem) {
        this.cardItem = cardItem;
    }
}
