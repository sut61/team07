package SUT.SE61.Team07.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

@Entity
@Data
public class Gender {
    @Id
    @SequenceGenerator(name = "gender_seq", sequenceName = "gender_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gender_seq")

    private Long genderId;
    
    @NotNull(message = "not Sex to null")
    @Size(min = 3, max =6)
    private String sex;

    public Gender() {
    }
    public Gender(String sex) {
        this.sex = sex;
    }
}