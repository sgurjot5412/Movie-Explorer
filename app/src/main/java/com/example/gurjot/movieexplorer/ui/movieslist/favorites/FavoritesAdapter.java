package com.example.gurjot.movieexplorer.ui.movieslist.favorites;

import android.view.ViewGroup;

import com.example.gurjot.movieexplorer.data.local.model.Movie;
import com.example.gurjot.movieexplorer.ui.movieslist.MovieViewHolder;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author Gurjot Singh.
 */
public class FavoritesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Movie> mMoviesList;

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return MovieViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Movie movie = mMoviesList.get(position);
        ((MovieViewHolder) holder).bindTo(movie);
    }

    @Override
    public int getItemCount() {
        return mMoviesList != null ? mMoviesList.size() : 0;
    }

    public void submitList(List<Movie> movies) {
        mMoviesList = movies;
        notifyDataSetChanged();
    }
}
