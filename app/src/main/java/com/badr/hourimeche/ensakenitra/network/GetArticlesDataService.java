package com.badr.hourimeche.ensakenitra.network;


import com.badr.hourimeche.ensakenitra.models.Articles;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetArticlesDataService {
    @GET("articles")
    Call<Articles> getArticles();
}
