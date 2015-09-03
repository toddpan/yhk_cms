package com.ykh.vo.res;

import com.google.common.collect.Lists;
import com.ykh.pojo.UserServiceDTO;
import com.ykh.tang.agent.vo.UserChannel;
import com.ykh.tang.agent.vo.UserServiceAddr;

import java.util.List;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
public class UserChannelResponse {
    private Header head;
    private UserServiceDTO body;

    public Header getHead() {
        return head;
    }

    public void setHead(Header head) {
        this.head = head;
    }

    public UserServiceDTO getBody() {
        return body;
    }

    public void setBody(UserServiceDTO body) {
        this.body = body;
    }
}
