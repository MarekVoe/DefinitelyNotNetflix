package dev.marekvoe.definitelynotnetflix.controllers;

import dev.marekvoe.definitelynotnetflix.models.Movie;
import dev.marekvoe.definitelynotnetflix.services.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private IMovieService movieService;

    @GetMapping("/getAll")
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
}
