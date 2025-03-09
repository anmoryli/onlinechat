package com.anmory.onlinechat.model;

/**
 * @author Anmory/李梦杰
 * @description TODO
 * @date 2025-03-09 下午7:35
 */

public class Friend {
    private Integer friendId;
    private String friendName;

    @Override
    public String toString() {
        return "Friend{" +
                "friendId=" + friendId +
                ", friendName='" + friendName + '\'' +
                '}';
    }

    public Integer getFriendId() {
        return friendId;
    }

    public void setFriendId(Integer friendId) {
        this.friendId = friendId;
    }

    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }
}
