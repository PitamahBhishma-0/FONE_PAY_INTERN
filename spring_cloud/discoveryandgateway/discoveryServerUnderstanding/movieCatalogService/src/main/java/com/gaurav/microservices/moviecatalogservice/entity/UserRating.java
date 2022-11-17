package com.gaurav.microservices.moviecatalogservice.entity;

import java.util.List;

public class UserRating {
    private List<RatingMovie > userRating;

    public UserRating() {
    }

    public UserRating(List< RatingMovie > userRating) {
        this.userRating = userRating;
    }

    public List< RatingMovie > getUserRating() {
        return userRating;
    }

    public void setUserRating(List< RatingMovie > userRating) {
        this.userRating = userRating;
    }
}
