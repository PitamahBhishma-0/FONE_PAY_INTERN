package com.gaurav.quoraapp.Dto.response;

import lombok.Data;

@Data
public class GetMatchingExpertiseResponseDTO {
    private String expertise;
    private String uname;
    private Long userId;
}
