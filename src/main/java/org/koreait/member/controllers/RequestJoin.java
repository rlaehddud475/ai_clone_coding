package org.koreait.member.controllers;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.koreait.member.constants.Gender;

import java.time.LocalDate;
import java.util.List;

@Data
public class RequestJoin extends RequestAgree {



    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String name;
    @NotBlank
    private String password;
    @NotBlank
    private String confirmPassword;
    @NotBlank
    private String nickName;
    @NotNull
    private LocalDate birthDt;
    @NotNull
    private Gender gender;


    @NotBlank
    private String zipCode;
    @NotBlank
    private String address;
    @NotBlank
    private String addressSub;
}
