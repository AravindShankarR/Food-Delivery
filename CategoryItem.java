package com.example.fooddelimain;

public class CategoryItem {
    private int mImageResource;

    public String getText1() {
        return mtext1;
    }

    private String mtext1;


    public int getImageResource() {
        return mImageResource;
    }

    public CategoryItem(int ImageResource,String text1){
        mImageResource = ImageResource;
        mtext1 = text1;

    }
}
