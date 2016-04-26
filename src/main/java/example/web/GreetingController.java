package example.web;

import example.model.Greeting;
import example.service.GreetingService;
import example.viewmodel.GreetingResponse;
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
    public GreetingResponse greeting(@RequestParam(value="name") String name) {
        if(name.isEmpty()) throw new IllegalArgumentException("exception");
        Greeting greeting = greetingService.greetTo(name);
        return new GreetingResponse(greeting);
    }

    @RequestMapping("object")
    public GreetingResponse greetingOfJson(@RequestBody GreetingRequest request) {
        Greeting greeting =  greetingService.greetTo(request.name());
        return new GreetingResponse(greeting);
    }
}
