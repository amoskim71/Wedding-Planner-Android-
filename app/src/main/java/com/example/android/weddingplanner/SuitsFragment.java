package com.example.android.weddingplanner;


import android.content.ClipData;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
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

        final ArrayList<Items> items = new ArrayList<>();
        items.add(new Items (R.mipmap.d1,"wedding dress","50,000 EGP"));
        items.add(new Items (R.mipmap.d2,"wedding dress","45,000 EGP"));
        items.add(new Items (R.mipmap.d3,"wedding dress","45,000 EGP"));
        items.add(new Items (R.mipmap.d4,"wedding dress","60,000"));
        items.add(new Items (R.mipmap.d5,"wedding dress", "65,000"));
        items.add(new Items (R.mipmap.d6,"wedding dress", "40,000"));
        items.add(new Items (R.mipmap.d7,"wedding dress", "80,000"));
        items.add(new Items (R.mipmap.d8,"wedding dress", "65,000"));
        items.add(new Items (R.mipmap.d9,"wedding dress", "60,000"));
        items.add(new Items (R.mipmap.d10,"wedding dress","51,000 EGP"));
        items.add(new Items (R.mipmap.d11,"wedding dress","23,000 EGP"));
        items.add(new Items (R.mipmap.d12,"wedding dress","10,000 EGP"));
        items.add(new Items (R.mipmap.s1,"suit","8,000 EGP"));
        items.add(new Items (R.mipmap.s2,"suit","4,000 EGP"));
        items.add(new Items (R.mipmap.s3,"suit","10,000 EGP"));
        items.add(new Items (R.mipmap.s4,"suit","15,000 EGP"));
        items.add(new Items (R.mipmap.s5,"suit","5,000 EGP"));
        items.add(new Items (R.mipmap.s6,"suit","7,000 EGP"));
        items.add(new Items (R.mipmap.s7,"suit","6,000 EGP"));
        items.add(new Items (R.mipmap.s8,"suit","2,000 EGP"));
        items.add(new Items (R.mipmap.s9,"suit","2,500 EGP"));
        items.add(new Items (R.mipmap.s10,"suit","6,500 EGP"));
        items.add(new Items (R.mipmap.s11,"suit","6,500 EGP"));
        items.add(new Items (R.mipmap.s12,"suit","6,500 EGP"));

        final ItemsAdapter Adapter = new ItemsAdapter(getActivity(),R.layout.list_item , items);



        GridView SuitsView = (GridView) root.findViewById(R.id.GridSuits);
        SuitsView.setAdapter(Adapter);
        final popupItem popupitem= new popupItem();
        SuitsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Items currentItem = items.get(i);
        popupitem.show(getFragmentManager(),null);
        popupitem.setName(currentItem.getName());
        popupitem.setPrice(currentItem.getPrice());
        popupitem.setImage(currentItem.getImage());
       

    }
});



       return  root;

    }


}
