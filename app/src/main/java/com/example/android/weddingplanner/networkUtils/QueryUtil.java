package com.example.android.weddingplanner.networkUtils;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;

import com.example.android.weddingplanner.Items;
import com.example.android.weddingplanner.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.Buffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class QueryUtil {
    private static final String TAG = QueryUtil.class.getSimpleName();

    private QueryUtil() {
    }

    public static List<Items> fetchData(String RequestUrl) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //create url object
        URL url = createUrl(RequestUrl);
        Log.i(TAG, "fetchData called");
        String jsonResponse = null;
        // Perform HTTP request to the URL and receive a JSON response back
        try {
            jsonResponse = makeHttpRequest(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Uri uri =null;
        try {
             uri = Uri.parse(url.toURI().toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        String Service = uri.getLastPathSegment();
        List<Items>Data= new ArrayList<>();
        switch (Service)
        {
            case "beauty":
                Data = extractBeautyData(jsonResponse);
                break;
            case "halls":
               Data = extractHallsData(jsonResponse);
                break;
            case "fashion":
                Data = extractFashionData(jsonResponse);
                break;
            case "photographers":
                    Data =extractPhotographerData(jsonResponse);
                break;





        }

return Data;
    }


    /**
     * Returns new URL object from the given string URL.
     */
    private static URL createUrl(String requestUrl) {
        URL url = null;
        try {
            url = new URL(requestUrl);
        } catch (MalformedURLException e) {
            Log.e(TAG, "Error on creating url");
        }
        return url;
    }

    /**
     * Make an HTTP request to the given URL and return a String as the response.
     */
    private static String makeHttpRequest(URL url) throws IOException {

        String jsonResponse = "";
        if (url == null)
            return jsonResponse;
        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;

        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setConnectTimeout(1000);
            urlConnection.setReadTimeout(15000);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();
            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);

            } else
                Log.e(TAG, "Error Response Code " + urlConnection.getResponseCode());


        } catch (IOException e) {
            Log.e(TAG, "Problem receiving data jsonResponse result", e);
        } finally {
            if (urlConnection != null)
                urlConnection.disconnect();
            if (inputStream != null)
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();
        }

        return jsonResponse;
    }

    /**
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */
    @NonNull
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line= reader.readLine();
            }


        }
        return output.toString();


    }

     private static List<Items> extractHallsData(String jsonResponse) {
        if (TextUtils.isEmpty(jsonResponse))
            return null;
        // Create an empty ArrayList that we can start adding data to
        ArrayList<Items> data = new ArrayList<>();

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            // TODO: Parse the response given by the SAMPLE_JSON_RESPONSE string and
            // build up a list of data objects with the corresponding data.
            JSONObject Root = new JSONObject(jsonResponse);
            String image_url = Root.getString("image_url");
            JSONArray Data = Root.getJSONArray("data");
            for (int i = 0; i < Data.length(); i++) {
                JSONObject object = Data.getJSONObject(i);
                String name = object.getString("name");
                int Price = object.getInt("price");
                int Capacity = object.getInt("capacity");
                String Location = object.getString("city");
                String Image = object.getString("image");
                data.add(new Items(image_url+Image,
                        name + "",
                        null,
                        Price + "",
                        Capacity+"",
                        Location,
                        null,
                        null,
                        null));


            }
            return data;
        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the data JSON results", e);
        }

        return data;
    }
    private static List<Items> extractBeautyData(String jsonResponse) {
        if (TextUtils.isEmpty(jsonResponse))
            return null;
        // Create an empty ArrayList that we can start adding data to
        ArrayList<Items> data = new ArrayList<>();

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            // TODO: Parse the response given by the SAMPLE_JSON_RESPONSE string and
            // build up a list of data objects with the corresponding data.
            JSONObject Root = new JSONObject(jsonResponse);
            String image_url = Root.getString("image_url");
            JSONArray Data = Root.getJSONArray("data");
            for (int i = 0; i < Data.length(); i++) {
                JSONObject object = Data.getJSONObject(i);
                String name = object.getString("name");
                 String phone = object.getString("phone");
                String Location = object.getString("city");
                String Image = object.getString("image");
                data.add(new Items(image_url+Image,
                        name,
                        null,
                        null ,
                        null,
                        Location,
                        phone,
                        null,
                        null));


            }
            return data;
        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the data JSON results", e);
        }

        return data;
    }
    private static List<Items> extractFashionData(String jsonResponse) {
        if (TextUtils.isEmpty(jsonResponse))
            return null;
        // Create an empty ArrayList that we can start adding data to
        ArrayList<Items> data = new ArrayList<>();

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            // TODO: Parse the response given by the SAMPLE_JSON_RESPONSE string and
            // build up a list of data objects with the corresponding data.
            JSONObject Root = new JSONObject(jsonResponse);
            String image_url = Root.getString("image_url");
            JSONArray Data = Root.getJSONArray("data");
            for (int i = 0; i < Data.length(); i++) {
                JSONObject object = Data.getJSONObject(i);
                String name = object.getString("type");
                int Price = object.getInt("price");
                String size = object.getString("size");
                String Location = object.getString("city");
                String Image = object.getString("image");
                String color = object.getString("color");
                String brand = object.getString("brand");
                data.add(new Items(image_url+Image,
                        name,
                        size,
                        Price+"" ,
                        null,
                        Location,
                        null,
                        color,
                        brand));


            }
            return data;
        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the data JSON results", e);
        }

        return data;
    }
    private static List<Items> extractPhotographerData(String jsonResponse) {
        if (TextUtils.isEmpty(jsonResponse))
            return null;
        // Create an empty ArrayList that we can start adding data to
        ArrayList<Items> data = new ArrayList<>();

        // Try to parse the SAMPLE_JSON_RESPONSE. If there's a problem with the way the JSON
        // is formatted, a JSONException exception object will be thrown.
        // Catch the exception so the app doesn't crash, and print the error message to the logs.
        try {

            // TODO: Parse the response given by the SAMPLE_JSON_RESPONSE string and
            // build up a list of data objects with the corresponding data.
            JSONObject Root = new JSONObject(jsonResponse);
            String image_url = Root.getString("image_url");
            JSONArray Data = Root.getJSONArray("data");
            for (int i = 0; i < Data.length(); i++) {
                JSONObject object = Data.getJSONObject(i);
                String name = object.getString("name");
                int Price = object.getInt("wage");
                String Location = object.getString("location");
                String Image = object.getString("logo");
                String phone = object.getString("number");
                data.add(new Items(image_url+Image,
                        name,
                        null,
                        Price+"" ,
                        null,
                        Location,
                        phone,
                        null,
                        null));



            }
            return data;
        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the data JSON results", e);
        }

        return data;
    }
}
