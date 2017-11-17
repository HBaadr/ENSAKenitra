package com.badr.hourimeche.ensakenitra.staticActivitys.formations;

import android.content.Intent;
import android.graphics.Color;
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
import android.widget.Button;

import com.badr.hourimeche.ensakenitra.R;
import com.badr.hourimeche.ensakenitra.staticActivitys.ensak.ENSAK;
import com.badr.hourimeche.ensakenitra.staticActivitys.formations.fragements.Fragment1;
import com.badr.hourimeche.ensakenitra.staticActivitys.formations.fragements.Fragment2;
import com.badr.hourimeche.ensakenitra.staticActivitys.formations.fragements.Fragment3;
import com.badr.hourimeche.ensakenitra.staticActivitys.formations.fragements.Fragment4;
import com.badr.hourimeche.ensakenitra.staticActivitys.formations.fragements.Fragment5;
import com.badr.hourimeche.ensakenitra.staticActivitys.formations.fragements.Fragment6;

public class MainFORMATIONS extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    int str;
    Button button, exbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_formations);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        Intent intent = getIntent();
        str = intent.getIntExtra("num", 1);

        fragments(str, "add");
    }@SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        Intent intent = null;

        if (id == R.id.tab1) {
            intent = new Intent(this, ENSAK.class);
        } else if (id == R.id.tab2) {
            intent = new Intent(this, FORMATIONS.class);
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

    int fragments(int num, String str) {
        if (exbutton != null)
            exbutton.setBackgroundColor(Color.WHITE);
        int w = 0, v = 0;
        switch (num) {
            case 1:
                v = getSupportFragmentManager().beginTransaction().add(R.id.container, new Fragment1(), "fragment_1").commit();
                w = getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment1(), "fragment_1").commit();
                button = (Button) findViewById(R.id.bt1);
                break;
            case 2:
                v = getSupportFragmentManager().beginTransaction().add(R.id.container, new Fragment2(), "fragment_2").commit();
                w = getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment2(), "fragment_2").commit();
                button = (Button) findViewById(R.id.bt2);
                break;
            case 3:
                v = getSupportFragmentManager().beginTransaction().add(R.id.container, new Fragment3(), "fragment_3").commit();
                w = getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment3(), "fragment_3").commit();
                button = (Button) findViewById(R.id.bt3);
                break;
            case 4:
                v = getSupportFragmentManager().beginTransaction().add(R.id.container, new Fragment4(), "fragment_4").commit();
                w = getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment4(), "fragment_4").commit();
                button = (Button) findViewById(R.id.bt4);
                break;
            case 5:
                v = getSupportFragmentManager().beginTransaction().add(R.id.container, new Fragment5(), "fragment_5").commit();
                w = getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment5(), "fragment_5").commit();
                button = (Button) findViewById(R.id.bt5);
                break;
            case 6:
                v = getSupportFragmentManager().beginTransaction().add(R.id.container, new Fragment6(), "fragment_6").commit();
                w = getSupportFragmentManager().beginTransaction().replace(R.id.container, new Fragment6(), "fragment_6").commit();
                button = (Button) findViewById(R.id.bt6);
                break;
        }
        button.setBackgroundColor(Color.CYAN);
        exbutton = button;
        if (str == "add")
            return v;
        else
            return w;
    }

    public void bt1(View view) {
        fragments(1, "replace");
    }

    public void bt2(View view) {
        fragments(2, "replace");
    }

    public void bt3(View view) {
        fragments(3, "replace");
    }

    public void bt4(View view) {
        fragments(4, "replace");
    }

    public void bt5(View view) {
        fragments(5, "replace");
    }

    public void bt6(View view) {
        fragments(6, "replace");
    }
}
