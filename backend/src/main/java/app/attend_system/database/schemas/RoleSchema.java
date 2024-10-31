package app.attend_system.database.schemas;

public class RoleSchema {
    
    private String role_name;

    private Integer access_level;

    public String getRole_name() {
        return role_name;
    }

    public Integer getAccess_level() {
        return access_level;
    }
}
