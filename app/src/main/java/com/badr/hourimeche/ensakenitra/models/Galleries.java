package com.badr.hourimeche.ensakenitra.models;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Galleries {
    @SerializedName("galeries")
    private ArrayList<Gallery> galleries;

    public ArrayList<Gallery> getGalleries() {
        return galleries;
    }

    public void setGalleries(ArrayList<Gallery> galleries) {
        this.galleries = galleries;
    }
}
