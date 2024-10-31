package app.attend_system.database.crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import app.attend_system.database.models.ShiftSchedule;

@Repository
public interface ShiftScheduleRepository extends JpaRepository<ShiftSchedule, Integer>{
}