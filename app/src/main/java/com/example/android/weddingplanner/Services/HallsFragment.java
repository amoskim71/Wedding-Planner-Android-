package com.example.android.weddingplanner.Services;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.weddingplanner.Items;
import com.example.android.weddingplanner.ItemsAdapter;
import com.example.android.weddingplanner.R;
import com.example.android.weddingplanner.networkUtils.DataLoader;
import com.example.android.weddingplanner.popupItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HallsFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<Items>> {
    /**
     * Constant value for the earthquake loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    public HallsFragment() {
        // Required empty public constructor
    }
    private static final int HallsLoaderID =1;
    private static final String TAG = HallsFragment.class.getSimpleName();
    ItemsAdapter Adapter;
    private static final String USGS_REQUEST_URL = "http://planners.herokuapp.com/api/halls";
    // to setEmptyView to list if there is no earthquakes
    private TextView emptyText;
    private View root;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         root = inflater.inflate(R.layout.halls,container,false);
        // to check connection with the internet
        ConnectivityManager cm =(ConnectivityManager)getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo!=null&&networkInfo.isConnected()) {
            // Get a reference to the LoaderManager, in order to interact with loaders.
            LoaderManager loaderManager = getLoaderManager();

            // Initialize the loader. Pass in the int ID constant defined above and pass in null for
            // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
            // because this activity implements the LoaderCallbacks interface).
            Log.i(TAG, "Test calling intent loader");
            loaderManager.initLoader(HallsLoaderID, null, this);
        }
        else
        {
            ProgressBar progressBar = root.findViewById(R.id.progressBar);
            progressBar.setVisibility(View.GONE);
            emptyText = root.findViewById(R.id.emptytext);
            emptyText.setText(R.string.no_internet_connection);




        }


         Adapter = new ItemsAdapter(getActivity(),R.layout.list_item , new ArrayList<Items>());
        // to make listview to hold empty text if there is no earthquakes
        emptyText = (TextView)root.findViewById(R.id.emptytext);
        GridView HallsView = (GridView) root.findViewById(R.id.GridHalls);
        HallsView.setAdapter(Adapter);

        HallsView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                popupItem popupitem= new popupItem();
                Items currentItem = Adapter.getItem(i);
                ImageView photo = view.findViewById(R.id.image);
               Bitmap bitmapImage=((BitmapDrawable)photo.getDrawable()).getBitmap();
                Log.i(TAG,photo.getDrawable()+"");
                popupitem.show(getFragmentManager(),null);
                popupitem.setName(currentItem.getName());
                popupitem.setPrice(currentItem.getPrice());
                popupitem.setImage(bitmapImage);
                popupitem.setLocation(currentItem.getLocation());
                popupitem.setCapacity(currentItem.getCapacity());
                popupitem.setSize(currentItem.getSize());
                popupitem.setBrand(currentItem.getBrand());
                popupitem.setColor(currentItem.getColor());
                popupitem.setPhone(currentItem.getPhone());


            }
        });


        return  root;
    }

    @Override
    public Loader<List<Items>> onCreateLoader(int id, Bundle args) {
        // Create a new loader for the given URL
        Log.i(TAG,"On create Loader called");
        // to get instance that point to default file that used by preference by given context
        DataLoader dataLoader =  new DataLoader(getContext(),USGS_REQUEST_URL);
        return dataLoader;
    }

    @Override
    public void onLoadFinished(Loader<List<Items>> loader, List<Items> data) {
        // Clear the adapter of previous earthquake data
        Log.i(TAG,"OnLoadFinished called");
        Adapter.clear();
        ProgressBar progressBar= (ProgressBar) root.findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        //  then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (data != null && !data.isEmpty()) {
            Adapter.addAll(data);
        }
        // set on onfinish metho to avoid to display in first featching data form the server
        else
          emptyText.setText(R.string.empty_halls);

    }

    @Override
    public void onLoaderReset(Loader<List<Items>> loader) {
        // Loader reset, so we can clear out our existing data.
        Log.i(TAG,"Test onloaderReset called");
        Adapter.clear();
    }
}
