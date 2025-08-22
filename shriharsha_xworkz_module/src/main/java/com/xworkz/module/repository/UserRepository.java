package com.xworkz.module.repository;

import com.xworkz.module.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity ,Long>,UserRepositoryCustom {

}
