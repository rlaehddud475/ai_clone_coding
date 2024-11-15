package org.koreait.member.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestJoin {
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private String redirectUrl;
}
