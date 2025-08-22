package com.xworkz.module.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "user_details")
@Data
public class UserEntity {
    public UserEntity(){
        System.out.println("no args of UserEntity");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String fullName;


    private String username;


    private String email;


    private String phone;

    private String password;


    private String gender;

    private String address;

}
