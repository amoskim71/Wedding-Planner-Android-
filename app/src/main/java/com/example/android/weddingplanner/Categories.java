package com.example.android.weddingplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
    }

    public void openHalls(View view) {
        startActivity(new Intent(this,Services.class));
    }
    public void openSuits(View view) {

        startActivity(new Intent(this,Services.class));
    }
    public void openPhotographer(View view) {
        startActivity(new Intent(this,Services.class));
    }



}
