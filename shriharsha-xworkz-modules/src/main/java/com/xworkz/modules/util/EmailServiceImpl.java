package com.xworkz.modules.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class EmailServiceImpl implements EmailService {

    public EmailServiceImpl(){
        System.out.println("no args of EmailServiceImpl");
    }

    @Autowired
    private JavaMailSender emailSender;

    @Override
    public void sendOtp(String to, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
//        message.setFrom("chinnusriharsha22gmail.com");
        message.setReplyTo("shriharshakm10@gmail.comm");
        message.setTo(to);
        message.setSubject("Your one time OTP");
        message.setText("your one time pass dont  share this with anyone : "+otp);
        emailSender.send(message);
    }
}
