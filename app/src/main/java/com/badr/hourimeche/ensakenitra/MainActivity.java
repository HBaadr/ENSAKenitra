package com.badr.hourimeche.ensakenitra;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.badr.hourimeche.ensakenitra.adapters.RecyclerViewAdapter;
import com.badr.hourimeche.ensakenitra.models.ItemData;
import com.badr.hourimeche.ensakenitra.staticActivitys.ensak.ENSAK;
import com.badr.hourimeche.ensakenitra.staticActivitys.formations.FORMATIONS;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ArrayList<ItemData> villes = new ArrayList<>();
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;

    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

//        if (isNetworkAvailable(this)) {
//            progressDialog = new ProgressDialog(this);
//            progressDialog.setMessage("Veuillez attendre s'il vous plaît !!");
//            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//            progressDialog.show();
//            progressDialog.setCancelable(false);
//            recyclerView = (RecyclerView) findViewById(R.id.recycleV);
//            new doit().execute();
//        } else {
//            Toasty.error(this, "Vous devez disposer d'une connexion Internet !!", 50, true).show();
//        }

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        Intent intent = null;

        if (id == R.id.tab1) {
            intent = new Intent(this, ENSAK.class);
            intent.putExtra("title", getString(R.string.ensa_k));
        } else if (id == R.id.tab2) {
            intent = new Intent(this, FORMATIONS.class);
            intent.putExtra("title", getString(R.string.formations));
        } else if (id == R.id.tab3) {

        } else if (id == R.id.tab4) {

        } else if (id == R.id.tab5) {

        } else if (id == R.id.tab6) {

        } else if (id == R.id.tab7) {

        }
        startActivity(intent);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private class doit extends AsyncTask<Void, Void, Void> {
        ItemData p;

        @Override
        protected Void doInBackground(Void... voids) {
            try {

                for (int y = 1; y < 7; y++) {
                    Document doc = Jsoup.connect("http://ensa.uit.ac.ma/category/actualites/page/" + y).get();
                    Elements elements = doc.getElementsByClass("block-content");
                    for (int x = 0; x < 10; x++) {
                        Element element = doc.getElementsByTag("h1").get(x);
                        p = new ItemData();
                        p.setName(element.text());
                        p.setURL(elements.select("a").get(x).absUrl("href"));
                        villes.add(p);
                    }
                }

            } catch (IOException ignored) {
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(villes, MainActivity.this);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            recyclerView.setAdapter(recyclerViewAdapter);
            recyclerView.setItemAnimator(new DefaultItemAnimator());

            recyclerView.setHasFixedSize(true);
            recyclerView.setItemViewCacheSize(20);
            recyclerView.setDrawingCacheEnabled(true);
            recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
            progressDialog.dismiss();
        }
    }
}
