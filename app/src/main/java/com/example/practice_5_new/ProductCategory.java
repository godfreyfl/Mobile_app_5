package com.example.practice_5_new;

public class ProductCategory {
    private String name;
    private int imageResource;

    public ProductCategory(String name, int imageResource) {
        this.name = name;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public int getImageResource() {
        return imageResource;
    }
}


