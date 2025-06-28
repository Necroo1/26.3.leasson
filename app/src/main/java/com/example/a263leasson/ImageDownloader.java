package com.example.a263leasson;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class ImageDownloader extends AsyncTask <String,Integer, Bitmap> {

    @Override
    protected Bitmap doInBackground(String... strings) {
        String content_url = strings [0];
        Log.i("backgroud-task",content_url);
        Log.i("background-task","Estamos en el background");
        try {
            URL url = new URL(content_url);
            InputStream content = (InputStream) url.getContent();
            return BitmapFactory.decodeStream(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        Log.i("background-task", "Estamos en el background");
        //Qué hago con el bitmap?
        super.onPostExecute(bitmap);
    }
}
