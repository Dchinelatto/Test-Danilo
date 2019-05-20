package com.testdanilo.testdanilo;

import com.google.gson.annotations.SerializedName;

public class Movie {

    private String title;
    @SerializedName("Url")
    private String url;
    private String video;

    public Movie() {
    }

    public Movie(String title, String url, String video) {
        this.title = title;
        this.url = url;
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getVideo() {
        return video;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setVideo(String video) {
        this.video = video;
    }
}
