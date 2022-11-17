package com.gaurav.dto_representation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="locations")
public class UserLocation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long location_id;
    private  String place;
    private String description;
    private double longitude;
    private double latitude;



}
