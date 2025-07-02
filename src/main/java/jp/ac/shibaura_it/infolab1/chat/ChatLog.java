package jp.ac.shibaura_it.infolab1.chat;

public class ChatLog {
    public String user;
    public String message;

    public ChatLog (String user, String message) {
        this.user = user;
        this.message = message;
    }

    public String log () {
        return user + " : " + message;
    }
}
