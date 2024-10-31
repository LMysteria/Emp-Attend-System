package app.attend_system.database.schemas;

import java.util.Date;
import app.attend_system.database.models.Role;

public class EmployeeSchema {
    private String employee_ID;

    private String fullname;

    private String gender;

    private Date date_of_birth;

    private String department;

    private String email;

    private String phone_number;

    private Role role;

    public EmployeeSchema(String employee_ID, String fullname, String gender, Date date_of_birth, String department, String email, String phone_number, Role role){
        this.employee_ID = employee_ID;
        this.fullname = fullname;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.department = department;
        this.email = email;
        this.phone_number = phone_number;
        this.role = role;
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
    public Date getDate_of_birth() {
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
    public Role getRole() {
        return role;
    }
}