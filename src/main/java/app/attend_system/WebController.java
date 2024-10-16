package app.attend_system;

import app.attend_system.Schemas.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    User testUser = new User("Mystic","huh");
    
    @GetMapping("/hello")
    public String hello(@RequestParam(name="name", required = false, defaultValue = "World") String name) {
        return "Hello" + name;
    }

    @GetMapping("/user")
    public User getCurrentUser(){
        return testUser;
    }
    
    
}
