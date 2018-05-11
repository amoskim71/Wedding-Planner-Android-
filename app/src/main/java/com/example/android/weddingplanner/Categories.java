package com.example.android.weddingplanner;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.android.weddingplanner.Services.Services;

public class Categories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
    }

    public void openHalls(View view) {
        Intent hallsIntent = new Intent(this,Services.class);
        Bundle bundle = new Bundle();
        bundle.putInt("position",0);
        hallsIntent.putExtras(bundle);
        startActivity(hallsIntent);

    }
    public void openSuits(View view) {

        Intent SuitsIntent = new Intent(this,Services.class);
        Bundle bundle = new Bundle();
        bundle.putInt("position",2);
        SuitsIntent.putExtras(bundle);
        startActivity(SuitsIntent);

    }
    public void openPhotographer(View view)
    {
        Intent PhotographerIntent = new Intent(this,Services.class);
        Bundle bundle = new Bundle();
        bundle.putInt("position",3);
        PhotographerIntent.putExtras(bundle);
        startActivity(PhotographerIntent);
    }


    public void openBeauty(View view) {
        Intent BeautyIntent = new Intent(this,Services.class);
        Bundle bundle = new Bundle();
        bundle.putInt("position",1);
        BeautyIntent.putExtras(bundle);
        startActivity(BeautyIntent);

    }
}
