package com.badr.hourimeche.ensakenitra.network;

import com.badr.hourimeche.ensakenitra.models.Galleries;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetGalleriesDataService {
    @GET("galleries")
    Call<Galleries> getGalleries();
}
