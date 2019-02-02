package SUT.SE61.Team07.Entity;
import javax.persistence.*;
import lombok.*;

@Entity
@Data
public class Gender {
    @Id
    @SequenceGenerator(name = "gender_seq", sequenceName = "gender_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gender_seq")

    private Long genderId;
    private String sex;

    public Gender() {
    }
    public Gender(String sex) {
        this.sex = sex;
    }
}