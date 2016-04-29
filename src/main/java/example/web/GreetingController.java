package example.web;

import example.model.greeting.Greeting;
import example.model.greeting.GreetingHistory;
import example.service.GreetingService;
import example.transfer.model.GreetingResponse;
import example.transfer.model.GreetingRequest;
import example.transfer.model.HistoryResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "挨拶API", description = "挨拶を返すAPI")
@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    @ApiOperation(value = "挨拶の取得", nickname = "挨拶 GET", notes = "名前を渡すと挨拶を返す<br>GET バージョン")
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
