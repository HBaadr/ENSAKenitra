package com.badr.hourimeche.ensakenitra.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.badr.hourimeche.ensakenitra.R;
import com.badr.hourimeche.ensakenitra.adapters.GalleryAdapter;
import com.badr.hourimeche.ensakenitra.models.Galleries;
import com.badr.hourimeche.ensakenitra.models.Gallery;
import com.badr.hourimeche.ensakenitra.network.GetGalleriesDataService;
import com.badr.hourimeche.ensakenitra.network.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GalleriesActivity extends AppCompatActivity {

    private GalleryAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galleries_actitiy);

        /*Create handle for the RetrofitInstance interface*/
        GetGalleriesDataService service = RetrofitInstance.getRetrofitInstance().create(GetGalleriesDataService.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<Galleries> call = service.getGalleries();

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<Galleries>() {
            @Override
            public void onResponse(Call<Galleries> call, Response<Galleries> response) {
                generateGalleryList(response.body().getGalleries());
            }

            @Override
            public void onFailure(Call<Galleries> call, Throwable t) {
                Toast.makeText(GalleriesActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }

        });
    }

    /*Method to generate List of employees using RecyclerView with custom adapter*/
    private void generateGalleryList(ArrayList<Gallery> galleryDataList) {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_galleries_list);

        adapter = new GalleryAdapter(galleryDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(GalleriesActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }

}
