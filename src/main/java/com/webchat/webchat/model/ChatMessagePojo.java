package com.webchat.webchat.model;

import java.util.Date;

public class ChatMessagePojo {

    private MessageType type;
    private String content;
    private String sender;
    private String room;
    private Date timeChat;

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE,
        JOINRETURN
    }

    public Date getTimeChat() {
        return timeChat;
    }

    public void setTimeChat(Date timeChat) {
        this.timeChat = timeChat;
    }

    public MessageType getType() {
        return type;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    @Override
    public String toString() {
        return "ChatMessagePojo{" +
                "content='" + content + '\'' +
                ", sender='" + sender + '\'' +
                ", room='" + room + '\'' +
                ", timeChat=" + timeChat +
                '}';
    }
}
