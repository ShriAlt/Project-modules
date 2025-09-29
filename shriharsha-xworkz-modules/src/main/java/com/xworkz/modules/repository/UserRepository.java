package com.xworkz.modules.repository;

import com.xworkz.modules.entity.LoginEntity;
import com.xworkz.modules.entity.UserEntity;

import java.util.List;

public interface UserRepository {
    boolean save(UserEntity userEntity);
    UserEntity findByMail(String mail);
    UserEntity findByNumber(String number);
    boolean saveLoginInfo(LoginEntity loginEntity);
    boolean updateUser(UserEntity entity);
    List<UserEntity> findAll();
    void cleanUpOtp();
}
