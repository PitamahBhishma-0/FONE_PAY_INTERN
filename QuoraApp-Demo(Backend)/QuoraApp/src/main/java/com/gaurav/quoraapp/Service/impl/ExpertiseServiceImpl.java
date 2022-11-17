package com.gaurav.quoraapp.Service.impl;

import com.gaurav.quoraapp.Dto.response.GetMatchingExpertiseResponseDTO;
import com.gaurav.quoraapp.Repo.ExpertiseRepo;
import com.gaurav.quoraapp.Service.ExpertiseService;
import com.gaurav.quoraapp.model.Expertise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExpertiseServiceImpl implements ExpertiseService {
    @Autowired
    ExpertiseRepo expertiseRepo;

    @Override
    public List<GetMatchingExpertiseResponseDTO> getMatchingExpertise(String name) {
        if(name==null){
            return getMatchingExpertiseResponseDTOList(expertiseRepo.getAllExpertise());
        }
        System.out.println(expertiseRepo.fetchMatchingExpertise(name));

        return getMatchingExpertiseResponseDTOList(expertiseRepo.fetchMatchingExpertise(name));
    }
   private List<GetMatchingExpertiseResponseDTO> getMatchingExpertiseResponseDTOList(List<Expertise> expertiseList){
        List<GetMatchingExpertiseResponseDTO> getMatchingExpertiseResponseDTOList = new ArrayList<>();
        for(Expertise expertise : expertiseList){
            GetMatchingExpertiseResponseDTO getMatchingExpertiseResponseDTO = new GetMatchingExpertiseResponseDTO();
            getMatchingExpertiseResponseDTO.setExpertise(expertise.getExpertise().toUpperCase());
            getMatchingExpertiseResponseDTO.setUname(expertise.getUsers().getName());
            getMatchingExpertiseResponseDTO.setUserId(expertise.getUsers().getUid());
            getMatchingExpertiseResponseDTOList.add(getMatchingExpertiseResponseDTO);
        }
        return getMatchingExpertiseResponseDTOList;
   }
}