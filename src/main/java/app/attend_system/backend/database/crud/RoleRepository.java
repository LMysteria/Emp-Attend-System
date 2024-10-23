package app.attend_system.backend.database.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.attend_system.backend.database.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
}

