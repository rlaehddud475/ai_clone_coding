package org.koreait.member.controllers;


import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class RequestJoin {
    private boolean[] requiredTerms;
    private List<String> optionalTerms;

    private String email;
    private String name;
    private String password;
    private String confirmPassword;
    private String nickName;
    private LocalDate birthDt;
}
