package com.testdanilo.testdanilo;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ParentRecyclerAdapter extends RecyclerView.Adapter<ParentRecyclerAdapter.ViewHolder>{


    private List<Carousel> carouselList;
    private static MovieReceiver movieReceiver;

    public ParentRecyclerAdapter(MovieReceiver movieReceiver){

        carouselList = new ArrayList<>();
        this.movieReceiver = movieReceiver;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout, parent, false);

        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        try {

            Carousel carousel = carouselList.get(position);

            ViewHolder viewHolder = (ViewHolder) holder;

            viewHolder.Bind(carousel);

        } catch (Exception e){

            Log.e("ADAPTER ERROR: " , " ON BIND VIEW HOLDER");
        }
    }

    @Override
    public int getItemCount() {
        return carouselList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;

        public ViewHolder(View itemView) {
            super(itemView);

            recyclerView = (RecyclerView) itemView.findViewById(R.id.child_recyclerview);
        }

        public void Bind(final Carousel carousel){

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false);

            recyclerView.setLayoutManager(layoutManager);



            final ChildRecyclerAdapter adapter = new ChildRecyclerAdapter(carousel.GetIntType());

            adapter.setClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Integer position = recyclerView.getChildAdapterPosition(view);

                    movieReceiver.receiveMovie(carousel.getItems().get(position));
                }
            });

            adapter.setMovieList(carousel.getItems());

            recyclerView.setAdapter(adapter);


        }
    }


    public void setCarouselList(List<Carousel> carouselList) {
        this.carouselList = carouselList;
    }

    public interface MovieReceiver {
        void receiveMovie(Movie movie);
    }
}
