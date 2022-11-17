package com.gaurav.dto_representation.UserDto;

import lombok.Data;

@Data
public class UserDto {
    private int userId;
    private String email;
    private String place;
    private double longitude;
    private double latitude;
}
