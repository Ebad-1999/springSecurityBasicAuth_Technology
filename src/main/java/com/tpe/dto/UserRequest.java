package com.tpe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String firstName;

    @Column(length = 25, nullable = false)
    private String lastName;

    @Column(length = 25, nullable = false, unique = true)
    @Size(min = 4, max = 30, message = "User name must be between 5 and 30 character")
    private String userName;

    @Column(length  = 255, nullable = false)
    private String password;
}
