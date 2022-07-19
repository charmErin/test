package com.its.test;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService ms;

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/member/save-form")
    public String saveForm() {
        return "save";
    }

    @PostMapping("/member/save")
    public String save(MemberDTO memberDTO){
        ms.save(memberDTO);
        return "login";
    }

//    @GetMapping("/member/saveProc")
//    public @ResponseBody String saveProc() {
//        return "회원가입 완료!";
//    }

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
