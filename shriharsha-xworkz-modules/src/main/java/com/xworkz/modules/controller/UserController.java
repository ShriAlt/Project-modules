package com.xworkz.modules.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserController {

    public UserController(){
        System.out.println("no args of UserController");
    }

    @GetMapping("signIn")
    public String signIn(){
        return "SignInPage";
    }
    @GetMapping("signUp")
    public String signUp(){
        return "SignUpPage";
    }

}
