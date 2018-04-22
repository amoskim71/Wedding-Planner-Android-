package com.example.android.weddingplanner;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class popupItem extends DialogFragment {

   private static String name;
   private static String  price;
   private static int image;


    public popupItem() {


    }

    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View root = inflater.inflate(R.layout.fragment_popup_item, container, false);
         TextView nameview =root.findViewById(R.id.popup_name);
        TextView priceview =root.findViewById(R.id.popup_price);
        ImageView imageview =root.findViewById(R.id.popup_image);
        nameview.setText(name);
        priceview.setText(price);
        imageview.setImageResource(image);


        return root;
    }

    public static void setName(String ItemName) {

        name=ItemName;
    }

    public static void setPrice(String Itemprice) {
      price=Itemprice;
    }

    public static void setImage(int Itemimage) {
        image=Itemimage;

    }


}
