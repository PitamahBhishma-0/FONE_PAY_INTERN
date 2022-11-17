package com.gaurav.quoraapp.Dto.response;

import com.gaurav.quoraapp.model.Roles;
import com.gaurav.quoraapp.model.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleResponse {
    private String name;
    private List< Roles > roles;
}
