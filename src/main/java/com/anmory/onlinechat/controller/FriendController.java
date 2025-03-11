package com.anmory.onlinechat.controller;

import com.anmory.onlinechat.model.Friend;
import com.anmory.onlinechat.model.FriendMapper;
import com.anmory.onlinechat.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anmory/李梦杰
 * @description TODO
 * @date 2025-03-09 下午7:51
 */

@RestController
public class FriendController {
    @Resource
    private FriendMapper friendMapper;
    @GetMapping("/friendlist")
    @ResponseBody
    public Object getFriendList(HttpServletRequest request) throws JsonProcessingException {
        // 1.从会话中获取userid
        HttpSession session = request.getSession(false);
        if(session == null) {
            System.out.println("[getFriendList] 获取会话失败");
            return new ArrayList<Friend>();
        }
        User user = (User) session.getAttribute("user");
        if(user == null) {
            System.out.println("[getFriendList] 获取用户失败");
            return new ArrayList<Friend>();
        }
        // 2.根据userid查询数据库
        ObjectMapper om = new ObjectMapper();// 把对象转换成json格式返回
        List<Friend> friends = friendMapper.selectFriends(user.getUserId());
        return om.writeValueAsString(friends);
    }
}
