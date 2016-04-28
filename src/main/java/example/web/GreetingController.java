package example.web;

import example.model.greeting.Greeting;
import example.model.greeting.GreetingHistory;
import example.service.GreetingService;
import example.viewmodel.GreetingResponse;
import example.viewmodel.GreetingRequest;
import example.viewmodel.HistoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    @RequestMapping(method= RequestMethod.GET)
    public GreetingResponse greeting(@RequestParam(value="name") String name) {
        if(name.isEmpty()) throw new IllegalArgumentException("exception");
        return generateGreetingResponse(name);
    }

    @RequestMapping(method = RequestMethod.POST)
    public GreetingResponse greetingOfJson(@RequestBody GreetingRequest request) {
        String name = request.name();
        return generateGreetingResponse(name);
    }

    private GreetingResponse generateGreetingResponse(@RequestParam(value = "name") String name) {
        Greeting greeting = greetingService.generate(name);
        greetingService.recordRequest(greeting);
        return new GreetingResponse(greeting);
    }

    @RequestMapping(value = "history", method = RequestMethod.POST)
    public HistoryResponse history() {
        GreetingHistory history = greetingService.history();
        return HistoryResponse.from(history);
    }
}
