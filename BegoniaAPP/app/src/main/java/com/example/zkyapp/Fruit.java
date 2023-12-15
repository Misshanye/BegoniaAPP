package com.example.zkyapp;

public class Fruit {
    private int imageId;
    private String fruitName;

    public Fruit(String fruitName,int imageId)
    {
        this.fruitName=fruitName;
        this.imageId=imageId;
    }
    public String getFruitName() {
        return fruitName;
    }

    public int getImageId() {
        return imageId;
    }
}
