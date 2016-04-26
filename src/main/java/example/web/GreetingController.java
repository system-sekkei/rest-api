package example.web;

import example.model.Greeting;
import example.service.GreetingService;
import example.viewmodel.GreetingJSONView;
import example.viewmodel.GreetingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    @RequestMapping("params")
    public GreetingJSONView greeting(@RequestParam(value="name") String name) {
        if(name.isEmpty()) throw new IllegalArgumentException("exception");
        Greeting greeting = greetingService.greetTo(name);
        return new GreetingJSONView(greeting);
    }

    @RequestMapping("object")
    public GreetingJSONView greetingOfJson(@RequestBody GreetingRequest request) {
        System.out.println("request=" + request);
        Greeting greeting =  greetingService.greetTo(request.name());
        return new GreetingJSONView(greeting);
    }
}
