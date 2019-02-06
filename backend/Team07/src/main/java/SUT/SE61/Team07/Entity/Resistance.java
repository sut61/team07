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
public class Resistance {
    @Id
    @SequenceGenerator(name = "resistance_seq", sequenceName = "resistance_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resistance_seq")

    @NotNull(message = "symptom  must not be null to be valid")
    private Long resistanceId;

    //@NotNull(message = "symptom  must not be null to be valid")
   // private String symptom;

    //@NotNull
    //private Date date;

    private String resist;

    @NotNull
    @OneToOne
    private RecordDrugUse recordDrugUse;

    public Resistance(){

    }

    public Resistance(RecordDrugUse recordDrugUse,String resist){
        this.recordDrugUse = recordDrugUse;
        this.resist = resist;

    }


    

}