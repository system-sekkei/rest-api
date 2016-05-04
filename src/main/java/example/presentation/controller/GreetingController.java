package example.presentation.controller;

import example.domain.model.greeting.Greeting;
import example.domain.model.greeting.GreetingHistory;
import example.application.service.GreetingService;
import example.presentation.view.greeting.GreetingResponse;
import example.presentation.view.greeting.GreetingRequest;
import example.presentation.view.greeting.HistoryResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api(value = "挨拶API", description = "挨拶を返すAPI")
@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    GreetingService greetingService;

    @ApiOperation(value = "挨拶の取得", nickname = "挨拶 GET", notes = "名前を渡すと挨拶を返す<br>GET バージョン")
    @RequestMapping(method= RequestMethod.GET)
    public GreetingResponse greeting(@ModelAttribute @Validated GreetingRequest request) {
        return generateGreetingResponse(request);
    }

    @RequestMapping(method = RequestMethod.POST)
    public GreetingResponse greetingOfJson(@RequestBody @Validated GreetingRequest request) {
        return generateGreetingResponse(request);
    }

    private GreetingResponse generateGreetingResponse(GreetingRequest request) {
        Greeting greeting = greetingService.generate(request.name());
        greetingService.recordRequest(greeting);
        return new GreetingResponse(greeting);
    }

    @RequestMapping(value = "history", method = RequestMethod.GET)
    public HistoryResponse history() {
        GreetingHistory history = greetingService.history();
        return HistoryResponse.from(history);
    }
}
