package jp.ac.shibaura_it.infolab1.chat;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ChannelController {

    private final ChannelRegister channelRegister;
    private final ChannelSelect channelSelect;

    public ChannelController(ChannelRegister channelRegister) {
        this.channelRegister = channelRegister;
        this.channelSelect = new ChannelSelect(channelRegister); // 同じインスタンス渡す
    }

    @GetMapping("/channels")
    public String showChannelPage(Model model) {
        model.addAttribute("channels", channelSelect.getAllChannels());
        return "channels";
    }

    @PostMapping("/channels/select")
    public String selectChannel(@RequestParam String ch, HttpSession session, Model model) {
        if (!channelSelect.hasChannel(ch)) {
            model.addAttribute("error", "チャネルが存在しません");
            model.addAttribute("channels", channelSelect.getAllChannels());
            return "channels";
        }
        session.setAttribute("channel", ch);
        return "redirect:/chat";
    }

    @PostMapping("/channels/register")
    public String registerChannel(@RequestParam String ch, Model model) {
        if (!channelRegister.addChannel(ch)) {
            model.addAttribute("error", "無効 または 既存のチャネルです");
        }
        model.addAttribute("channels", channelSelect.getAllChannels());
        return "channels";
    }
}
