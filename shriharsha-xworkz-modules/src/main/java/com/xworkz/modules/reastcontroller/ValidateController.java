package com.xworkz.modules.reastcontroller;

import com.xworkz.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@RequestMapping("/")
public class ValidateController {

    @Autowired
    UserService userService;

    @RequestMapping("checkEmail")
    public ResponseEntity<String> checkEmail(String email){

        if (userService.isEmailExist(email)){
            return ResponseEntity.ok("true");
        }
        return ResponseEntity.ok("false");
    }

    @RequestMapping("checkNumber")
    public ResponseEntity<String> checkNumber(String phoneNumber){
        if (userService.isNumberExist(phoneNumber)){
            return ResponseEntity.ok("true");
        }
        return ResponseEntity.ok("false");
    }
}
