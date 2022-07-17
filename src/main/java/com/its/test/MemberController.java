package com.its.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService ms;

    @GetMapping("/member/save-form")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/member/save")
    public String save(MemberDTO memberDTO){
        System.out.println("memberDTO = " + memberDTO);
        ms.save(memberDTO);
        return "login";
    }

    @GetMapping("/member/login-form")
    public String loginForm() {
        return "login";
    }

    @PostMapping("/member/login")
    public String login() {
        return "index";
    }

    @GetMapping("/member/logout")
    public String logout(){
        return "index";
    }

    @GetMapping("/member/login-fail")
    public String loginFail() {
        return "loginFail";
    }
}
