package Sockets;

import java.io.Serializable;
import java.util.Date;

public class MessageData implements Serializable
{
    private String userName;
    private String messageText;
    private Date sentDate; // java.util.Date

    public MessageData(){}
    public MessageData(String userName,String messageText)
    {
        this.userName = userName;
        this.messageText = messageText;
        this.sentDate = new Date();
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    @Override
    public String toString() {
        return "MessageData{" +
                "userName='" + userName + '\'' +
                ", messageText='" + messageText + '\'' +
                ", sentDate=" + sentDate +
                '}';
    }
}
