package jp.ac.shibaura_it.infolab1.chat;


import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RegisterTests {

    @Test
    void testValidUser() {
        User user = new User("hisazumi", "hogehoge");
        Register reg = new Register();
        assertThat(reg.register(user)).isTrue();
    }

    @Test
    void testSameUser () {
        User user1 = new User("hisazumi", "hogehoge");
        User user2 = new User("hisazumi", "hogehoge");
        User user3 = new User("hisazumi", "hgoehoge1");
        Register reg = new Register();
        assertThat(reg.register(user1)).isTrue();
        assertThat(reg.register(user2)).isFalse();
        assertThat(reg.register(user3)).isFalse();
    }

    @Test
    void testInvalidUser () {
        User user1 = new User("****", "hogehoge");
        Register reg = new Register();
        assertThat(reg.register(user1)).isFalse();
    }

    @Test
    void testInvalidPwd () {
        User user = new User("hisazumi", "****");
        Register reg = new Register();
        assertThat(reg.register(user)).isFalse();
    }
}
