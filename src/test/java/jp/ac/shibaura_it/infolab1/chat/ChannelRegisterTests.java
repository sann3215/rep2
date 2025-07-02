package jp.ac.shibaura_it.infolab1.chat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ChannelRegisterTests {

    private ChannelRegister chReg;

    @BeforeEach
    void setUp() {
        chReg = new ChannelRegister();
    }

    @Test
    void testAddValidChannel() {
        assertThat(chReg.addChannel("2")).isTrue();
    }

    @Test
    void testAddInvalidChannel() {
        assertThat(chReg.addChannel("2")).isTrue();
        assertThat(chReg.addChannel("2")).isFalse();
        assertThat(chReg.addChannel("")).isFalse();
    }
}
