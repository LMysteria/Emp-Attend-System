package app.attend_system;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
    
    @GetMapping("/hello")
    public String getMethodName(@RequestParam(name="name", required = false, defaultValue = "World") String name) {
        return "Hello" + name;
    }
    
}
