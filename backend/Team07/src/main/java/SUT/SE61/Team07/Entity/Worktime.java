package SUT.SE61.Team07.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
@Table(name = "Worktime")
public class Worktime {
    @Id
    @SequenceGenerator(name = "worktime_seq", sequenceName = "worktime_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "worktime_seq")
    private @NonNull Long timeId;
    private @NonNull String rangeTime;
    private @NonNull Integer hrsAmount;

    private Worktime() {
    }

    public Worktime(String rangeTime, Integer hrsAmount) {
        this.rangeTime = rangeTime;
        this.hrsAmount = hrsAmount;
    }
}

