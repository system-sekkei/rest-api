package example.viewmodel;

import example.model.greeting.Greeting;

import java.util.ArrayList;
import java.util.List;

public class HistoryResponse {

    public List<GreetingResponse> history;

    public HistoryResponse(List<GreetingResponse> list) {
        this.history = list;
    }

    static public HistoryResponse from(List<Greeting> list) {
        List<GreetingResponse> result = new ArrayList<>();
        for( Greeting each : list) {
            result.add(new GreetingResponse(each));
        }
        return new HistoryResponse(result);
    }
}
