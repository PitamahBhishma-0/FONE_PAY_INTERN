package com.example.join_queries.repo;

import com.example.join_queries.Entity.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Costumer,Integer> {
}
