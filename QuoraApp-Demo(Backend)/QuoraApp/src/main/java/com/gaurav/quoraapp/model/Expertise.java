package com.gaurav.quoraapp.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "expertise")
public class Expertise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exid")
    private Long id;

    @Column(name = "expertise")
    private String expertise;

    @ManyToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "uid")
    private Users users;
}
