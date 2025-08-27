package com.xworkz.module.controller;

import com.xworkz.module.dto.UserDTO;
import com.xworkz.module.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(){
        System.out.println(" no args const UserController");
    }

    @RequestMapping("signup")
    public String validateAndSave(@Valid UserDTO dto, BindingResult bindingResult, Model model, HttpSession session){
        System.out.println("running Validate and save for :"+dto.toString());
        if (bindingResult.hasErrors())
        {
            List<ObjectError> errors=bindingResult.getAllErrors();
            model.addAttribute("errorMessage","please check your form ");
            model.addAttribute("errors",errors);
        }
        model.addAttribute("email",dto.getEmail());
        userService.sendOtpMail(dto.getEmail(),dto.getUsername());
        session.setAttribute("dto", dto);

        System.out.println("Im here...");
        return "OtpPage";
    }

    @RequestMapping("verifyOtp")
    public String verifyOtp(  String otp,Model model,HttpSession session){
//        System.out.println("im in here ");
        UserDTO userDTO = (UserDTO) session.getAttribute("dto");
        System.out.println(userDTO.getEmail());
        System.out.println(otp);
        String  result = userService.verifyOtp(userDTO.getEmail(),otp);
        System.out.println(result);
        if (result.equals("please generate otp ") || result.equals("otp expired")){
            model.addAttribute("error","otp is wrong or not valid ");
            return "OtpPage";
        }
        userService.validateAndSave(userDTO);
        return "signIn";
    }
}
