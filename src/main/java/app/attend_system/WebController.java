package app.attend_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import app.attend_system.database.schemas.*;
import app.attend_system.database.crud.DatabaseController;


@RestController
public class WebController {
    @Autowired
    DatabaseController dbController;
    User testUser = new User("Mystic","huh");
    
    @GetMapping("/hello")
    public String hello(@RequestParam(name="name", required = false, defaultValue = "World") String name) {
        return "Hello" + name;
    }

    @GetMapping("/getAllEmployee")
    public String getCurrentUser(){
        Gson gson = new Gson();
        return gson.toJson(dbController.findAllEmployee());
    }
}
