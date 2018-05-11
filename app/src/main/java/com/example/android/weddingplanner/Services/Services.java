package com.example.android.weddingplanner.Services;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;


import com.example.android.weddingplanner.FragmentAdapter;
import com.example.android.weddingplanner.R;

public class Services extends AppCompatActivity {
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        FragmentPagerAdapter pagerAdapter =new FragmentAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
          tabLayout = (TabLayout)findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
        tabLayoutIcons();
        Bundle bundle =getIntent().getExtras();
switch (bundle.getInt("position"))
{
        case 0:
        viewPager.setCurrentItem(0);
        break;
    case 1:
        viewPager.setCurrentItem(1);
        break;
    case 2:
        viewPager.setCurrentItem(2);
        break;
    case 3:
        viewPager.setCurrentItem(3);
        break;
    }
}

    private void tabLayoutIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.halls_icon);
        tabLayout.getTabAt(1).setIcon(R.drawable.beauty_icon);
        tabLayout.getTabAt(2).setIcon(R.drawable.suits_dresses_icon);
        tabLayout.getTabAt(3).setIcon(R.drawable.photographer_icon);


    }

}
