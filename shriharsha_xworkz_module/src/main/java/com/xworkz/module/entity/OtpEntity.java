package com.xworkz.module.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Otp_codes")
@Data
public class OtpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String encryptedOtp;

    private LocalDateTime expiryTime;

    private LocalDateTime createdTime;

    private boolean verified;

    private int attemptCount;


}
