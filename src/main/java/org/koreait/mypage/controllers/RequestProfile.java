
package org.koreait.mypage.controllers;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.koreait.member.constants.Gender;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Data
public class RequestProfile {
    @NotBlank
    private String name; // 회원명
    @NotBlank
    private String nickName;
    private String password;
    private String confirmPassword;

    @NotNull
    private Gender gender;


    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
   private LocalDate birthDt;

    @NotBlank
    private String zipCode;
    @NotBlank
    private String address;
    private String addressSub;

    private List<String> optionalTerms;

}
