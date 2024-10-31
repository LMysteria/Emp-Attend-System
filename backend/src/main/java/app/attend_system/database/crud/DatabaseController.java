package app.attend_system.database.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.Iterator;
import app.attend_system.database.models.Employee;
import app.attend_system.database.models.Role;
import app.attend_system.database.schemas.EmployeeSchema;
import app.attend_system.database.schemas.RoleSchema;
@Controller
public class DatabaseController {
    //split this controller if neccesary
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    //GET QUERY
    public ArrayList<EmployeeSchema> findallEmployee(){
        ArrayList<EmployeeSchema> employees = new ArrayList<EmployeeSchema>();
       Iterator<Employee> emp_iter = employeeRepository.findAll().iterator();
       while (emp_iter.hasNext()) {
            Employee nextemp = emp_iter.next();
            employees.add(new EmployeeSchema(nextemp.getId(), nextemp.getFullname(), nextemp.getGender(), nextemp.getDate_of_birth(),
            nextemp.getDepartment(), nextemp.getEmail(), nextemp.getPhonenumber(), nextemp.getRole_id()));
       }
       return employees;
    }

    public ArrayList<Role> findallRole(){
        ArrayList<Role> roles = new ArrayList<Role>();
       Iterator<Role> role_iter = roleRepository.findAll().iterator();
       while (role_iter.hasNext()) {
            roles.add(role_iter.next());
       }
       return roles;
    }

    //CREATE QUERY
    public Role createRole(RoleSchema newrole){
        return roleRepository.save(new Role(newrole.getRole_name(), newrole.getAccess_level()));
    }

    public Employee createEmployee(Employee newEmployee){
        return employeeRepository.save(newEmployee);
    }
}   

