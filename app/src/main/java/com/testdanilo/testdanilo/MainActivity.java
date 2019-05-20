package com.testdanilo.testdanilo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ParentRecyclerAdapter.MovieReceiver{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.parent_recyclerview);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        final ParentRecyclerAdapter adapter = new ParentRecyclerAdapter(this);

        List<Carousel> carouselList = new JsonParser(this).ParseJson();

        adapter.setCarouselList(carouselList);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void receiveMovie(Movie movie) {

        if (movie.getVideo() != null){

            Intent intent = new Intent(this, VideoActivity.class);
            intent.putExtra(VideoActivity.VIDEO_URL, movie.getVideo());
            startActivity(intent);
        } else {

            Toast.makeText(this, "Video no disponible", Toast.LENGTH_SHORT).show();
        }
    }
}
