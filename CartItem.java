package com.example.fooddelimain;

public class CartItem {
    public CartItem(String food_name, String ratings, String amount,String quantity) {
        this.food_name = food_name;
        this.ratings = ratings;
        this.amount = amount;
        this.quantity = quantity;
    }

    public String getFood_name() {
        return food_name;
    }

    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    private String food_name;
    private String ratings;
    private String amount;
    private String quantity;


    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
