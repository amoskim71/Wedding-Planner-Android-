package com.example.android.weddingplanner;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HallsFragment extends Fragment {

    public HallsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.halls,container,false);

        final ArrayList<Items> items = new ArrayList<>();
        items.add(new Items (R.mipmap.h1,"Royal","50,000 EGP"));
        items.add(new Items (R.mipmap.h2,"Gold","45,000 EGP"));
        items.add(new Items (R.mipmap.h3,"Dream","45,000 EGP"));
        items.add(new Items (R.mipmap.h4,"Flowery outdoor","60,000"));
        items.add(new Items (R.mipmap.h5,"Whity outdoor", "65,000"));
        items.add(new Items (R.mipmap.h6,"Queen", "40,000"));
        items.add(new Items (R.mipmap.h7,"Shape of love", "70,000"));
        items.add(new Items (R.mipmap.h8,"White Rose outdoor", "65,000"));
        items.add(new Items (R.mipmap.h9,"S N G ", "100,000"));
        items.add(new Items (R.mipmap.h10,"Red Rose","40,000 EGP"));
        items.add(new Items (R.mipmap.h11,"Hall ", "100,000"));

        ItemsAdapter Adapter = new ItemsAdapter(getActivity(),R.layout.list_item , items);

        GridView HallsView = (GridView) root.findViewById(R.id.GridHalls);
        HallsView.setAdapter(Adapter);
        final popupItem popupitem= new popupItem();
        HallsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
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
