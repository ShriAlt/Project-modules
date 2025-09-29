package com.xworkz.modules.scheduler;

import com.xworkz.modules.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



@Component
public class CleanUpSchedulerImpl implements  CleanUpScheduler{
    @Autowired
    private UserRepository userRepository;

    @Override
    @Scheduled(fixedRate = 600000)
    public void otpCleanUpScheduler() {
//        List<UserEntity> userEntities = userRepository.findAll();
//        for (UserEntity user : userEntities) {
//            user.setOtp(null);
//            userRepository.updateUser(user);
//        }
        userRepository.cleanUpOtp();
        System.err.println("otp cleared");
    }
}
