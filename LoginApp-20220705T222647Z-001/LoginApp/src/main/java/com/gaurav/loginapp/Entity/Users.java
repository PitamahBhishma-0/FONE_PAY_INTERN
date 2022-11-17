package com.gaurav.loginapp.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fName;
    private String lName;
    private String email;
    private String password;
    private String address;
    @OneToMany(
       fetch = FetchType.EAGER,cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "User_role"
            )
    private List<Roles> roles;
}
