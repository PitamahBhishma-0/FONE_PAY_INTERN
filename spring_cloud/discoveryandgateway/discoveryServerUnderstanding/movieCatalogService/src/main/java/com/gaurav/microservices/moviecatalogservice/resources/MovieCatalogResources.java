package com.gaurav.microservices.moviecatalogservice.resources;

import com.gaurav.microservices.moviecatalogservice.entity.CatalogItem;
import com.gaurav.microservices.moviecatalogservice.entity.Movie;
import com.gaurav.microservices.moviecatalogservice.entity.RatingMovie;
import com.gaurav.microservices.moviecatalogservice.entity.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResources {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    WebClient.Builder webClientBuilder;
    @RequestMapping("/{userId}")
    public List< CatalogItem > getCatalogItem(@PathVariable("userId") String userId){

//    restTemplate.getForObject("http://localhost:8082/movies/oebhai", Movie.class);
        UserRating userRating=restTemplate.getForObject("http://movie-rating-service/rating/users/"+userId, UserRating.class
                );
        return userRating.getUserRating().stream().map(rating->{
                    //Use of RestTemplate
                     Movie movie= restTemplate.getForObject("http://movie-info-service/movies/"+rating.getMovieId(), Movie.class);
            //Web Client

//                    Movie movie=webClientBuilder.build()
//                            .get()
//                            .uri("http://localhost:8082/movies/oebhai"+rating.getMovieId())
//                            .retrieve()
//                            .bodyToMono(Movie.class)
//                            .block();
                    return new CatalogItem(movie.getName(), "description",rating.getRating());
                } ).
                collect(Collectors.toList());
   /* return Collections.singletonList(
            new CatalogItem("Transformer","Description",5)
    );*/
    }
}
