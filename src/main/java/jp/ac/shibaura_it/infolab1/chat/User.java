package jp.ac.shibaura_it.infolab1.chat;

public class User {
    public String user;
    public String pwd;

    public User (String user, String pwd) {
        this.user = user;
        this.pwd = pwd;
    }

    public String getUser() {
        return user;
    }

    public String getPwd() {
        return pwd;
    }

}
