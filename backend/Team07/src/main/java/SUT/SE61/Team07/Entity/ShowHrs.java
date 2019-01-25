package SUT.SE61.Team07.Entity;

import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
@Table(name = "ShowHrs")
public class ShowHrs {
    @Id
    @SequenceGenerator(name = "showHrs_seq", sequenceName = "showHrs_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "showHrs_seq")
    private @NonNull Long showId;

    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "deptId")
    private Department department;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "timeId")
    private Worktime worktime;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staffId")
    private Staff staff;

    private ShowHrs() {
    }

    public ShowHrs(Staff staff ,Department department, Worktime worktime) {
        this.department = department;
        this.worktime = worktime;
        this.staff = staff;
        this.date = LocalDate.now();
    }

}