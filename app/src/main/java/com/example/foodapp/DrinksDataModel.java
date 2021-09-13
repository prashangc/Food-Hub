package com.example.foodapp;

public class DrinksDataModel {
    private int image;
    private String header,desc;

    DrinksDataModel(int image, String header, String desc){
        this.image = image;
        this.header = header;
        this.desc = desc;

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
