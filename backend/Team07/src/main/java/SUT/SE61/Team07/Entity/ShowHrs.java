package SUT.SE61.Team07.Entity;

import lombok.*;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.validation.constraints.*;

@Entity
@Data
public class ShowHrs {
    @Id
    @SequenceGenerator(name = "showHrs_seq", sequenceName = "showHrs_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "showHrs_seq")

    @NotNull(message="showhrs Id must not be null to be valid")
    private  Long showId;

    @NotNull 
    private  Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deptId")
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "timeId")
    private Worktime worktime;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staffId")
    private Staff staff;

    public ShowHrs() {
    }

    public ShowHrs(Staff staff ,Department department, Worktime worktime) {
        this.department = department;
        this.worktime = worktime;
        this.staff = staff;
        this.date = new Date();
    }

}