package app.attend_system.database.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import java.time.LocalDate;


@Entity
@Table(name = "employees")
public class Employee{
    @Id
    @Nonnull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer employee_ID;

    @Nonnull
    private String password;

    @Nonnull
    private String fullname;

    private Boolean gender;

    private LocalDate date_of_birth;

    private String department;

    private String email;

    private String phonenumber;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role_id;

    public Integer getId() {
        return employee_ID;
    }

    public String getPassword() {
        return password;
    }

    public String getFullname() {
        return fullname;
    }

    public Boolean getGender() {
        return gender;
    }

    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }
    
    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public Role getRole_id() {
        return role_id;
    }
}
