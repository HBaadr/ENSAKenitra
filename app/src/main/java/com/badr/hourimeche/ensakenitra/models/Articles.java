package com.badr.hourimeche.ensakenitra.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Articles {
    @SerializedName("news")
    private ArrayList<Article> articles;

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }
}
