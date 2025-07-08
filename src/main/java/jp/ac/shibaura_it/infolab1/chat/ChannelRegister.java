package jp.ac.shibaura_it.infolab1.chat;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ChannelRegister {
    public Map<String, Channel> channels = new HashMap<>();

    public ChannelRegister () {
        addChannel("1");
    }

    public boolean addChannel (String channelName) {
        channelName = channelName.trim();
        if (!channelName.matches("^[a-zA-Z0-9\\p{Punct}]$")) {
            return false;
        }
        if (channels.containsKey(channelName)) {
            return false;
        }
        channels.put(channelName, new Channel("チャネル" + channelName));
        return true;
    }
}
