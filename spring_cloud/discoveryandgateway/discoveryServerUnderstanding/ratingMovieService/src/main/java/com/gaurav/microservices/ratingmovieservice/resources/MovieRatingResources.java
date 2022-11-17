package com.gaurav.microservices.ratingmovieservice.resources;

import com.gaurav.microservices.ratingmovieservice.entity.RatingMovie;
import com.gaurav.microservices.ratingmovieservice.entity.UserRating;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/rating")

public class MovieRatingResources {
    @RequestMapping("/{movieId}")
    public RatingMovie getRating(@PathVariable("movieId") String movieId){
    return new RatingMovie(movieId,9);
    }

    @RequestMapping("users/{userId}")
    public UserRating getRatingMovieList(@PathVariable("userId") String userId){
        List<RatingMovie> ratings= Arrays.asList(
                new RatingMovie("0001",5),
                new RatingMovie("0002",6)
        );
        UserRating userRating=new UserRating();
        userRating.setUserRating(ratings);
        return userRating;
    }
}
