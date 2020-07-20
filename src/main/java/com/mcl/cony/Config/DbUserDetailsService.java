package com.mcl.cony.Config;

import com.mcl.cony.Mapper.UserMapper;
import com.mcl.cony.Model.User_Base;
import com.mcl.cony.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DbUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    DbUserDetailsService(UserService userService){
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User_Base userDO = userService.SelectUserByUN(username);
        if (userDO == null){
            throw new UsernameNotFoundException("用户不存在！");
        }
        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();
        if(userDO.getUserRole()==2){
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority("USER"));
        }else if(userDO.getUserRole()==3){
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority("FORBIDDENUSER"));
        }else if(userDO.getUserRole()==5){
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ADMIN"));
        }else{
            simpleGrantedAuthorities.add(new SimpleGrantedAuthority("NONEUSER"));
        }
        return new org.springframework.security.core.userdetails.User(userDO.getUserName(), userDO.getPassword(), simpleGrantedAuthorities);
    }

}
