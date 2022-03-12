package com.saifullahdar.assignment;


import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class Add implements Serializable {
    private String product_name,location,price, description, tags ;
    private Drawable image;

    public Add(String product_name, String location, String price, String description, Drawable image , String tags) {
        this.product_name = product_name;
        this.location = location;
        this.price = price;
        this.description = description;
        this.image = image;
        this.tags = tags;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }
}
