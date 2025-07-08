package jp.ac.shibaura_it.infolab1.chat;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AuthController {

    private final Register register;

    public AuthController() {
        this.register = new Register(); // 本来はDIで管理するのが理想
    }

    @GetMapping("/register")
    public String showRegisterForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String user, @RequestParam String pwd, Model model) {
        if (register.register(new User(user, pwd))) {
            model.addAttribute("message", "登録成功しました");
            return "login";
        } else {
            model.addAttribute("error", "無効な入力 または 既に登録済みです");
            return "register";
        }
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String user, @RequestParam String pwd, HttpSession session, Model model) {
        Login login = new Login(register.getUserDataBase());
        if (login.loginService(user, pwd)) {
            session.setAttribute("user", user);
            return "redirect:/channels";
        } else {
            model.addAttribute("error", "ユーザ名またはパスワードが間違っています");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}