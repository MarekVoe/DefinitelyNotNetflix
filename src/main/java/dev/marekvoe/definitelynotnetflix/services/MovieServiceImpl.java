package dev.marekvoe.definitelynotnetflix.services;

import dev.marekvoe.definitelynotnetflix.models.Movie;
import dev.marekvoe.definitelynotnetflix.repositories.IMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Objects;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    private IMovieRepository movieRepository; // Injekce MovieRepository dependency

    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        return (List<Movie>) movieRepository.findAll();
    }

    @Override
    public Movie updateMovie(Movie movie, Long movieID) {
        // TODO: IMPLEMENT UPDATE
        return null;
    }

    @Override
    public void deleteMovie(Long movieID) {
        movieRepository.deleteById(movieID);
    }
}
