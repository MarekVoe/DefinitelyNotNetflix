package dev.marekvoe.definitelynotnetflix.services;

import dev.marekvoe.definitelynotnetflix.models.Movie;

import java.util.List;

public interface IMovieService {
    Movie saveMovie(Movie movie);
    List<Movie> getAllMovies();
    Movie updateMovie(Movie movie, int movieID);
    void deleteMovie(int movieID);
}
