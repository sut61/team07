package SUT.SE61.Team07.Entity;

import javax.persistence.Entity;
import java.time.LocalDate;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

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

    private Prescription() {
    }

    public Prescription(String name) {
        this.name = name;
        this.date = LocalDate.now();
    }

}