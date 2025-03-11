package com.anmory.onlinechat.model;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Anmory/李梦杰
 * @description TODO
 * @date 2025-03-09 下午11:13
 */

@Mapper
public interface MessageSessionMapper {
    // 根据userid获取该用户在哪些会话中存在,返回结果是一组sessionid数组
    List<Integer> getSessionIdsByUserId(int userId);

    // 根据sessionid查询会话包含哪些用户，除去最初的自己
    List<Friend> getFriendsBySessionid(int sessionId,int selfId);
}
