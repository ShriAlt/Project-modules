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
import org.springframework.web.multipart.MultipartFile;

import javax.mail.Multipart;
import javax.servlet.http.HttpSession;
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
    @GetMapping("forgotPassword")
    public   String forgotPassword(){return "OtpPage";}

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
    public String loginUser(String email , String  password , HttpSession httpSession, Model model){
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
        model.addAttribute("email",email);
        httpSession.setAttribute("email",email);
        return "Home";
    }

    @PostMapping("SendOtp")
    public String sendOtp( String email , Model model){

        String  result = userService.sendOtp(email);
        if(result.equals("noEmailError")){
            model.addAttribute("noEmailError","email doesn't exist");
        }
        if(result.equals("dbError")){
            model.addAttribute("dbError","server error");
        }
        model.addAttribute("email",email);
        return "OtpPage";
    }

    @PostMapping("VerifyOtp")
    public String verifyOtp(String otp , String email,Model model){
        String result = userService.verifyOtp(email,otp);
        if(result.equals("noMailError")){
            model.addAttribute("noMailError","no mail");
            return "PasswordPage";        }
        if (result.equals("misMatchError")){
            model.addAttribute("misMatchError","otp is invalid");
            return "PasswordPage";
        }
        model.addAttribute("email",email);
        return "resetPasswordPage";
    }
    @PostMapping("ResetPassword")
    public String resetPassword(String newPassword , String confirmPassword, String email , Model model){
        System.out.println(email);
        System.out.println(confirmPassword);
        System.out.println(newPassword);
        String  result = userService.resetPassword(email,newPassword, confirmPassword);
        if(result.equals("noMailError")){
            model.addAttribute("noMailError","no mail");
            return "resetPasswordPage";        }
        if (result.equals("passwordError")){
            model.addAttribute("misMatchError","password doesn't match");
            return "resetPasswordPage";
        }
        return  "SignInPage";
    }
    @GetMapping("viewProfile")
    public String viewProfile( HttpSession httpSession, Model model){
      String email =  httpSession.getAttribute("email").toString();
     UserDto userDto = userService.displayUser(email);
     model.addAttribute("dto",userDto);
        return "ProfilePage";
    }

    @PostMapping("UpdateProfile")
    public String updateProfile(UserDto dto, Model model){
        System.out.println(dto.toString());
        userService.validateAndUpdate(dto);
        return "ProfilePage";
    }


}
