package com.gaurav.quoraapp.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Long uid;


    @Column(name = "uname")
    private String name;
    @NotBlank(message = "email  cannot be blank")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Lob
    @Column(name = "passwords", nullable = false)
    private String password;


    @Column(name = "enabled")
    private Byte aBoolean;



  /*  @NotEmpty(message = "Mobile number cannot be null")
    @Size(min = 10, max = 10, message = "Number should have at least 10 or less than 17 digits")*/
    @Column(name = "phone")
    private BigDecimal phoneNumber;


    @Column(name = "dob", nullable = false)
    @JsonFormat(pattern = "yyyy-mm-dd")
    private Date dob;

//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @Column(name = "expertIn", nullable = false)
//    private List< Expertise > expertise;
//
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @Column(name = "roles")
//    private List< Roles > roles;
//
//    @Column(name = "question_answer")
//    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
//    private List<QuestionAndAnswer> questionAndAnswers;
}
