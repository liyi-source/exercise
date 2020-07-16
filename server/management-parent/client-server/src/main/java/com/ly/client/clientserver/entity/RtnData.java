package com.ly.client.clientserver.entity;

public class RtnData {
    private int rtnCode;
    private String rtnMsg;
    private Object data;

    public RtnData() {
    }

    public RtnData(int rtnCode, String rtnMsg, Object data) {
        this.rtnCode = rtnCode;
        this.rtnMsg = rtnMsg;
        this.data = data;
    }


    public int getRtnCode() {
        return rtnCode;
    }

    public void setRtnCode(int rtnCode) {
        this.rtnCode = rtnCode;
    }

    public String getRtnMsg() {
        return rtnMsg;
    }

    public void setRtnMsg(String rtnMsg) {
        this.rtnMsg = rtnMsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
