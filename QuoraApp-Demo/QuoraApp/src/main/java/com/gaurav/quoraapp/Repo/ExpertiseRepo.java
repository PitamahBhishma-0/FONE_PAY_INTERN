package com.gaurav.quoraapp.Repo;

import com.gaurav.quoraapp.model.Expertise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExpertiseRepo extends JpaRepository< Expertise, Long > {
   @Query(value = "select * from  expertise ue where ue.fk_user=:uid",nativeQuery = true)
   List<Expertise> fetchExpertiseById(Long uid);

//   @Query(value = "select * from expertise ue where ue.expertise LIKE CONCAT('%', :name, '%')", nativeQuery = true)
   @Query(value = "select * from expertise ue where ue.expertise LIKE CONCAT('%', :name, '%')", nativeQuery = true)
   List<Expertise>  fetchMatchingExpertise(String name);
   @Query(value = "select * from expertise",nativeQuery = true)
   List<Expertise> getAllExpertise();
}
