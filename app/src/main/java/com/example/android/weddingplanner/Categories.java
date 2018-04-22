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
        Intent hallsIntent = new Intent(this,Services.class);
        Bundle bundle = new Bundle();
        bundle.putInt("postion",0);
        hallsIntent.putExtras(bundle);
        startActivity(hallsIntent);

    }
    public void openSuits(View view) {

        Intent SuitsIntent = new Intent(this,Services.class);
        Bundle bundle = new Bundle();
        bundle.putInt("postion",2);
        SuitsIntent.putExtras(bundle);
        startActivity(SuitsIntent);

    }
    public void openPhotographer(View view)
    {
        Intent PhotographerIntent = new Intent(this,Services.class);
        Bundle bundle = new Bundle();
        bundle.putInt("postion",3);
        PhotographerIntent.putExtras(bundle);
        startActivity(PhotographerIntent);
    }



}
