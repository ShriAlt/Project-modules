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

        if (result.hasErrors()){
            model.addAttribute("validationError","please fill the form correctly");
            List<ObjectError> errors =result.getAllErrors();
            for (ObjectError e : errors){
                System.out.println(e);
            }
            return "SignUpPage";
        }
        String  serviceResult =  userService.validateAndSave(userDto);

        if (serviceResult.equals("passwordError")){
            model.addAttribute("passwordError","password doest match");
            return "SignUpPage";
        }
        if (serviceResult.equals("dbError")){
            model.addAttribute("dbError","invalid data...!");
            return "SignUpPage";
        }
        if (serviceResult.equals("emailExist")){
            model.addAttribute("emailError","email already exist ");
            return "SignUpPage";
        }
        return "SignInPage";
    }

    @PostMapping("login")
    public String loginUser(String email , String  password , Model model){
        String error = userService.loginUser(email,password);
        if (error.equals("emailError")){
            model.addAttribute("email",email);
            model.addAttribute("emailError","mail doesn't exist");
            return "SignInPage";
        }
        if (error.equals("dbError")){
            model.addAttribute("email",email);
            model.addAttribute("dbError","error with the  server  ");
            return "SignInPage";
        }
        if (error.equals("passwordError")){
            model.addAttribute("email",email);
            model.addAttribute("passwordError","password is not right ");
            return "SignInPage";
        }
        model.addAttribute("success","Welcome! you just logged in ");
        return "Home";
    }


}
