package com.xworkz.module.service;



public interface UserService {
    String validateAndSave();
    void sendOtpMail(String emailTo , String userName);

}
