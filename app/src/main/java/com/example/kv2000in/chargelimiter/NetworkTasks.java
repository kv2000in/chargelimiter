package com.example.kv2000in.chargelimiter;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

class NetworkTasks extends AsyncTask<String, Void, Integer> {

//can not run network taks on main thread and hence async task
    //makes a connection to the url
    //Param passed is ON or OFF
    //doesn't read the response - no need.

    protected Integer doInBackground(String... params) {
        HttpURLConnection urlConnection = null;

        try {

            URL url = new URL("http://192.168.1.205/" + params[0]);
            urlConnection = (HttpURLConnection) url.openConnection();
            //System.out.println(url);

        } catch (Exception ex) {

            Log.e("YOUR_APP_LOG_TAG", "I got an error", ex);

        }

        try {
            return urlConnection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    protected void onPostExecute(Integer result) {

        // TODO: do something with the feed
        // content.setText(result);
        



    }


}
