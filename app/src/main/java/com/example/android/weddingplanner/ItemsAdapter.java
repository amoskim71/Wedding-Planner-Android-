package com.example.android.weddingplanner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

/**
 * Created by Elesdody on 04-Apr-18.
 */

public class ItemsAdapter extends ArrayAdapter<Items> {
    public ItemsAdapter(@NonNull Context context, int resource, @NonNull List<Items> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View ListView = convertView;
        if(ListView==null)
        {

            ListView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item,parent,false);
        }

        Items Currentitem=getItem(position);


        ImageView imageView = (ImageView) ListView.findViewById(R.id.itemImage);
        Log.i("adapter",Currentitem.getImage()+"" );
        imageView.setImageResource(Currentitem.getImage());
        TextView name = (TextView) ListView.findViewById(R.id.name);
        TextView price =  (TextView) ListView.findViewById(R.id.price);

        name.setText(Currentitem.getName());
        price.setText(Currentitem.getPrice());

return ListView;
    }
}
