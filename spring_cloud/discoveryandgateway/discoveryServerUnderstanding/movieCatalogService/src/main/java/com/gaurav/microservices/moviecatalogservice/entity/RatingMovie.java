package com.gaurav.microservices.moviecatalogservice.entity;

public class RatingMovie {
    private String movieId;
    private int rating;

    public RatingMovie() {
    }

    public RatingMovie(String movieId, int rating) {
        this.movieId = movieId;
        this.rating = rating;
    }

    public String getMovieId() {
        return movieId;
    }

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
