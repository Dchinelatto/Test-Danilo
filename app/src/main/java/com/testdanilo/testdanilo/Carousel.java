package com.testdanilo.testdanilo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Carousel {

    public static final Integer THUMB_TYPE = 0;
    public static final Integer POSTER_TYPE = 1;

    private String title;
    @SerializedName("Items")
    private List<Movie> items;
    private String type;

    public Carousel() {
    }

    public Carousel(String title, List<Movie> items, String type) {
        this.title = title;
        this.items = items;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public List<Movie> getItems() {
        return items;
    }

    public String getType() {
        return type;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setItems(List<Movie> items) {
        this.items = items;
    }

    public void setType(String type) {
        this.type = type;
    }


    public int GetIntType(){

        int intType;

        if (type.equals("thumb")){

            intType = THUMB_TYPE;
        } else {

            intType = POSTER_TYPE;
        }


        return intType;
    }

    public static Movie parseJSON(String response){

        Gson gson = new GsonBuilder().create();
        Movie movie = gson.fromJson(response, Movie.class);
        return  movie;
    }
}
