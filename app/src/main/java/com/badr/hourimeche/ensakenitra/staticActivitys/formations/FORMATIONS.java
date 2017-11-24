package com.badr.hourimeche.ensakenitra.staticActivitys.formations;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.badr.hourimeche.ensakenitra.MainActivity;
import com.badr.hourimeche.ensakenitra.R;
import com.badr.hourimeche.ensakenitra.staticActivitys.ensak.ENSAK;

public class FORMATIONS extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formations);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        Intent intent = null;
        if (id == R.id.tab1)      intent = new Intent(this, ENSAK.class);
        else if (id == R.id.tab2) intent = new Intent(this, FORMATIONS.class);
        else if (id == R.id.tab3) intent = new Intent(this, MainActivity.class);
        else if (id == R.id.tab4) intent = new Intent(this, MainActivity.class);
        else if (id == R.id.tab5) intent = new Intent(this, MainActivity.class);
        else if (id == R.id.tab6) intent = new Intent(this, MainActivity.class);
        else if (id == R.id.tab7) intent = new Intent(this, MainActivity.class);
        startActivity(intent);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void but1(View view) {
        Intent intent = new Intent(this, MainFORMATIONS.class);
        intent.putExtra("num", 1);
        startActivity(intent);
    }

    public void but2(View view) {
        Intent intent = new Intent(this, MainFORMATIONS.class);
        intent.putExtra("num", 2);
        startActivity(intent);
    }

    public void but3(View view) {
        Intent intent = new Intent(this, MainFORMATIONS.class);
        intent.putExtra("num", 3);
        startActivity(intent);
    }

    public void but4(View view) {
        Intent intent = new Intent(this, MainFORMATIONS.class);
        intent.putExtra("num", 4);
        startActivity(intent);
    }

    public void but5(View view) {
        Intent intent = new Intent(this, MainFORMATIONS.class);
        intent.putExtra("num", 5);
        startActivity(intent);
    }

    public void but6(View view) {
        Intent intent = new Intent(this, MainFORMATIONS.class);
        intent.putExtra("num", 6);
        startActivity(intent);
    }
}
