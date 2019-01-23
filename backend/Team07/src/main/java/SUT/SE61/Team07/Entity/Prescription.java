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
@Data
@Table(name = "Prescription")

public class Prescription {
    @Id
    @SequenceGenerator(name = "prescription_seq", sequenceName = "prescription_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prescription_seq")
    private Long PrescriptionId;
    private @NonNull String name;
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Drug", nullable = true)
	private Drug drug;
	
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Staff", nullable = true)
	private Staff staff;
		  
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Type", nullable = true)
	private Category  category;

    private Prescription() {
    }


    public Prescription(String name,Drug drug,Staff staff,Category category) {
        
        this.name = name;
        this.drug = drug;
        this.staff = staff;
        this.category = category;
        this.date = LocalDate.now();
    }

}