package com.testdanilo.testdanilo;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class JsonParser {

    Context context;

    public JsonParser( Context context){

        this.context = context;
    }


    public List<Carousel> ParseJson(){

        String json = null;
        List<Carousel> carouselList = new ArrayList<>();

        try {
            InputStream is = context.getAssets().open("peliculas.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");

            Gson gson = new GsonBuilder().create();
            Carousel[] carouselArray = gson.fromJson(json, Carousel[].class);
            carouselList = Arrays.asList(carouselArray);

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        return carouselList;
    }

}
