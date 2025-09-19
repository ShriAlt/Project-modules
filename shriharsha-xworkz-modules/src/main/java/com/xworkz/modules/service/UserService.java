package com.xworkz.modules.service;

import com.xworkz.modules.dto.UserDto;

public interface UserService {
 String validateAndSave(UserDto userDto);
  boolean isEmailExist(String email );
    boolean isNumberExist(String number );
    String loginUser(String email , String inputPassword);
    String sendOtp(String mail);

}
