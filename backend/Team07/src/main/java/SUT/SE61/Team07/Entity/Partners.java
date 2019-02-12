package SUT.SE61.Team07.Entity;

import javax.persistence.Entity;

import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.*;

@Entity
@Data
public class Partners {
    @Id
    @SequenceGenerator(name = "partners_seq", sequenceName = "partners_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partners_seq")
    @Column(name = "partnersId")

    @NotNull
    private Long partnersId;

    @NotNull(message = "not Partnersname to null")
    @Pattern(regexp = "[\\D]{5,25}")
    @Size(min = 5, max = 25)
    @Column(unique = true)
    private String name;

    public Partners() {
    }

    public Partners(String name) {
        this.name = name;
    }
}