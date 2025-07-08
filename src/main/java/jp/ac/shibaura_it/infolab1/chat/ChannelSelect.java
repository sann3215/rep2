package jp.ac.shibaura_it.infolab1.chat;

import java.util.Map;

public class ChannelSelect {
    ChannelRegister channel = new ChannelRegister();

    public ChannelSelect (ChannelRegister channel) {
        this.channel = channel;
    }

    public boolean hasChannel (String channelName) {
        return channel.channels.containsKey(channelName);
    }

    public Map<String, Channel> getAllChannels () {
        return channel.channels;
    }
}
