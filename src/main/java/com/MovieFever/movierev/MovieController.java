package com.MovieFever.movierev;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movies>> allMovies(){
        return new ResponseEntity<List<Movies>>(movieService.movies(), HttpStatus.OK);
    }
    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movies>> getSingleMovies(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movies>>(movieService.singleMovie(imdbId),HttpStatus.OK);

    }
}

