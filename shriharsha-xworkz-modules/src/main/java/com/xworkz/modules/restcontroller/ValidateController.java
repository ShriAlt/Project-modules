package com.xworkz.modules.restcontroller;

import com.xworkz.modules.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class ValidateController {

    @Autowired
    private UserService userService;

    @GetMapping("/checkEmail")
    public ResponseEntity<String> checkEmail(@RequestParam String email){
        boolean exists = userService.isEmailExist(email);
        return ResponseEntity.ok(String.valueOf(exists));
    }

    @GetMapping("/checkNumber")
    public ResponseEntity<String> checkNumber(@RequestParam String phoneNumber){
        boolean exists = userService.isNumberExist(phoneNumber);
        return ResponseEntity.ok(String.valueOf(exists));
    }
}

