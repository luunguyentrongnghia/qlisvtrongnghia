package com.google.recycleview;

public class Item {
    private int resourceImage;
    private String name;

    public Item(int resourceImage, String name) {
        this.resourceImage = resourceImage;
        this.name = name;
    }

    public int getResourceImage() {
        return resourceImage;
    }

    public void setResourceImage(int resourceImage) {
        this.resourceImage = resourceImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
