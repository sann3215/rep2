package jp.ac.shibaura_it.infolab1.chat;

import java.util.HashMap;
import java.util.Map;

public class Register {
    public Map<String, String> userDataBase;

    public Register () {
        this.userDataBase = new HashMap<>();
    }

    public boolean register (User usr) {
        if (!this.validate(usr)) {
            return false;
        }

        String existUser = userDataBase.get(usr.getUser());
        if (existUser != null && existUser.equals(usr.getPwd())) {
            return false;
        }

        if (existUser != null) {
            return false;
        }

        userDataBase.put(usr.getUser(), usr.getPwd());
        return true;
    }

    public Map<String, String> getUserDataBase() {
        return userDataBase;
    }

    public boolean validate(User usr) {
        return usr.user.matches("^[a-zA-Z0-9]+$") && usr.pwd.matches("^[a-zA-Z0-9]+$");
    }
}
