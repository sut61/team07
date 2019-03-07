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

public class TimeEat {
    @Id
    @SequenceGenerator(name = "timeEat_seq", sequenceName = "timeEat_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "timeEat_seq")
    private  Long timeEatId;
    
    
    @NotNull(message = "timeEatName not null")
    @Size(min =5 ,max = 20)
    private String timeEatName;

    public TimeEat() {
    }

    public TimeEat(String timeEatName) {
        this.timeEatName = timeEatName;

    }
   
}
