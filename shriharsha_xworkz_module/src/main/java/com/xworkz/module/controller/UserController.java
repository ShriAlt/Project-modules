package com.xworkz.module.controller;

import com.xworkz.module.dto.UserDTO;
import com.xworkz.module.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    public UserController(){
        System.out.println(" no args const UserController");
    }

    @RequestMapping("signup")
    public String validateAndSave(@Valid UserDTO dto, BindingResult bindingResult, Model model){
        System.out.println("running Validate and save for :"+dto.toString());
        if (bindingResult.hasErrors())
        {
            List<ObjectError> errors=bindingResult.getAllErrors();
            model.addAttribute("errorMessage","please check your form ");
            model.addAttribute("errors",errors);
        }
        model.addAttribute("success","registered!");
        userService.sendOtpMail(dto.getEmail(),dto.getUsername());
        return "signIn";
    }
}
