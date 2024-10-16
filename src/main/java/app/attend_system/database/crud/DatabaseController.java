package app.attend_system.database.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;
import java.util.Iterator;
import app.attend_system.database.models.Employee;

@Controller
public class DatabaseController {
    @Autowired
    private EmployeeRepository employeeRepository;

    public ArrayList<Employee> findAllEmployee(){
        ArrayList<Employee> employees = new ArrayList<Employee>();
       Iterator<Employee> emp_iter = employeeRepository.findAll().iterator();
       while (emp_iter.hasNext()) {
            employees.add(emp_iter.next());
       }
       return employees;
    }


    
}