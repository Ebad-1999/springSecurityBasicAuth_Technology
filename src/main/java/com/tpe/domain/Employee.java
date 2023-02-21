package com.tpe.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
//@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_employee")
public class Employee {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    @NotNull(message = "first name can not be null")
    @NotBlank(message = "first name can't be white space")
    @Size(min = 4, max = 25, message = "First Name   ${validateValue must be between {main} and {max}")
    @Column(nullable = false, length = 25)
    /*final*/ private String firstName;

    @NotNull(message = "first name can not be null")
    @NotBlank(message = "first name can't be white space")
    @Column(nullable = false, length = 25)
    /*final*/ private String lastName;

    @Column(nullable = false, length = 25)
    /*final*/ private String phoneNumber;

    @Email(message = "Please Enter provided email")
    @Column(nullable = false, length = 30, unique = true)

    /*final*/ private String email;

    /*final*/ private Integer salary;

    @Setter(AccessLevel.NONE)
    private LocalDateTime createData = LocalDateTime.now();
}
