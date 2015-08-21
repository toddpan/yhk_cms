package com.ykh.vo.res;

import com.ykh.tang.agent.vo.UserChannel;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
public class UserChannelResponse {
    private Header head;
    private UserChannel body;

    public UserChannel getBody() {
        return body;
    }

    public void setBody(UserChannel body) {
        this.body = body;
    }

    public Header getHead() {
        return head;
    }

    public void setHead(Header head) {
        this.head = head;
    }
}
