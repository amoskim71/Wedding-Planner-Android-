package com.example.android.weddingplanner;


import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class popupItem extends DialogFragment {

   private static String name;
   private static String  price;
   private static Bitmap image;
   private static String capacity;
   private static String location;

    private static String phone;


    private static String color;
    private static String brand;
    private static String size;



    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View root = inflater.inflate(R.layout.fragment_popup_item, container, false);
        ImageView imageview =root.findViewById(R.id.popup_image);
         TextView nameview =root.findViewById(R.id.popup_name);

        LinearLayout pricelayout = root.findViewById(R.id.price_container);
        TextView priceview =root.findViewById(R.id.popup_price);

        LinearLayout capacityLayout = root.findViewById(R.id.capacity_container);
        TextView capacityview = root.findViewById(R.id.popup_capacity);
        LinearLayout locationLayout = root.findViewById(R.id.location_container);
        TextView locationview = root.findViewById(R.id.popup_location);

        LinearLayout sizelayout = root.findViewById(R.id.size_container);
        TextView sizeview = root.findViewById(R.id.popup_size);

        LinearLayout colorLayout = root.findViewById(R.id.color_container);
        TextView colorview = root.findViewById(R.id.popup_color);

        LinearLayout brandLayout= root.findViewById(R.id.brand_container);
        TextView brandview = root.findViewById(R.id.popup_brand);

        LinearLayout phoneLayout = root.findViewById(R.id.phone_container);
        TextView phoneview = root.findViewById(R.id.popup_phone);


        nameview.setText(name);
        imageview.setImageBitmap(image);

        if(price!=null)
        priceview.setText(price);
        else
            pricelayout.setVisibility(View.GONE);

        if(size!=null)
            sizeview.setText(size);
        else
            sizelayout.setVisibility(View.GONE);

        if(phone!=null)
            phoneview.setText(phone);
        else
           phoneLayout.setVisibility(View.GONE);
        if(brand!=null)
            brandview.setText(brand);
        else
            brandLayout.setVisibility(View.GONE);

        if(capacity!=null)
        capacityview.setText(capacity);
        else
            capacityLayout.setVisibility(View.GONE);
        if (location!=null)
        locationview.setText(location);
        else
            locationLayout.setVisibility(View.GONE);
        if(color!=null)
            colorview.setText(color);
        else
            colorLayout.setVisibility(View.GONE);

        return root;
    }

    public static void setName(String ItemName) {

        name=ItemName;
    }

    public static void setPrice(String Itemprice) {
      price=Itemprice;
    }

    public static void setImage(Bitmap image) {
        popupItem.image = image;
    }

    public static void setCapacity(String capacity) {
        popupItem.capacity = capacity;
    }

    public static void setLocation(String location) {
        popupItem.location = location;
    }

    public static void setPhone(String phone) {
        popupItem.phone = phone;
    }

    public static void setColor(String color) {
        popupItem.color = color;
    }

    public static void setBrand(String brand) {
        popupItem.brand = brand;
    }

    public static void setSize(String size) {
        popupItem.size = size;
    }
}
