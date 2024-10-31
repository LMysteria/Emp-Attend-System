package app.attend_system;

import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    
    @GetMapping("/")
    public String MainPage() {
        return "This is the main page of Attendance System";
    }

    //GET APIs
    @GetMapping("/getallEmployee")
    public String getallEmployee(){
        String action = "getallEmployee";
        Instant start = Instant.now();

        Gson gson = new Gson();
        String response = gson.toJson(dbController.findallEmployee());

        long timeElapse = Duration.between(start, Instant.now()).toMillis();
        System.out.println(Utility.log(action, timeElapse));
        return response;
    }

    @GetMapping("/getallRole")
    public String getallRole(){
        String action = "getallRole";
        Instant start = Instant.now();

        Gson gson = new Gson();
        String response = gson.toJson(dbController.findallRole());

        long timeElapse = Duration.between(start, Instant.now()).toMillis();
        System.out.println(Utility.log(action, timeElapse));
        return response;
    }

    //POST APIs
    @PostMapping("/createRole")
    public Role newRole(@RequestBody() RoleSchema newrole) { 
        String action = "createRole";
        Instant start = Instant.now();        
        
        Role response = dbController.createRole(newrole);

        long timeElapse = Duration.between(start, Instant.now()).toMillis();
        System.out.println(Utility.log(action, timeElapse));
        return response;
    }

    @PostMapping("/createEmployee")
    public Employee newEmployee(@RequestBody() Employee newEmployee) {
        String action = "createEmployee";
        Instant start = Instant.now();        

        Employee response = dbController.createEmployee(newEmployee);

        long timeElapse = Duration.between(start, Instant.now()).toMillis();
        System.out.println(Utility.log(action, timeElapse));
        return response;
    }
    
    
}
