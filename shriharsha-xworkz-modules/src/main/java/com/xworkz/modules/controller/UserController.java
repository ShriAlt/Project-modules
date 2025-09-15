package com.xworkz.modules.controller;

import com.xworkz.modules.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("register")
    public String validateAndRegister(UserDto userDto){
        System.out.println(userDto.toString());
        return "otp";
    }

}
