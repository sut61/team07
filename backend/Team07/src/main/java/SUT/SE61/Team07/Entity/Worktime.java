package SUT.SE61.Team07.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.*;


@Entity
@Data
public class  Worktime{
    @Id
    @SequenceGenerator(name = "worktime_seq", sequenceName = "worktime_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "worktime_seq")
    private  Long timeId;

    @NotNull
    @Column(unique = true)
    private  String rangeTime;

    @NotNull
    @Max(13)
    @Min(3)
    private  Integer hrsAmount;

    public Worktime() {
    }

    public Worktime(String rangeTime, Integer hrsAmount) {
        this.rangeTime = rangeTime;
        this.hrsAmount = hrsAmount;
    }
}

