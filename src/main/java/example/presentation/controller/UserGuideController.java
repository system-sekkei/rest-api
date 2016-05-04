package example.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class UserGuideController {

    @RequestMapping
    public String top() {
        return "redirect:userguide";
    }

    @RequestMapping("userguide")
    public String userguide() {
        return "userguide";
    }
}
