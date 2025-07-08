package jp.ac.shibaura_it.infolab1.chat;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ChatController {

    // チャネルID -> チャットログ一覧
    private final Map<String, List<ChatLog>> chatLogs = new HashMap<>();
    private final ChannelRegister channelRegister;

    public ChatController(ChannelRegister channelRegister) {
        this.channelRegister = channelRegister;
    }

    @GetMapping("/chat")
    public String showChat(HttpSession session, Model model) {
        String user = (String) session.getAttribute("user");
        String channel = (String) session.getAttribute("channel");

        if (user == null || channel == null) return "redirect:/login";

        chatLogs.putIfAbsent(channel, new ArrayList<>());
        model.addAttribute("user", user);
        model.addAttribute("logs", chatLogs.get(channel));

        Channel currentChannel = channelRegister.channels.get(channel);
        model.addAttribute("channelName", currentChannel != null ? currentChannel.getName() : "未設定");

        return "chat";
    }

    @PostMapping("/chat")
    public String postMessage(@RequestParam String message, HttpSession session, Model model) {
        String user = (String) session.getAttribute("user");
        String channel = (String) session.getAttribute("channel");

        if (user == null || channel == null) return "redirect:/login";

        if (message != null && !message.isBlank()) {
            chatLogs.computeIfAbsent(channel, k -> new ArrayList<>())
                    .add(new ChatLog(user, message));
        }

        model.addAttribute("user", user);
        model.addAttribute("logs", chatLogs.get(channel));

        Channel currentChannel = channelRegister.channels.get(channel);
        model.addAttribute("channelName", currentChannel != null ? currentChannel.getName() : "未設定");

        return "chat";
    }
}
