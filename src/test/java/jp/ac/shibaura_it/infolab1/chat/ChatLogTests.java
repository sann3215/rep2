package jp.ac.shibaura_it.infolab1.chat;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class ChatLogTests {

    @Test
    void testChatLog() {
        ChatLog entry = new ChatLog("hisazumi", "Hi there");
        assertThat(entry.log()).isEqualTo("hisazumi : Hi there");
    }
}
