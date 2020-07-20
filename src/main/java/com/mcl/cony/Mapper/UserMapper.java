package com.mcl.cony.Mapper;

import com.mcl.cony.Model.User_Base;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user_base where user_name = #{username}")
    public User_Base SelectUserByUN(String username);

    @Insert("insert into user_base(user_name,nick_name,gender,birthday,signature,face,face200,password) " +
            "values(#{user.userName},#{user.nickName},#{user.gender}," +
            "#{user.birthday},#{user.signature},#{user.face},#{user.face200},#{user.password})")
    public Integer InsertUser(@Param("user") User_Base user);
}
