package jp.ac.shibaura_it.infolab1.chat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Chat {
    private List<String>chats = new ArrayList(List.of("Kenji: Hello","Dai: Hello,too!"));

    @RequestMapping(value="/hello")
    String hello(Model model) {
        model.addAttribute("chats", chats);
        return "home.html";
    }
}
