package com.ykh.vo.res;

import com.ykh.vo.body.ConferenceSeedBody;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
public class CreateConferenceResponse {
    Header head=new Header();

    private ConferenceSeedBody body;

    public Header getHead() {
        return head;
    }

    public void setHead(Header head) {
        this.head = head;
    }



    public ConferenceSeedBody getBody() {
        return body;
    }

    public void setBody(ConferenceSeedBody body) {
        this.body = body;
    }
}
