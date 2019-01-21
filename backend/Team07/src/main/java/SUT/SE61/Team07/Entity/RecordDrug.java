package SUT.SE61.Team07.Entity;

import javax.persistence.Entity;
import java.time.LocalDate;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
import javax.persistence.ManyToOne;
import java.util.*;	

@Entity
@Getter @Setter
@Data
@Table(name = "RecordDrug")
public class RecordDrug {
    @Id
    @SequenceGenerator(name = "RecordDrug_seq", sequenceName = "RecordDrug_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RecordDrug_seq")
    private Long RecordDrugId;
    private @NonNull String symptom;
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Drug", nullable = true)
	private Drug drug;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Phamacist", nullable = true)
	private Phamacist phamacist;
		  
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Customer", nullable = true)
	private Customer  customer;

    private RecordDrug() {
    }


    public RecordDrug(String symptom,Drug drug,Phamacist phamacist,Customer  customer) {
        
        this.symptom = symptom;
        this.date = LocalDate.now();
        this.drug = drug;
        this.phamacist = phamacist;
        this.customer = customer;

    }

}