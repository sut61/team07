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
@Table(name = "RecordDrugUse")
public class RecordDrugUse {
    @Id
    @SequenceGenerator(name = "RecordDrugUse_seq", sequenceName = "RecordDrugUse_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RecordDrugUse_seq")
    private Long RecordDrugUseId;
    private @NonNull String symptom;
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Drugdata", nullable = true)
	private Drugdata drugdata;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Pharmacist", nullable = true)
	private Pharmacist pharmacist;
		  
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Customer", nullable = true)
	private Customer  customer;

    private RecordDrugUse() {
    }


    public RecordDrugUse(String symptom,Drugdata drugdata,Pharmacist pharmacist,Customer  customer) {
        
        this.symptom = symptom;
        this.date = LocalDate.now();
        this.drugdata = drugdata;
        this.pharmacist = pharmacist;
        this.customer = customer;

    }

}