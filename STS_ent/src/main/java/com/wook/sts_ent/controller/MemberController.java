package com.wook.sts_ent.controller;

import com.wook.sts_ent.dto.MemberDTO;
import com.wook.sts_ent.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("signup_form")
    public String signup_form(){
        return "member/signup";
    }

    @PostMapping("signup")
    public String signup(MemberDTO memberDTO){
        memberService.insertMember(memberDTO);

        return "redirect:login_form";
    }

    @GetMapping("id_check_form")
    public String id_check_form(@RequestParam(name = "id")String id, Model model){

        int message = memberService.findId(id);

        model.addAttribute("id",id);
        model.addAttribute("message",message);

        return "member/idcheck";
    }

    @ResponseBody
    @PostMapping("emailcheck")
    public String emailCheck(@RequestParam(name = "email")String email){

        return memberService.findByEmail(email);
    }

    @GetMapping("login_form")
    public String loginForm(){
        return "member/login";
    }
}

    @PostMapping("")
