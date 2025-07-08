package jp.ac.shibaura_it.infolab1.chat;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    public String channelName;

    public Channel (String channelName) {
        this.channelName = channelName;
    }

    public String getName () {
        return channelName;
    }
}
