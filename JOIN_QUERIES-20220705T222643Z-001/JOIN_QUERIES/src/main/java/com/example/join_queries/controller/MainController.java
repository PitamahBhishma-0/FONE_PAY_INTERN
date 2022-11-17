package com.example.join_queries.controller;

import com.example.join_queries.Dto.OrderRequest;
import com.example.join_queries.Dto.OrderResponse;
import com.example.join_queries.Entity.Costumer;
import com.example.join_queries.repo.CustomerRepo;
import com.example.join_queries.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private ProductRepo productRepo;
    @PostMapping("/saveCostumer")
    public Costumer saveCostumer(@RequestBody OrderRequest orderRequest){

        return customerRepo.save(orderRequest.getCostumer());
    }
    @GetMapping("/findAll")
    public List<Costumer> getAllCostumer(){

        return customerRepo.findAll();
    }

    @GetMapping("/findSpecific")
    public List<OrderResponse> getJoinInfo(){

        return customerRepo.getJoinInformation();
    }
}
