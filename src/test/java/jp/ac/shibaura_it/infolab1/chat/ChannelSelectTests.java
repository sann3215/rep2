package jp.ac.shibaura_it.infolab1.chat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.assertj.core.api.Assertions.assertThat;


public class ChannelSelectTests {

    private ChannelSelect chSel;

    @BeforeEach
    void setUp() {
        chSel = new ChannelSelect();
        chSel.getAllChannels().put("1", new Channel("チャネル1"));
        chSel.getAllChannels().put("X", new Channel("チャネルX"));
    }

    @Test
    void testHasChannelTrue() {
        assertThat(chSel.hasChannel("1")).isTrue();
        assertThat(chSel.hasChannel("X")).isTrue();
    }

    @Test
    void testHasChannelFalse() {
        assertThat(chSel.hasChannel("2")).isFalse();
    }

    @Test
    void testGetAllChannels() {
        Map<String, Channel> map = chSel.getAllChannels();
        assertThat(map.size()).isEqualTo(2);
        assertThat(map.containsKey("1")).isTrue();
        assertThat(map.containsKey("X")).isTrue();
    }
}
