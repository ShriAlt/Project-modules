package com.xworkz.modules.entity;

import com.xworkz.modules.dto.Gender;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table (name = "user_details")
@Data
public class UserEntity {

    public UserEntity(){
        System.out.println("no args of UserEntity");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String dob;

    private String password;

    private Gender gender;

    private String country;

    private String state;

    private String city;

    private String pinCode;
}
