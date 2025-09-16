package com.xworkz.modules.service;

import com.xworkz.modules.dto.UserDto;
import com.xworkz.modules.entity.UserEntity;
import com.xworkz.modules.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public String validateAndSave(UserDto userDto) {
//        System.out.println(userDto.toString());
        if (userDto != null){
            if (validatePassword(userDto.getPassword(),userDto.getConfirmPassword())){
                UserEntity userEntity=new UserEntity();
                BeanUtils.copyProperties(userDto,userEntity);
                userRepository.save(userEntity);
                return "true";
            }
        }
        return "false";
    }

    static boolean validatePassword(String password , String confirmPassword){
        if (password.equals(confirmPassword)){
            return true;
        }
        return false;
    }
}
