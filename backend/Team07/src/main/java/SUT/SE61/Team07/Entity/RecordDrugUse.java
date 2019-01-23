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
@Getter
@Setter
@Table(name = "RecordDrug")
public class RecordDrugUse {
    @Id
    @SequenceGenerator(name = "RecordDrug_seq", sequenceName = "RecordDrug_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RecordDrug_seq")
    private Long RecordDrugId;
    private @NonNull String symptom;
    private LocalDate date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Drugdata", nullable = true)
    private Drugdata drugdata;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Staff", nullable = true)
    private Staff staff;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Customer", nullable = true)
    private Customer customer;

    private RecordDrugUse() {
    }

    public RecordDrugUse(String symptom, Drugdata drugdata, Staff staff, Customer customer) {

        this.symptom = symptom;
        this.drugdata = drugdata;
        this.staff = staff;
        this.customer = customer;
        this.date = LocalDate.now();
    }

}