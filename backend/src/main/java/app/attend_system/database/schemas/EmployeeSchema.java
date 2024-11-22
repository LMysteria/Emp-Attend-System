package app.attend_system.database.schemas;

import java.text.SimpleDateFormat;

import app.attend_system.database.models.Employee;

public class EmployeeSchema {
    private String employee_ID;

    private String fullname;

    private String gender;

    private String date_of_birth;

    private String department;

    private String email;

    private String phone_number;

    private String role;

    public EmployeeSchema(Employee employee){
        this.employee_ID = employee.getId();
        this.fullname = employee.getFullname();
        this.gender = employee.getGender();
        this.date_of_birth = new SimpleDateFormat("yyyy-MM-dd").format(employee.getDate_of_birth());
        this.department = employee.getDepartment();
        this.email = employee.getEmail();
        this.phone_number = employee.getPhonenumber();
        this.role = employee.getRole().getRole_name();
    }

    public String getEmployee_ID() {
        return employee_ID;
    }
    public String getFullname() {
        return fullname;
    }
    public String getGender() {
        return gender;
    }
    public String getDate_of_birth() {
        return date_of_birth;
    }
    public String getEmail() {
        return email;
    }
    public String getDepartment() {
        return department;
    }
    public String getPhone_number() {
        return phone_number;
    }
    public String getRole() {
        return role;
    }
}