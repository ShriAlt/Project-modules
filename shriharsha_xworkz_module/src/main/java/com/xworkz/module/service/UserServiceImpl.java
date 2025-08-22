package com.xworkz.module.service;

import com.xworkz.module.dto.UserDTO;
import com.xworkz.module.entity.OtpEntity;
import com.xworkz.module.entity.UserEntity;
import com.xworkz.module.repository.OtpRepository;
import com.xworkz.module.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private UserRepository  userRepository;

    @Autowired
    private OtpRepository otpRepository;

    @Override
    @Transactional
    public String validateAndSave(UserDTO userDTO) {
        UserEntity userEntity=new UserEntity();

         BeanUtils.copyProperties(userDTO,userEntity);//source and target this will copy the properties

        userRepository.save(userEntity);//save() method is from JpaRepository

        return "false";
    }

    @Override
    public void sendOtpMail(String emailTo, String userName) {
        List<OtpEntity> recentOtps = otpRepository.findRecentByEmail(emailTo);
        long recentOtpCount=recentOtps.stream()
                .filter(otp -> otp.getCreatedTime().isAfter(LocalDateTime.now().minusMinutes(15)))
                .count();
        if (recentOtpCount >= 3) {
            throw new IllegalStateException("OTP request limit exceeded. Try again later.");
        }
        String rawOtp = generateOtpMail(emailTo, userName);

        String encryptedOtp = encryptOtp(rawOtp);//encoding

        OtpEntity otpEntity = new OtpEntity();//setting
        otpEntity.setEmail(emailTo);
        otpEntity.setEncryptedOtp(encryptedOtp);
        otpEntity.setCreatedTime(LocalDateTime.now());
        otpEntity.setExpiryTime(LocalDateTime.now().plusMinutes(5));
        otpEntity.setVerified(false);
        otpEntity.setAttemptCount(0);

        otpRepository.save(otpEntity);


    }
    private String encryptOtp(String rawOtp) {
        return new BCryptPasswordEncoder().encode(rawOtp);
    }
    private String encryptPassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }
    //method to generate otp mail
    private String generateOtpMail(String emailTo, String userName)
    {
        String otp = generateOtp(6);
        SimpleMailMessage mailMessage= new SimpleMailMessage();
        mailMessage.setTo(emailTo);
        mailMessage.setSubject("wellcome");
        mailMessage.setText("hi"+ userName +" otp : "+otp);
        mailSender.send(mailMessage);
        return otp;
    }

    @Override
    public String generateOtp(int otpLength) {

        StringBuilder otp = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < otpLength; i++) {
            otp.append(secureRandom.nextInt(10));
        }
        return otp.toString();
    }

    @Override
    public String verifyOtp(String email, String inputOtp) {
        List<OtpEntity> recentOtps = otpRepository.findRecentByEmail(email);

        if (recentOtps.isEmpty()) return "please generate otp ";

        OtpEntity latestOtp = recentOtps.get(0);

        if (latestOtp.getExpiryTime().isBefore(LocalDateTime.now())) return "otp expired";

        boolean isMatch = new BCryptPasswordEncoder().matches(inputOtp, latestOtp.getEncryptedOtp());

        if (isMatch) {
            latestOtp.setVerified(true);
            otpRepository.save(latestOtp);
        }
        return "matched";
    }
}
