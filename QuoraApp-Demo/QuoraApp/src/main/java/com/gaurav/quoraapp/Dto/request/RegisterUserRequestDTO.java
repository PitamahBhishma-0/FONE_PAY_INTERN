package com.gaurav.quoraapp.Dto.request;

import com.gaurav.quoraapp.model.Roles;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class RegisterUserRequestDTO {
    private String email;
    private String name;
    private String password;
    private Byte aBoolean;
    private BigDecimal phoneNumber;
    private Date dob;
    private List<String> experties;
    //private List< String > roles;
}
