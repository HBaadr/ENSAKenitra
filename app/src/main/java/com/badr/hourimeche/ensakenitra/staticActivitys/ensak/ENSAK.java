package com.badr.hourimeche.ensakenitra.staticActivitys.ensak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.badr.hourimeche.ensakenitra.R;

public class ENSAK extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ensak);
        Intent intent = getIntent();
        setTitle(intent.getStringExtra("title"));
    }

    public void but1(View view) {
        Intent intent = new Intent(this, MainENSAK.class);
        intent.putExtra("num", 1);
        startActivity(intent);
    }

    public void but2(View view) {
        Intent intent = new Intent(this, MainENSAK.class);
        intent.putExtra("num", 2);
        startActivity(intent);
    }

    public void but3(View view) {
        Intent intent = new Intent(this, MainENSAK.class);
        intent.putExtra("num", 3);
        startActivity(intent);
    }

    public void but4(View view) {
        Intent intent = new Intent(this, MainENSAK.class);
        intent.putExtra("num", 4);
        startActivity(intent);
    }

    public void but5(View view) {
        Intent intent = new Intent(this, MainENSAK.class);
        intent.putExtra("num", 5);
        startActivity(intent);
    }

    public void but6(View view) {
        Intent intent = new Intent(this, MainENSAK.class);
        intent.putExtra("num", 6);
        startActivity(intent);
    }
}
