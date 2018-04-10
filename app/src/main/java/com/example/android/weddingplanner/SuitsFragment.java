package com.example.android.weddingplanner;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SuitsFragment extends Fragment {


    public SuitsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View root = inflater.inflate(R.layout.activity_suits,container,false);

        ArrayList<Items> items = new ArrayList<>();
        items.add(new Items (R.drawable.d1,"wedding dress","50,000 EGP"));
        items.add(new Items (R.drawable.d2,"wedding dress","45,000 EGP"));
        items.add(new Items (R.drawable.d3,"wedding dress","45,000 EGP"));
        items.add(new Items (R.drawable.d4,"wedding dress","60,000"));
        items.add(new Items (R.drawable.d5,"wedding dress", "65,000"));
        items.add(new Items (R.drawable.d6,"wedding dress", "40,000"));
        items.add(new Items (R.drawable.d7,"wedding dress", "80,000"));
        items.add(new Items (R.drawable.d8,"wedding dress", "65,000"));
        items.add(new Items (R.drawable.d9,"wedding dress", "60,000"));
        items.add(new Items (R.drawable.d10,"wedding dress","51,000 EGP"));
        items.add(new Items (R.drawable.d11,"wedding dress","23,000 EGP"));
        items.add(new Items (R.drawable.d12,"wedding dress","10,000 EGP"));
        items.add(new Items (R.drawable.s1,"suit","8,000 EGP"));
        items.add(new Items (R.drawable.s2,"suit","4,000 EGP"));
        items.add(new Items (R.drawable.s3,"suit","10,000 EGP"));
        items.add(new Items (R.drawable.s4,"suit","15,000 EGP"));
        items.add(new Items (R.drawable.s5,"suit","5,000 EGP"));
        items.add(new Items (R.drawable.s6,"suit","7,000 EGP"));
        items.add(new Items (R.drawable.s7,"suit","6,000 EGP"));
        items.add(new Items (R.drawable.s8,"suit","2,000 EGP"));
        items.add(new Items (R.drawable.s9,"suit","2,500 EGP"));
        items.add(new Items (R.drawable.s10,"suit","6,500 EGP"));

        ItemsAdapter Adapter = new ItemsAdapter(getActivity(),R.layout.list_item , items);

        GridView SuitsView = (GridView) root.findViewById(R.id.GridSuits);
        SuitsView.setAdapter(Adapter);

       return  root;

    }

}
