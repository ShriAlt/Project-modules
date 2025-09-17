package com.xworkz.modules.service;

import com.xworkz.modules.dto.UserDto;
import com.xworkz.modules.entity.UserEntity;
import com.xworkz.modules.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public String validateAndSave(UserDto userDto) {
        if (userDto != null){
            if (validatePassword(userDto.getPassword(),userDto.getConfirmPassword())){
                UserEntity userEntity=new UserEntity();
                BeanUtils.copyProperties(userDto,userEntity);
               if (userRepository.save(userEntity)){
                   return "dbError";
               }
                return "true";
            }
            else {
                return "passwordError";
            }
        }
        return "emptyDto";
    }

  private  boolean validatePassword(String password , String confirmPassword){
        if (password.equals(confirmPassword)){
            return true;
        }
        return false;
    }

    @Override
    public boolean isEmailExist(String email) {
        UserEntity userEntity = userRepository.findByMail(email);
        if (userEntity!=null){
            return true;
        }
        return false;
    }

    @Override
    public boolean isNumberExist(String number) {
        UserEntity userEntity = userRepository.findByNumber(number);
//        System.out.println(userEntity);
        if (userEntity!=null){
            return true;
        }
        return false;
    }
}
