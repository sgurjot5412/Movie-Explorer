package com.example.gurjot.movieexplorer.data.local;

import android.content.Context;

import com.example.gurjot.movieexplorer.data.local.dao.CastsDao;
import com.example.gurjot.movieexplorer.data.local.dao.MoviesDao;
import com.example.gurjot.movieexplorer.data.local.dao.ReviewsDao;
import com.example.gurjot.movieexplorer.data.local.dao.TrailersDao;
import com.example.gurjot.movieexplorer.data.local.model.Cast;
import com.example.gurjot.movieexplorer.data.local.model.Converters;
import com.example.gurjot.movieexplorer.data.local.model.Movie;
import com.example.gurjot.movieexplorer.data.local.model.Review;
import com.example.gurjot.movieexplorer.data.local.model.Trailer;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

/**
 * The Room Database that manages a local database.
 *
 * @author Gurjot Singh.
 */
@Database(
        entities = {Movie.class, Trailer.class, Cast.class, Review.class},
        version = 1,
        exportSchema = false)
@TypeConverters(Converters.class)
public abstract class MoviesDatabase extends RoomDatabase {

    public static final String DATABASE_NAME = "Movies.db";

    private static MoviesDatabase INSTANCE;

    private static final Object sLock = new Object();

    public abstract MoviesDao moviesDao();

    public abstract TrailersDao trailersDao();

    public abstract CastsDao castsDao();

    public abstract ReviewsDao reviewsDao();

    public static MoviesDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = buildDatabase(context);
            }
            return INSTANCE;
        }
    }

    private static MoviesDatabase buildDatabase(final Context context) {
        return Room.databaseBuilder(
                context.getApplicationContext(),
                MoviesDatabase.class,
                DATABASE_NAME).build();
    }
}
