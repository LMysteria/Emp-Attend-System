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
@Table(name = "leave_requests")
public class LeaveRequest{
    @Id
    @Nonnull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leave_requests_ID;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "employee_ID")
    private Employee employee_ID;

    @Nonnull
    private Date start_date;

    @Nonnull
    private Date end_date;

    private String request_status;

    public LeaveRequest() {
    }

    public int getLeave_requests_ID() {
        return leave_requests_ID;
    }
    public Employee getEmployee_ID() {
        return employee_ID;
    }
    public Date getStart_date() {
        return start_date;
    }
    public Date getEnd_date() {
        return end_date;
    }
    public String getRequest_status() {
        return request_status;
    }
}

