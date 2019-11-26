package com.bfby.zxjl.ui.event;

public class MessageEvent {
    private String message="normal";
    private int msgState=-1;

    public MessageEvent(String message) {
        this.message = message;
    }

    public MessageEvent(int msgState) {
        this.msgState = msgState;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMsgState() {
        return msgState;
    }

    public void setMsgState(int msgState) {
        this.msgState = msgState;
    }
}
