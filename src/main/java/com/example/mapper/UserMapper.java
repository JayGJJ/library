package com.example.mapper;

import com.example.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

//此处不需要加上注解，因为在SpringConfig中已经配置了扫描路径,spring会帮忙创建
public interface UserMapper {

    @Select("select * from user where user_email=#{email} and user_password=#{password}")//此处有两个参数，因此需要使用@Param注解取名
    @Results({
        @Result(id = true,column = "user_id",property = "id"),
        @Result(column = "user_email",property = "email"),
        @Result(column = "user_password",property = "password"),
        @Result(column = "user_email",property = "email"),
        @Result(column = "user_role",property = "role"),
        @Result(column = "user_status",property = "status"),
    })
    User findUserBuEmailAndPassword(@Param("email") String email, @Param("password") String password);
}
