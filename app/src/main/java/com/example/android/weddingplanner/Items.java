package com.example.android.weddingplanner;

/**
 * Created by Elesdody on 04-Apr-18.
 */

public class Items {
    private String Image_Url;
    private String Name;
    private  String price;
    private String capacity;
    private String location;
    private String phone;
    private String size;


    private String color;
    private String brand;

    public Items(String image_Url, String name,String size, String price, String capacity, String location, String phone, String color, String brand) {
        Image_Url = image_Url;
        Name = name;
        this.price = price;
        this.capacity = capacity;
        this.location = location;
        this.phone = phone;
        this.color = color;
        this.brand = brand;
        this.size= size;
    }



    public String getImage_Url() {
        return Image_Url;
    }

    public String getName() {
        return Name;
    }

    public String getPrice() {
        return price;
    }

    public String getCapacity() {
        return capacity;
    }

    public String getLocation() {
        return location;
    }
    public String getPhone() {
        return phone;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }
    public String getSize(){
        return size;
    }
}
