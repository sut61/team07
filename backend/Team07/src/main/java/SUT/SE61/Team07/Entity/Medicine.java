package SUT.SE61.Team07.Entity;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
@Table(name = "Medicine")
public class Medicine {
    @Id
    @SequenceGenerator(name = "medicine_seq", sequenceName = "medicine_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicine_seq")
    private Long medicineId;
    private String name;

    private Medicine() {
    }
    public Medicine(String name) {
        this.name = name;
    }
}