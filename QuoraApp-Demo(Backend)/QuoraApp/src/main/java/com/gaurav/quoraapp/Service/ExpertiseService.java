package com.gaurav.quoraapp.Service;

import com.gaurav.quoraapp.Dto.response.GetMatchingExpertiseResponseDTO;

import java.util.List;

public interface ExpertiseService {
    List<GetMatchingExpertiseResponseDTO> getMatchingExpertise(String name);

}
