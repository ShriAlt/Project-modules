package com.xworkz.modules.service;

import com.xworkz.modules.dto.UserDto;

import java.nio.file.Path;

public interface UserService {
 String validateAndSave(UserDto userDto);
  boolean isEmailExist(String email );
    boolean isNumberExist(String number );
    String loginUser(String email , String inputPassword);
    String sendOtp(String mail);
    String verifyOtp(String email,String inputOtp);
    String resetPassword(String email,String password , String confirmPassword);
    UserDto displayUser(String email);
    String  validateAndUpdate(UserDto dto);
    Path displayUserImg(String email);

}
