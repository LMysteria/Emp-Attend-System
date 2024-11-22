package app.attend_system.database.schemas;

public class CreateEmployeeSchema {
    private String employee_ID;

    private String password;
    
    private String fullname;

    private String gender;

    private String date_of_birth;

    private String department;

    private String email;

    private String phone_number;

    private int role_id;

    public CreateEmployeeSchema(String employee_ID, String fullname, String password, String gender, String date_of_birth, String department, String email, String phone_number, int role_id){
        this.employee_ID = employee_ID;
        this.fullname = fullname;
        this.password = password;
        this.gender = gender;
        this.date_of_birth= date_of_birth;
        this.department = department;
        this.email = email;
        this.phone_number = phone_number;
        this.role_id = role_id;
    }

    public String getEmployee_ID() {
        return employee_ID;
    }
    public String getFullname() {
        return fullname;
    }
    public String getPassword() {
        return password;
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
    public int getRole() {
        return role_id;
    }
}