package app.attend_system.database.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "employees")
public class Employee{
    @Id
    @Nonnull
    private String employee_ID;

    @Nonnull
    private String password;

    @Nonnull
    private String fullname;

    private String gender;

    private Date date_of_birth;

    private String department;

    private String email;

    private String phone_number;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role_id;

    public String getId() {
        return employee_ID;
    }

    public String getPassword() {
        return password;
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
    
    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonenumber() {
        return phone_number;
    }

    public Role getRole_id() {
        return role_id;
    }
}
