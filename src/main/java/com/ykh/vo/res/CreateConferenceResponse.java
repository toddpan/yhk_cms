package com.ykh.vo.res;

import com.ykh.dao.conference.domain.ConfJoinTempConf;
import com.ykh.dao.conference.domain.Conference;
import com.ykh.tang.agent.vo.ConferenceInfoBMS;
import com.ykh.vo.body.ConferenceSeedBody;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
public class CreateConferenceResponse {
    Header head=new Header();

    private ConferenceInfoBMS body;

    public Header getHead() {
        return head;
    }

    public void setHead(Header head) {
        this.head = head;
    }

    public ConferenceInfoBMS getBody() {
        return body;
    }

    public void setBody(ConferenceInfoBMS body) {
        this.body = body;
    }
}
