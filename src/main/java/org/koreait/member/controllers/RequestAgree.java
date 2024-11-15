package org.koreait.member.controllers;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;
@Data
public class RequestAgree {
    @NotNull
    private boolean[] requiredTerms;
    private List<String> optionalTerms;
}
