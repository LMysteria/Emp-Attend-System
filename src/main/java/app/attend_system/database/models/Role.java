package app.attend_system.database.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer role_id;

    private String role_name;

    private Integer access_level;

    public Integer getRole_id() {
        return role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public Integer getAccess_level() {
        return access_level;
    }
}
