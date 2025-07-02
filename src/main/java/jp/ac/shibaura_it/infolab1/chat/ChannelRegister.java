package jp.ac.shibaura_it.infolab1.chat;

import java.util.HashMap;
import java.util.Map;

public class ChannelRegister {
    public Map<String, Channel> channels;

    public ChannelRegister () {
        this.channels = new HashMap<>();
        addChannel("1");
    }

    public boolean addChannel (String channelName) {
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
