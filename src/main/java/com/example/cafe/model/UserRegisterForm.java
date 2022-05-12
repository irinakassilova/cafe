package com.example.cafe.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserRegisterForm {
    @NotBlank
    @Email
    private String email= "";

    @NotBlank
    private String password = "";
}
