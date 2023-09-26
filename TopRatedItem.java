package com.example.fooddelimain;

import java.io.Serializable;

public class TopRatedItem implements Serializable {
    private int imageResource;
    private String food_category;
    private String food_name;
    private String food_price;


    public int getImageResource() {
        return imageResource;
    }

    public String getFood_category() {
        return food_category;
    }

    public String getFood_name() {
        return food_name;
    }

    public String getFood_price() {
        return food_price;
    }
    public TopRatedItem(int imageResource, String food_category, String food_name, String food_price) {
        this.imageResource = imageResource;
        this.food_category = food_category;
        this.food_name = food_name;
        this.food_price = food_price;
    }






}
