package com.mcl.cony.Tools;

import com.mcl.cony.Model.User_Base;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptTools {

    public static void encryptPassword(User_Base userEntity){
        String password = userEntity.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        userEntity.setPassword(password);
    }
}
