package jp.ac.shibaura_it.infolab1.chat;

import java.util.ArrayList;
import java.util.List;

public class Channel {
    public String channelName;
    public List<ChatLog> logs = new ArrayList<>();

    public Channel (String channelName) {
        this.channelName = channelName;
    }

    public String getName () {
        return channelName;
    }

    public void addLog (ChatLog log) {
        logs.add(log);
    }

    public List<ChatLog> getLogs () {
        return logs;
    }

}
