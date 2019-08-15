package com.lzh.dao;

import com.lzh.domain.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select * from user where uid = #{value}")
    User getUserById(String uid);
}
