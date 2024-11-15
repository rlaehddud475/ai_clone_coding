package org.koreait.member.controllers;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.koreait.global.libs.Utils;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    private final Utils utils;

    @GetMapping("/login")
    public String login(@ModelAttribute RequestJoin form){
        return utils.tpl("member/login");
    }
    @PostMapping("/login")
    public String loginPs(@Valid RequestJoin form, Errors errors){
        if (errors.hasErrors()){
            return utils.tpl("member/login");
        }
        String redirectUrl=form.getRedirectUrl();
        redirectUrl= StringUtils.hasText(redirectUrl)?redirectUrl:"/";
        return "redirect:"+redirectUrl;
    }
}

