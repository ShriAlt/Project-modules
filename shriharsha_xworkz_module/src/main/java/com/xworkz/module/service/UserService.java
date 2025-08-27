package com.xworkz.module.service;


import com.xworkz.module.dto.UserDTO;

public interface UserService {
    void validateAndSave(UserDTO userDTO);
    void sendOtpMail(String emailTo , String userName);
    String generateOtp(int otpLength);
    String verifyOtp(String email,String inputOtp);
}
