package com.xworkz.modules.entity;

import com.xworkz.modules.dto.Gender;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table (name = "users")
@Data
@NamedQuery(
        name = "findByEmail",
        query = "SELECT entity FROM UserEntity entity WHERE entity.email = :email"
)
@NamedQuery(
        name = "findByNumber",
        query = "select entity from UserEntity entity where entity.phoneNumber= :phoneNumber"
)
public class UserEntity {

    public UserEntity(){
        System.out.println("no args of UserEntity");
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "dob")
    private String dob;

    @Column(name = "password")
    private String password;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "country")
    private String country;

    @Column(name = "state")
    private String state;

    @Column(name = "city")
    private String city;

    @Column(name = "pin_code")
    private String pinCode;

    @Column(name = "otp")
    private String otp;
}
