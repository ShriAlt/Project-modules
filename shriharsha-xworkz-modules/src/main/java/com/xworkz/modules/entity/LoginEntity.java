package com.xworkz.modules.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "loginDetails")
@Data
//@NamedQuery(name = "saveLoginInfo",
//        query = "INSERT INTO LoginInfoEntity(email, userId, loginTimestamp) VALUES(:email, :userId, :loginTimestamp)")

public class LoginEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;

    private int userId;

    private LocalDateTime loginTimestamp;

}
