package com.webchat.webchat.pojo;

import java.util.Date;
import java.util.List;

public class ChatMessagePojo {
    private String id;
    private MessageType type;
    private String content;
    private String sender;
    private String room;
    private Date timeChat;
    private String statusMessage;
    private String urlFile;

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE,
        JOINRETURN,
        ATTACK
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
