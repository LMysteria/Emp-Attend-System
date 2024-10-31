package app.attend_system.database.models;

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
@Table(name = "compliance_tracking")
public class ComplianceTracking {
    @Id
    @Nonnull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int compliance_ID;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "employee_ID")
    private Employee employee_ID;

    @Nonnull
    private String compliance_type;

    private String issued_warning;

    @Nonnull
    private Date start_tracking_date;

    private Date end_tracking_date;

    @Nonnull
    private int present=0;

    @Nonnull
    private int late=0;

    @Nonnull
    private int absent=0;

    @Nonnull
    private int on_leave=0;

    public ComplianceTracking() {
    }

    public int getCompliance_ID() {
        return compliance_ID;
    }
    public Employee getEmployee_ID() {
        return employee_ID;
    }
    public String getIssued_warning() {
        return issued_warning;
    }
    public Date getStart_tracking_date() {
        return start_tracking_date;
    }
    public Date getEnd_tracking_date() {
        return end_tracking_date;
    }
    public String getCompliance_type() {
        return compliance_type;
    }
    public int getPresent() {
        return present;
    }
    public int getAbsent() {
        return absent;
    }
    public int getLate() {
        return late;
    }
    public int getOn_leave() {
        return on_leave;
    }
}
