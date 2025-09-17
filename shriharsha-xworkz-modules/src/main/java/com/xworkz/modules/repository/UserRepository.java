package com.xworkz.modules.repository;

import com.xworkz.modules.entity.LoginEntity;
import com.xworkz.modules.entity.UserEntity;

public interface UserRepository {
    boolean save(UserEntity userEntity);
    UserEntity findByMail(String mail);
    UserEntity findByNumber(String number);
    boolean saveLoginInfo(LoginEntity loginEntity);
}
