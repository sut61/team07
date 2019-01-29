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
    @JoinColumn(name = "Category", nullable = true)
    private Category category;

    private Prescription() {
    }

    public Prescription(String name, Category category, Drug drug, Staff staff) {

        this.name = name;
        this.category = category;
        this.drug = drug;
        this.staff = staff;

        this.date = LocalDate.now();
    }

}