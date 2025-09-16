package com.xworkz.modules.controller;

import com.xworkz.modules.dto.UserDto;
import com.xworkz.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

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
    public String register(@Valid @ModelAttribute("userDto") UserDto userDto , BindingResult result ,  Model model ){
        System.out.println(userDto.toString());
        if (result.hasErrors()){
            model.addAttribute("error","please fill the form correctly");
         List<ObjectError> errors =   result.getAllErrors();
         for (ObjectError error : errors){
             System.out.println(error);
         }
            System.out.println("has errors in dto");
            return "SignUpPage";
        }
        String  serviceResult =  userService.validateAndSave(userDto);
//        if (serviceResult.equals("false")){
//
//        }

        return "otp";
    }

}
