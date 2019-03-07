package SUT.SE61.Team07.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.*;

@Entity
@Data
public class Medicine {
    @Id
    @SequenceGenerator(name = "medicine_seq", sequenceName = "medicine_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicine_seq")
    private Long medicineId;

    @NotNull(message = "Medicine not null")
    @Size(min = 7,max = 100)
    private String name;

    public Medicine() {
    }
    
    public Medicine(String name) {
        this.name = name;
    }
}