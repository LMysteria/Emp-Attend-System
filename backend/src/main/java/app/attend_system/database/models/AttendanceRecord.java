package app.attend_system.database.models;

import java.util.Date;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "attendance_record")
public class AttendanceRecord {
    @Id
    @Nonnull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attendance_ID;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "employee_ID")
    private Employee employee_ID;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "shift_schedules_ID")
    private ShiftSchedule shift_schedules_ID;

    @ManyToOne
    @JoinColumn(name = "compliance_ID")
    private ComplianceTracking compliance_ID;

    private Date attendance_date;

    @Column(columnDefinition = "varchar(15)")
    private String attendance_status;

    public AttendanceRecord() {
    }

    public int getAttendance_ID() {
        return attendance_ID;
    }
    public Date getAttendance_date() {
        return attendance_date;
    }
    public String getAttendance_status() {
        return attendance_status;
    }
    public ComplianceTracking getCompliance_ID() {
        return compliance_ID;
    }
    public Employee getEmployee_ID() {
        return employee_ID;
    }
    public ShiftSchedule getShift_schedules_ID() {
        return shift_schedules_ID;
    }
}
