package com.ykh.vo.res;

/**
 * Created by ant_shake_tree on 15/8/21.
 */
public class BmsResponse {
    private Header head=new Header();
    private BmsBody body;

    public static class BmsBody{

            Integer bmsId;

        public Integer getBmsId() {
            return bmsId;
        }

        public void setBmsId(Integer bmsId) {
            this.bmsId = bmsId;
        }
    }

    public Header getHead() {
        return head;
    }

    public void setHead(Header head) {
        this.head = head;
    }

    public BmsBody getBody() {
        return body;
    }

    public void setBody(BmsBody body) {
        this.body = body;
    }
}
