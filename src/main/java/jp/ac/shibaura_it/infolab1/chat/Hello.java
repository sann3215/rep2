package jp.ac.shibaura_it.infolab1.chat;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class Hello {
    @RequestMapping(value="/resthello")
    String hello() {
        return "Hello, World! %S".formatted(LocalDateTime.now());
    }
}
