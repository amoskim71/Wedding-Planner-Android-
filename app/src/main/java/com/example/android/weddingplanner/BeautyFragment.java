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
public class BeautyFragment extends Fragment {


    public BeautyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.beauty,container,false);
        final ArrayList<Items> items = new ArrayList<>();
        items.add(new Items (R.mipmap.b1,"JINNIE Photography","99$"));
        items.add(new Items (R.mipmap.b2,"A Shot Photography","150$"));
        items.add(new Items (R.mipmap.b3,"ROSIE Photography","99$"));
        items.add(new Items (R.mipmap.b4,"FOTOVIDEO Photography","99$"));
        items.add(new Items (R.mipmap.b5,"Sarah Davis Photography", "120$"));
        items.add(new Items (R.mipmap.b6,"Karen Sane Photography", "80$"));
        items.add(new Items (R.mipmap.b7,"Dahlia Photography", "70$"));
        items.add(new Items (R.mipmap.b8,"Nature Potography", "85$"));
        items.add(new Items (R.mipmap.b9,"Green Photography", "90$"));
        items.add(new Items (R.mipmap.b10,"HIGH CONTRAST Photography","100$"));



        ItemsAdapter Adapter = new ItemsAdapter(getActivity(),R.layout.list_item , items);

        GridView BeautyView = (GridView) root.findViewById(R.id.GridBeauty);
        BeautyView.setAdapter(Adapter);
        final popupItem popupitem= new popupItem();
        BeautyView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
