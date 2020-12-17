package com.example.muiscaco.models;

public class Dios {
    private int id,image;
    private String title, descritpion;

    public Dios(int id, String title, String descritpion, int image) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.descritpion = descritpion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

}
