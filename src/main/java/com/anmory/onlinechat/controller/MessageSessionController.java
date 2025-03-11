package com.anmory.onlinechat.controller;

import com.anmory.onlinechat.model.Friend;
import com.anmory.onlinechat.model.MessageSession;
import com.anmory.onlinechat.model.MessageSessionMapper;
import com.anmory.onlinechat.model.User;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Anmory/李梦杰
 * @description TODO
 * @date 2025-03-09 下午11:52
 */

@CrossOrigin(origins = "http://127.0.0.1:8080")
@RestController
public class MessageSessionController {
    @Resource
    MessageSessionMapper messageSessionMapper;

    @GetMapping("/sessionlist")
    @ResponseBody
    public Object getMessageSessionList(HttpServletRequest request) {
        List<MessageSession> messageSessionList = new ArrayList<>();
        // 1.获取当前用户id
        HttpSession session = request.getSession(false);
        if(session == null) {
            System.out.println("[getMessageSessionList] 获取会话失败");
            return messageSessionList;
        }
        User user = (User)session.getAttribute("user");
        if(user == null) {
            System.out.println("[getMessageSessionList] 获取用户失败");
            return messageSessionList;
        }
        System.out.println("[getMessageSessionList] 获取用户成功" + user);
        // 2.根据userid查询数据库，查出来有哪些会话id
        System.out.println("[getMessageSessionList] userid 为" + user.getUserId());
        List<Integer> sessionIdList = messageSessionMapper.getSessionIdsByUserId(user.getUserId());
        System.out.println(sessionIdList);
        if(sessionIdList == null) {
            System.out.println("[getMessageSessionList] 会话id为空");
        }
        for(int i : sessionIdList) {
            System.out.println(i);
        }
        for(int sessionId : sessionIdList) {
            MessageSession messageSession = new MessageSession();
            messageSession.setSessionId(sessionId);
            // 3.遍历会话id，查询出每个会话涉及的好友有谁
            List<Friend> friends = messageSessionMapper.getFriendsBySessionid(sessionId,user.getUserId());
            messageSession.setFriends(friends);
            // 4.遍历会话id，查询出每个会话的最后一条消息 TODO(后续等消息表构造好)
            messageSession.setLastMessage("晚上吃什么");
            messageSessionList.add(messageSession);
        }
        // 最终目标是构造出一个MessageSession对象
        System.out.println("[getMessageSessionList]" + messageSessionList);
        return messageSessionList;
    }
}
