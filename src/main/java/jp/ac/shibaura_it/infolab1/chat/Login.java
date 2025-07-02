package jp.ac.shibaura_it.infolab1.chat;

import java.util.Map;

public class Login {
    public Map<String, String> userDataBase;

    public Login(Map<String ,String> userDataBase) {
        this.userDataBase = userDataBase;
    }

    public boolean loginService (String user, String pwd) {
        return userDataBase.containsKey(user) && userDataBase.get(user).equals(pwd);
    }
}
