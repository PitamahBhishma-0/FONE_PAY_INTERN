package com.gaurav.dto_representation.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="UserInfo")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String fname;
    private String lname;
    private String password;
    @ManyToOne( cascade = CascadeType.ALL)

    @JoinColumn(name="location_id")
    private UserLocation userLocation;


}
