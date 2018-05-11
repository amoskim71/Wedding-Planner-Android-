package com.example.android.weddingplanner.networkUtils;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import com.example.android.weddingplanner.Items;

import java.net.URL;
import java.util.List;
/**
 * Loads a list of earthquakes by using an AsyncTask to perform the
 * network request to the given URL.
 */
public class DataLoader extends android.support.v4.content.AsyncTaskLoader<List<Items>> {
    /** Query URL */
private String  murl;
    private static final String  TAG = DataLoader.class.getSimpleName();
    public DataLoader(Context context, String  murl) {
        super(context);
        this.murl  = murl;
    }

    @Override
    protected void onStartLoading() {
        Log.i(TAG,"onstartLoading called");
        super.onStartLoading();
        forceLoad();
    }
    /**
     * This is on a background thread.
     */
    @Override
    public List<Items> loadInBackground() {
        if (murl==null)
            return null;
        // Perform the network request, parse the response, and extract a list of earthquakes.
        return QueryUtil.fetchData(murl);
    }
}
