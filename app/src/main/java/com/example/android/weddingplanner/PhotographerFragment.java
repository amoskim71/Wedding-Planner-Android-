package com.example.android.weddingplanner;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhotographerFragment extends Fragment {


    public PhotographerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_photographer,container,false);

        final ArrayList<Items> items = new ArrayList<>();
        items.add(new Items (R.mipmap.p1,"JINNIE Photography","10,000 EGP"));
        items.add(new Items (R.mipmap.p2,"A Shot Photography","5,000 EGP"));
        items.add(new Items (R.mipmap.p3,"ROSIE Photography","3,000 EGP"));
        items.add(new Items (R.mipmap.p4,"FOTOVIDEO Photography","2,500 EGP"));
        items.add(new Items (R.mipmap.p5,"Sarah Davis Photography", "15,000 EGP"));
        items.add(new Items (R.mipmap.p6,"Karen Sane Photography", "10,000 EGP"));
        items.add(new Items (R.mipmap.p7,"Dahlia Photography", "9,000 EGP"));
        items.add(new Items (R.mipmap.p8,"Nature Potography", "7,000 EGP"));
        items.add(new Items (R.mipmap.p9,"Green Photography", "5,000 EGP"));
        items.add(new Items (R.mipmap.p10,"HIGH CONTRAST Photography","10,000 EGP"));
        items.add(new Items (R.mipmap.p11,"HIGH CONTRAST Photography","3,000 EGP"));


        ItemsAdapter Adapter = new ItemsAdapter(getActivity(),R.layout.list_item , items);

        GridView PhotographerView = (GridView) root.findViewById(R.id.GridPhotographer);
        PhotographerView.setAdapter(Adapter);
        final popupItem popupitem= new popupItem();
        PhotographerView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
