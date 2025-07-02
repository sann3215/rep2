package jp.ac.shibaura_it.infolab1.chat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginTests {

    private Login login;

    @BeforeEach
    void setup () {
        User user = new User("hisazumi", "hogehoge");
        Register reg = new Register();
        reg.register(user);
        login = new Login(reg.getUserDataBase());

    }

    @Test
    void testValidLogin () {
        assertThat(login.loginService("hisazumi", "hogehoge")).isTrue();
    }

    @Test
    void testLoginToInvalidUser () {
        assertThat(login.loginService("tanaka", "hogehoge")).isFalse();
    }

    @Test
    void testLoginToInvalidPwd () {
        assertThat(login.loginService("hisazumi", "hoguhogu")).isFalse();
    }
}
