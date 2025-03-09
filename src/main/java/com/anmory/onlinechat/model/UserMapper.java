package com.anmory.onlinechat.model;

import org.apache.ibatis.annotations.Mapper;

/**
 * @author Anmory/李梦杰
 * @description TODO
 * @date 2025-03-08 下午9:22
 */
@Mapper
public interface UserMapper {
    // 插入用户
    int InsertUser(User user);
    // 根据用户名查询用户
    User SelectByUsername(String username);
}
