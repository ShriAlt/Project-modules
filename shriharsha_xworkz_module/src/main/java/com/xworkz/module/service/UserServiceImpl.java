package com.xworkz.module.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public String validateAndSave() {

        return "";
    }

    @Override
    public void sendOtpMail(String emailTo, String userName) {
        SimpleMailMessage mailMessage= new SimpleMailMessage();
        mailMessage.setTo(emailTo);
        mailMessage.setSubject("wellcome");
        mailMessage.setText("hi"+userName+"otp:5678");
        mailSender.send(mailMessage);
    }
}
