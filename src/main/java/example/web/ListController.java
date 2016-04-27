package example.web;

import example.model.greeting.Greeting;
import example.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/list")
public class ListController {

    @Autowired
    GreetingService greetingService;

    @RequestMapping("all")
    public List<Greeting> listAll() {
        List<Greeting> history = greetingService.list();
        for(Greeting greeting : history) {
            System.out.println(greeting);
        }
        return history;
    }
}
