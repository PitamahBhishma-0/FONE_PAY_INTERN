package com.gaurav.quoraapp.Dto.request;

import lombok.Data;
@Data
public class LoginUserRequestDTO {
    private String email;
    private String password;
}