package example.web;

import example.model.greeting.Greeting;
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
        return generateGreetingResponse(name);
    }

    @RequestMapping("object")
    public GreetingResponse greetingOfJson(@RequestBody GreetingRequest request) {
        String name = request.name();
        return generateGreetingResponse(name);
    }

    private GreetingResponse generateGreetingResponse(@RequestParam(value = "name") String name) {
        Greeting greeting = greetingService.greetTo(name);
        greetingService.recordRequest(greeting);
        return new GreetingResponse(greeting);
    }
}
