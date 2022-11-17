package com.gaurav.quoraapp.controller;

import com.gaurav.quoraapp.Dto.response.GetMatchingExpertiseResponseDTO;
import com.gaurav.quoraapp.Service.ExpertiseService;
import com.gaurav.quoraapp.model.Expertise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("expertise")
@CrossOrigin("*")
public class ExpertiseController {
    @Autowired
    ExpertiseService expertiseService;

    @GetMapping("find")
    public List<GetMatchingExpertiseResponseDTO> getMatchingExpertise(@RequestParam(value = "name",required = false) String name){
       return expertiseService.getMatchingExpertise(name);
    }



}
