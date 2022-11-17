package com.gaurav.microservices.ratingmovieservice.entity;

import java.util.Arrays;
import java.util.List;

public class UserRating {
    private List<RatingMovie > userRating;
    private String userId;

    public UserRating() {
    }

    public UserRating(List< RatingMovie > userRating,String userId) {
        this.userRating = userRating;
        this.userId=userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List< RatingMovie > getUserRating() {
        return userRating;
    }

    public void setUserRating(List< RatingMovie > userRating) {
        this.userRating = userRating;
    }
    public void initData(String userId) {
        this.setUserId(userId);
        this.setUserRating(Arrays.asList(
                new RatingMovie("100", 3),
                new RatingMovie("200", 4)
        ));
    }
}
