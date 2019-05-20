package com.testdanilo.testdanilo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ChildRecyclerAdapter extends RecyclerView.Adapter<ChildRecyclerAdapter.ViewHolder> {



    private List<Movie> movieList;
    private View.OnClickListener clickListener;
    private int layoutType;

    public ChildRecyclerAdapter(int layoutType){

        movieList = new ArrayList<>();
        this.layoutType = layoutType;
    }

    @NonNull
    @Override
    public ChildRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        int layout;

        if (layoutType == Carousel.THUMB_TYPE){

            layout = R.layout.thumb_layout;
        } else {

            layout = R.layout.poster_layout;
        }

        View view = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);

        view.setOnClickListener(this.clickListener);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ChildRecyclerAdapter.ViewHolder holder, int position) {

        try {

            Movie movie = movieList.get(position);

            ViewHolder viewHolder = (ViewHolder) holder;

            viewHolder.Bind(movie);

        } catch (Exception e){

            Log.e("ADAPTER ERROR: " , " ON BIND VIEW HOLDER");
        }
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView titleText;
        public ImageView posterImage;

        public ViewHolder(View itemView) {
            super(itemView);

            titleText = (TextView) itemView.findViewById(R.id.textView);
            posterImage = (ImageView) itemView.findViewById(R.id.imageView);
        }

        public void Bind(final Movie movie){

            titleText.setText(movie.getTitle());
            posterImage.setImageResource(R.drawable.ic_launcher_background);
            Picasso.get()
                    .load(movie.getUrl())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(posterImage);
        }
    }

    public void setClickListener(View.OnClickListener clickListener) {
        this.clickListener = clickListener;
    }

    public void setMovieList(List<Movie> movieList) {
        this.movieList = movieList;
    }
}
