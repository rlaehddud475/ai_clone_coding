package org.koreait.member.controllers;

import lombok.Data;

import java.io.Serializable;
import java.util.List;
@Data
public class RequestAgree implements Serializable {
    //@AssertTrue
    private boolean requiredTerms1;
    //@AssertTrue
    private boolean requiredTerms2;
    //@AssertTrue
    private boolean requiredTerms3;

    private List<String> optionalTerms;
}
