package com.example.android.weddingplanner;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        ArrayList<Items> items = new ArrayList<>();
        items.add(new Items (R.drawable.h1,"Royal","50,000 EGP"));
        items.add(new Items (R.drawable.h2,"Gold","45,000 EGP"));
        items.add(new Items (R.drawable.h3,"Dream","45,000 EGP"));
        items.add(new Items (R.drawable.h4,"Flowery outdoor","60,000"));
        items.add(new Items (R.drawable.h5,"Whity outdoor", "65,000"));
        items.add(new Items (R.drawable.h6,"Queen", "40,000"));
        items.add(new Items (R.drawable.h7,"Shape of love", "70,000"));
        items.add(new Items (R.drawable.h8,"White Rose outdoor", "65,000"));
        items.add(new Items (R.drawable.h9,"S N G ", "100,000"));
        items.add(new Items (R.drawable.h11,"Red Rose","40,000 EGP"));

        ItemsAdapter Adapter = new ItemsAdapter(getActivity(),R.layout.list_item , items);

        GridView HallsView = (GridView) root.findViewById(R.id.GridHalls);
        HallsView.setAdapter(Adapter);












        return  root;
    }

}
