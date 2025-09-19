package com.xworkz.modules.service;

import com.xworkz.modules.dto.UserDto;
import com.xworkz.modules.entity.LoginEntity;
import com.xworkz.modules.entity.UserEntity;
import com.xworkz.modules.repository.UserRepository;
import com.xworkz.modules.util.OtpUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    OtpUtil otpUtil;

    @Override
    public String validateAndSave(UserDto userDto) {
        if (userDto != null){
            if (!checkMail(userDto.getEmail())){
                if (validatePassword(userDto.getPassword(),userDto.getConfirmPassword())){
                    UserEntity userEntity=new UserEntity();
                    BeanUtils.copyProperties(userDto,userEntity);
                    if ( !userRepository.save(userEntity)){
                        return "dbError";
                    }
                    return "true";
                }
                else {
                    return "passwordError";
                }
            }
            return "emailExist";
        }
        return "emptyDto";
    }

  private  boolean validatePassword(String password , String confirmPassword){
        if (password.equals(confirmPassword)){
            return true;
        }
        return false;
    }
    private boolean checkMail(String email){
        UserEntity user = userRepository.findByMail(email);
        if (!(user ==null) && email.equals(user.getEmail())){
            return true;
        }
        return false;
    }
    private boolean checkPhoneNumber(String phone){
        if (phone.equals(userRepository.findByNumber(phone).getPhoneNumber())){
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmailExist(String email) {
        if (checkMail(email)){
            return true;
        }
        return false;
    }

    @Override
    public boolean isNumberExist(String number) {
        if (checkPhoneNumber(number)){
            return true;
        }
        return false;
    }

    @Override
    public String loginUser(String email, String inputPassword) {
        UserEntity user = userRepository.findByMail(email);
        if (user == null) {
            return "emailError";
        }
        if (inputPassword.equals(user.getPassword())) {
            LoginEntity loginEntity = new LoginEntity();
            loginEntity.setLoginTimestamp(LocalDateTime.now());
            loginEntity.setUserId(user.getId());
            loginEntity.setEmail(email);

            if (!userRepository.saveLoginInfo(loginEntity)) {
                return "dbError";
            }
            return "true";
        }
        return "passwordError";
    }

    @Override
    public String sendOtp(String mail) {
        if (!checkMail(mail)){
            return "noEmailError";
        }
        System.out.println(otpUtil.genrateOtp());
        return "noError";
    }
}
