package SUT.SE61.Team07.Entity;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Data
@Table(name = "Gender")

public class Gender {
    @Id
    @SequenceGenerator(name = "gender_seq", sequenceName = "gender_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gender_seq")

    private Long genderId;
    private String sex;

    private Gender() {
    }

    public Gender(String sex) {
        this.sex = sex;
    }
}