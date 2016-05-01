package example.presentation.view;

import example.domain.model.greeting.Greeting;
import example.domain.model.greeting.GreetingHistory;

import java.util.ArrayList;
import java.util.List;

public class HistoryResponse {

    public List<GreetingResponse> history;

    public HistoryResponse(List<GreetingResponse> list) {
        this.history = list;
    }

    static public HistoryResponse from(GreetingHistory history) {
        List<GreetingResponse> result = new ArrayList<>();
        
        for( Greeting each : history.asList()) {
            result.add(new GreetingResponse(each));
        }
        
        return new HistoryResponse(result);
    }
}
