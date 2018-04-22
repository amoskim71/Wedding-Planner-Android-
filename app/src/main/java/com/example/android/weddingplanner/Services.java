package com.example.android.weddingplanner;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;

public class Services extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        FragmentPagerAdapter pagerAdapter =new FragmentAdapter(this,getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        TabLayout  tabLayout = (TabLayout)findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);
        Bundle bundle =getIntent().getExtras();
switch (bundle.getInt("postion"))
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

}
