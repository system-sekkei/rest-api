package example.web;

import example.model.Greeting;
import example.service.GreetingService;
import example.viewmodel.GreetingJSONView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    @RequestMapping("/greeting")
    public GreetingJSONView greeting(@RequestParam(value="name") String name) {
        if(name.isEmpty()) throw new IllegalArgumentException("exception");
        Greeting greeting = greetingService.greetTo(name);
        return new GreetingJSONView(greeting);
    }

}
