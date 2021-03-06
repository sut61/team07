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
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.validation.constraints.*;

@Entity
@Data
public class Resistance {
    @Id
    @SequenceGenerator(name = "resistance_seq", sequenceName = "resistance_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "resistance_seq")

    @NotNull
    private Long resistanceId;

    @NotNull
    @Column(unique = true)
    private Date date;

    @NotNull(message = "resist  must not be null to be valid")
    @Size(min = 6, max = 8)
    @Pattern(regexp = "[NR][A-Za-z]{5,8}")
    private String resist;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recordDrugUseId")
    private RecordDrugUse recordDrugUse;

    

    public Resistance() {

    }

    public Resistance(RecordDrugUse recordDrugUse, String resist) {
        this.recordDrugUse = recordDrugUse;
        this.resist = resist;
        this.date = new Date();

    }

}