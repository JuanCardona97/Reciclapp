package com.example.muiscaco;

public class Modulos {
    String title;
    String description;
    public int idResource;

    public Modulos(String title, int idResource){
        this.title=title;
        this.idResource=idResource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIdResource() {
        return idResource;
    }

    public void setIdResource(int idResource) {
        this.idResource = idResource;
    }

}
