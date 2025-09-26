package com.xworkz.modules.service;

import com.xworkz.modules.dto.UserDto;
import com.xworkz.modules.entity.LoginEntity;
import com.xworkz.modules.entity.UserEntity;
import com.xworkz.modules.repository.UserRepository;
import com.xworkz.modules.util.EmailService;
import com.xworkz.modules.util.OtpUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService{

    private static final String upload = "";
    @Autowired
  private   UserRepository userRepository;

    @Autowired
  private   OtpUtil otpUtil;

    @Autowired
   private EmailService emailService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String validateAndSave(UserDto userDto) {
        if (userDto != null){
            if (!checkMail(userDto.getEmail())){
                if (validatePassword(userDto.getPassword(),userDto.getConfirmPassword())){

                    UserEntity userEntity=new UserEntity();
                    BeanUtils.copyProperties(userDto,userEntity);
                    userEntity.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
                    if ( !userRepository.save(userEntity)){
                        return "dbError";
                    }
                    return "true";
                }
                else {
                    return "passwordError";
                }
            }
            return "emailExist";
        }
        return "emptyDto";
    }

  private  boolean validatePassword(String password , String confirmPassword){
        if (password.equals(confirmPassword)){
            return true;
        }
        return false;
    }
    private boolean checkMail(String email){
        UserEntity user = userRepository.findByMail(email);
        if (!(user ==null) && email.equals(user.getEmail())){
            return true;
        }
        return false;
    }
    private boolean checkPhoneNumber(String phone){
        if (phone.equals(userRepository.findByNumber(phone).getPhoneNumber())){
            return true;
        }
        return false;
    }
//    private  String encrypt(String rawText){
//        return bCryptPasswordEncoder.encode(rawText);
//    }
//    private boolean decrypt(String encryptPassword , String password){
//        return bCryptPasswordEncoder.matches(password,encryptPassword);
//    }

    @Override
    public boolean isEmailExist(String email) {
        if (checkMail(email)){
            return true;
        }
        return false;
    }

    @Override
    public boolean isNumberExist(String number) {
        if (checkPhoneNumber(number)){
            return true;
        }
        return false;
    }
    @Override
    public String loginUser(String email, String inputPassword) {
        UserEntity user = userRepository.findByMail(email);
        if (user == null) {
            return "emailError";
        }
        if (bCryptPasswordEncoder.matches(inputPassword,user.getPassword())) {
            LoginEntity loginEntity = new LoginEntity();
            loginEntity.setLoginTimestamp(LocalDateTime.now());
            loginEntity.setUserId(user.getId());
            loginEntity.setEmail(email);

            if (!userRepository.saveLoginInfo(loginEntity)) {
                return "dbError";
            }
            return "true";
        }
        return "passwordError";
    }

    @Override
    public String sendOtp(String mail) {

        if ( mail==null || !checkMail(mail)){
            return "noEmailError";
        }
        String otp = otpUtil.genrateOtp();
        emailService.sendOtp(mail, otp);
        UserEntity user = userRepository.findByMail(mail);
        user.setOtp(bCryptPasswordEncoder.encode(otp));
       boolean result =  userRepository.updateUser(user);
       if (!result){
           return "dbError";
       }
        return "noError";
    }

    @Override
    public String verifyOtp(String email ,String inputOtp) {
        if (email == null || inputOtp==null ){
            return "noEmailError";
        }
        UserEntity user = userRepository.findByMail(email);
        if (!bCryptPasswordEncoder.matches(inputOtp,user.getOtp())){
            return "misMatchError";
        }
        return "noError";
    }

    @Override
    public String   resetPassword(String email, String password, String confirmPassword) {
       UserEntity user = userRepository.findByMail(email);
        if (user==null){
            return "noMailError";
        }
        if (!password.equals(confirmPassword)){
            return "passwordError";
        }
        user.setPassword(bCryptPasswordEncoder.encode(password));
        userRepository.updateUser(user);
        return "noError";
    }

    @Override
    public UserDto displayUser(String email) {
        UserEntity user = userRepository.findByMail(email);
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }

    @Override
    public String validateAndUpdate(UserDto dto) {

        if (dto.getFileUpload()!=null ){
            MultipartFile fileUpload = dto.getFileUpload();
            try {

                // Get the file and save it somewhere
                byte[] bytes = fileUpload.getBytes();
                Path path = Paths.get(upload + fileUpload.getOriginalFilename());
                Files.write(path, bytes);
                fileUpload.getOriginalFilename();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (dto==null){
            return "noDtoError";
        }
        UserEntity  entity = new UserEntity();
        BeanUtils.copyProperties(dto,entity);
        System.out.println(entity);
//        userRepository.updateUser(entity);
        return "noErrors";
    }
}
