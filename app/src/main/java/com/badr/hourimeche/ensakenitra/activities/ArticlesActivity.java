package com.badr.hourimeche.ensakenitra.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.badr.hourimeche.ensakenitra.R;
import com.badr.hourimeche.ensakenitra.adapters.ArticleAdapter;
import com.badr.hourimeche.ensakenitra.models.Article;
import com.badr.hourimeche.ensakenitra.models.Articles;
import com.badr.hourimeche.ensakenitra.network.GetArticlesDataService;
import com.badr.hourimeche.ensakenitra.network.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticlesActivity extends AppCompatActivity {

    private ArticleAdapter adapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);

        /*Create handle for the RetrofitInstance interface*/
        GetArticlesDataService service = RetrofitInstance.getRetrofitInstance().create(GetArticlesDataService.class);

        /*Call the method with parameter in the interface to get the employee data*/
        Call<Articles> call = service.getArticles();

        /*Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<Articles>() {
            @Override
            public void onResponse(Call<Articles> call, Response<Articles> response) {
                generateArticlesList(response.body().getArticles());
            }

            @Override
            public void onFailure(Call<Articles> call, Throwable t) {
                Toast.makeText(ArticlesActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();

            }

        });
    }

    /*Method to generate List of employees using RecyclerView with custom adapter*/
    private void generateArticlesList(ArrayList<Article> articleDataList) {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view_articles_list);

        adapter = new ArticleAdapter(articleDataList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ArticlesActivity.this);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
    }
}
