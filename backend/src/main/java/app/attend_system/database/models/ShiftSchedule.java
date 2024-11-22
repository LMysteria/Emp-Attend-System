package app.attend_system.database.models;

import java.sql.Time;
import java.util.Date;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="shift_schedules")
public class ShiftSchedule {
    @Id
    @Nonnull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int shift_schedules_ID;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "employee_ID")
    private Employee employee_ID;

    @Nonnull
    private Date shift_date;

    @Nonnull
    private Time shift_start;

    @Nonnull
    private Time shift_end;

    @Nonnull
    private boolean isleave;

    @ManyToOne
    @JoinColumn(name = "leave_requests_ID")
    private LeaveRequest leave_requests_ID;

    public ShiftSchedule() {
    }

    public Employee getEmployee_ID() {
        return employee_ID;
    }
    public LeaveRequest getLeave_requests_ID() {
        return leave_requests_ID;
    }
    public int getShift_schedules_ID() {
        return shift_schedules_ID;
    }
    public Date getShift_date() {
        return shift_date;
    }
    public Time getShift_start() {
        return shift_start;
    }
    public Time getShift_end() {
        return shift_end;
    }
}
