package example.web;

import example.model.user.UserSummaries;
import example.model.user.UserSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/list")
public class ListController {

    @Autowired
    UserService userService;

    @RequestMapping("all")
    public UserSummaries listAll() {
        UserSummaries summaries = userService.list();
        for(UserSummary user : summaries.list()) {
            System.out.println(user);
        }
        return summaries;
    }
}
