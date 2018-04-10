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
public class PhotographerFragment extends Fragment {


    public PhotographerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_photographer,container,false);

        ArrayList<Items> items = new ArrayList<>();
        items.add(new Items (R.drawable.p1,"JINNIE Photography",null));
        items.add(new Items (R.drawable.p2,"A Shot Photography",null));
        items.add(new Items (R.drawable.p3,"ROSIE Photography",null));
        items.add(new Items (R.drawable.p4,"FOTOVIDEO Photography",null));
        items.add(new Items (R.drawable.p5,"Sarah Davis Photography", null));
        items.add(new Items (R.drawable.p6,"Karen Sane Photography", null));
        items.add(new Items (R.drawable.p7,"Dahlia Photography", null));
        items.add(new Items (R.drawable.p8,"Nature Potography", null));
        items.add(new Items (R.drawable.p9,"Green Photography", null));
        items.add(new Items (R.drawable.p10,"HIGH CONTRAST Photography",null));

        ItemsAdapter Adapter = new ItemsAdapter(getActivity(),R.layout.list_item , items);

        GridView PhotographerView = (GridView) root.findViewById(R.id.GridPhotographer);
        PhotographerView.setAdapter(Adapter);


        return  root;
    }

}
