package com.xworkz.module.repository;

import com.xworkz.module.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Repository
public class UserRepositoryImpl implements UserRepositoryCustom  {
    public UserRepositoryImpl() {
        System.out.println("no args const of UserRepositoryImpl...");
    }
    @PersistenceContext
    EntityManager entityManager;


}
