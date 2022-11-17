package com.gaurav.quoraapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.catalina.User;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    private Long id;

    @Column(name = "role_given")
    private String role;

    @ManyToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "uid")
    private Users users;
}
