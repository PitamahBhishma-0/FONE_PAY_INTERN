package com.example.join_queries.repo;

import com.example.join_queries.Dto.OrderResponse;
import com.example.join_queries.Entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepo extends JpaRepository<Costumer, Integer> {

    @Query("SELECT new com.example.join_queries.Dto.OrderResponse(c.name,p.productName)  from Costumer c JOIN c.product p")
    public List<OrderResponse> getJoinInformation();

}
