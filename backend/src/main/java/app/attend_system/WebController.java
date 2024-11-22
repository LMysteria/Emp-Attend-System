package app.attend_system;


import java.sql.Date;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

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
    Gson gson = new Gson();

    @GetMapping("/")
    //return a filler main page
    public String MainPage() {
        return "This is the main page of Attendance System";
    }

    //GET APIs
    @GetMapping("/getallEmployee")
    public String getallEmployee(){
        /*
        Return all employees in json

        Return Format:
        [{
            "employee_ID": EmployeeID               String(6),
            "fullname": Employee name               String,
            "gender": "F"/"M"                       String(1)   (F for female, M for Male),
            "date_of_birth": "yyyy-MM-dd"           String,
            "department": Department name           String,
            "email": Employee email                 String,
            "phone_number": Employee phonenumber    String,
            "role": Employee role name              String,
        },
        {...}
        ]

        Successful Return Example:
        [{"employee_ID":"MYSTIC","fullname":"Lunaria Mystic","gender":"M","date_of_birth":"2003-12-01","department":"TestDept","email":"test@mail.com","phone_number":"0834011203","role":"admin"}]
         */
        String action = "getallEmployee";
        Instant start = Instant.now();

        String response = gson.toJson(dbController.findallEmployee());

        long timeElapse = Duration.between(start, Instant.now()).toMillis();
        System.out.println(Utility.log(action, timeElapse));
        return response;
    }

    @GetMapping("/getallRole")
    public String getallRole(){
        /*
        Return all roles in json

        Return format:
        [{
            "role_id": Role ID                      int,
            "role_name": Role name                  String,
            "access_level": Access level            int     (higher access level, higher permsission),
        },
        {...}
        ]

        Successful Return Example:
        [{"role_id":1,"role_name":"admin","access_level":3},{"role_id":2,"role_name":"Tester","access_level":2}]
        */

        String action = "getallRole";
        Instant start = Instant.now();

        String response = gson.toJson(dbController.findallRole());

        long timeElapse = Duration.between(start, Instant.now()).toMillis();
        System.out.println(Utility.log(action, timeElapse));
        return response;
    }

    //POST APIs
    @PostMapping("/createRole")
    public Role newRole(@RequestBody() RoleSchema newrole) { 
        /*
            Input new role in request body to create new Role in database and return created role

            Request and Return Format:
            {
            "role_id": Role ID                      int,
            "role_name": Role name                  String,
            "access_level": Access level            int     (higher access level, higher permsission),
            }

            Request body Example:
            {"role_id":1,"role_name":"admin","access_level":3}

            Successful Return Example:
            {"role_id":1,"role_name":"admin","access_level":3}
        */
        String action = "createRole";
        Instant start = Instant.now();        
        
        Role response = dbController.createRole(newrole);

        long timeElapse = Duration.between(start, Instant.now()).toMillis();
        System.out.println(Utility.log(action, timeElapse));
        return response;
    }
    

    @PostMapping("/createEmployee")
    public EmployeeSchema newEmployee(@RequestBody CreateEmployeeSchema newEmployee) throws Exception {
        /*
            Input new employee in request body to create new Employee in database and return created employee

            Request Format:
            {
                "employee_ID": EmployeeID               String(6),
                "password": Employee Password,
                "fullname": Employee name               String,
                "gender": "F"/"M"                       String(1)   (F for female, M for Male),
                "date_of_birth": "yyyy-MM-dd"           String,
                "department": Department name           String,
                "email": Employee email                 String,
                "phone_number": Employee phonenumber    String,
                "role_id": Role ID                      int,
            }
            
            Return Format:
            {
            "employee_ID": EmployeeID               String(6),
            "fullname": Employee name               String,
            "gender": "F"/"M"                       String(1)   (F for female, M for Male),
            "date_of_birth": "yyyy-MM-dd"           String,
            "department": Department name           String,
            "email": Employee email                 String,
            "phone_number": Employee phonenumber    String,
            "role": Employee role name              String,
            }

            Request Example:
            {
                "employee_ID": "TESTER",
                "password": "Testing123!",
                "fullname": "Test User",
                "gender": "F",
                "date_of_birth": "2001-01-21",
                "department": "Tester Department",
                "email": "testermail@gmail.com",
                "phone_number": "0834011203",
                "role_id": 2
            }

            Successful Return Example:
            {"employee_ID":"TESTER","fullname":"Test User","gender":"F","date_of_birth":"2001-01-21","department":"Tester Department","email":"testermail@gmail.com","phone_number":"0834011203","role":"Tester"}
        */

        try {
            String action = "createEmployee";
            Instant start = Instant.now();        
            
            Optional<Role> dbrole = dbController.findRolebyRole_id(newEmployee.getRole());
            if (!dbrole.isPresent()){
                throw new Exception("Invalid Role ID");
            }
            Employee response = dbController.createEmployee(new Employee(newEmployee.getEmployee_ID(), newEmployee.getPassword(), newEmployee.getFullname(), newEmployee.getGender(), Date.valueOf(newEmployee.getDate_of_birth()), newEmployee.getDepartment(), newEmployee.getEmail(), newEmployee.getPhone_number(), dbrole.get()));
    
            long timeElapse = Duration.between(start, Instant.now()).toMillis();
            System.out.println(Utility.log(action, timeElapse));
            
            return new EmployeeSchema(response);
        } catch (Exception e) {
            throw e;
        }
    }
    
    
}
