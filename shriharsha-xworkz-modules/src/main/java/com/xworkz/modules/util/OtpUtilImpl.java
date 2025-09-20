package com.xworkz.modules.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class OtpUtilImpl implements OtpUtil {
    @Override
    public String genrateOtp() {
        Random  random = new Random();
        return String.valueOf(random.nextInt(99999));
    }
}
