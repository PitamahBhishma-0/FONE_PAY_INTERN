package com.gaurav.quoraapp.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gaurav.quoraapp.model.Expertise;
import com.gaurav.quoraapp.model.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    private String name;
    private String email;
    private List< Roles > roles;
    private List< Expertise > expertise;
    private Byte getABoolean;
    private BigDecimal mobileNumber;
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dob;
}
