package com.mcl.cony.Service;

import com.mcl.cony.Mapper.UserMapper;
import com.mcl.cony.Model.User_Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User_Base SelectUserByUN(String username){
        return userMapper.SelectUserByUN(username);
    }

    public Integer InsertUser(User_Base user) { return userMapper.InsertUser(user); }
}
