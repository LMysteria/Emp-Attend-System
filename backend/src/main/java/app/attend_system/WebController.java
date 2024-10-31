package app.attend_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.attend_system.database.models.Employee;
import app.attend_system.database.models.Role;
import com.google.gson.Gson;

import app.attend_system.database.schemas.*;
import app.attend_system.database.crud.DatabaseController;
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

    @GetMapping("/getallEmployee")
    public String getallEmployee(){
        Gson gson = new Gson();
        return gson.toJson(dbController.findallEmployee());
    }

    @GetMapping("/getallRole")
    public String getallRole(){
        Gson gson = new Gson();
        return gson.toJson(dbController.findallRole());
    }

    @PostMapping("/createRole")
    public Role newRole(@RequestBody() RoleSchema newrole) { 
        return dbController.createRole(newrole);
    }

    @PostMapping("/createEmployee")
    public Employee newEmployee(@RequestBody() Employee newEmployee) {
        return dbController.createEmployee(newEmployee);
    }
    
    
}
