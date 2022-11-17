package com.gaurav.dto_representation.repo;

import com.gaurav.dto_representation.model.UserLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserLocationRepo extends JpaRepository<UserLocation,Long> {

//    @Query(value = "SELECT u FROM UserLocation u WHERE u.place = :place")
//    UserLocation fetchUserLocation(String place);

}
