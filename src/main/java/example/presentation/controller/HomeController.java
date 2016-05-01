package example.presentation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping
    public String top() {
        return "redirect:home";
    }
    @RequestMapping("home")
    public String home() {
        System.out.println("now home");
        return "home";
    }
}
