package jp.ac.shibaura_it.infolab1.chat;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class Chat {
    private List<String>chats = new ArrayList(List.of("Kenji: Hello","Dai: Hello,too!"));

    @Autowired
    HttpSession session;

    @RequestMapping(value="/hello")
    String hello(Model model) {
        model.addAttribute("chats", chats);
        model.addAttribute("name", session.getAttribute("name"));
        return "home.html";
    }

    @RequestMapping(value="/add")
    String addChat(@RequestParam("name") String name,
                   @RequestParam("chat")String chat, Model model) {
        chats.add(name + ":" +chat);
        session.setAttribute("name", name);
        return "redirect:/hello";
    }
}
