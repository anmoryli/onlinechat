package com.anmory.onlinechat.model;

import java.util.Date;
import java.util.List;

/**
 * @author Anmory/李梦杰
 * @description TODO
 * @date 2025-03-09 下午11:12
 */

public class MessageSession {
    private int sessionId;
    private List<Friend> friends;
    private String lastMessage;
    private Date sendTime;

    @Override
    public String toString() {
        return "MessageSession{" +
                "sessionId=" + sessionId +
                ", friends=" + friends +
                ", lastMessage='" + lastMessage + '\'' +
                ", sendTime=" + sendTime +
                '}';
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public List<Friend> getFriends() {
        return friends;
    }

    public void setFriends(List<Friend> friends) {
        this.friends = friends;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }
}
