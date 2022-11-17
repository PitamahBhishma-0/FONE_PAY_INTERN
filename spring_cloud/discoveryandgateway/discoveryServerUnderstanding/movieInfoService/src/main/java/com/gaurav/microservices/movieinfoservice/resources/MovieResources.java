package com.gaurav.microservices.movieinfoservice.resources;

import com.gaurav.microservices.movieinfoservice.entity.Movie;
import com.gaurav.microservices.movieinfoservice.entity.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResources {
    @Value("814162a43cca09a07007f5f0d6fc0eac")
    private String apiKey;
    @Autowired
    RestTemplate restTemplate;


    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId){
        MovieSummary movieSummary=restTemplate.getForObject(
                "https://api.themoviedb.org/3/movie/"+movieId+ "?api_key="+ apiKey,MovieSummary.class
        );
        return new Movie(movieId,movieSummary.getTitle(),movieSummary.getOverview());
    }
}
