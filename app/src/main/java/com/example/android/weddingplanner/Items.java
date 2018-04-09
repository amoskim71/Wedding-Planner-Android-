package com.example.android.weddingplanner;

/**
 * Created by Elesdody on 04-Apr-18.
 */

public class Items {
    private int Image;
    private String Name;
    private  String price;

    public Items(int image, String name, String price) {
        Image = image;
        Name = name;
        this.price = price;
    }

    public int getImage() {
        return Image;
    }

    public String getName() {
        return Name;
    }

    public String getPrice() {
        return price;
    }
}
