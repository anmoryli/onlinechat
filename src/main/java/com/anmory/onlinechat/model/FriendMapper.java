package com.anmory.onlinechat.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Anmory/李梦杰
 * @description TODO
 * @date 2025-03-09 下午7:36
 */

@Mapper
public interface FriendMapper {
    List<Friend> selectFriends(int userId);
}
