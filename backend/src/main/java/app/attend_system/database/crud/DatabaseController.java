package app.attend_system.database.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.Iterator;
import app.attend_system.database.models.Employee;
import app.attend_system.database.models.Role;
@Controller
public class DatabaseController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RoleRepository roleRepository;

    public ArrayList<Employee> findAllEmployee(){
        ArrayList<Employee> employees = new ArrayList<Employee>();
       Iterator<Employee> emp_iter = employeeRepository.findAll().iterator();
       while (emp_iter.hasNext()) {
            employees.add(emp_iter.next());
       }
       return employees;
    }

    public Role createRole(Role newrole){
        return roleRepository.save(newrole);
    }
}   

