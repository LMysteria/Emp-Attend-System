package app.attend_system.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import app.attend_system.backend.database.models.Role;
import com.google.gson.Gson;

import app.attend_system.backend.database.schemas.*;
import app.attend_system.backend.database.crud.DatabaseController;
import org.springframework.web.bind.annotation.RequestBody;



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

    @PostMapping("/createRole")
    public Role newRole(@RequestBody() Role newrole) { 
        return dbController.createRole(newrole);
    }
    
}
