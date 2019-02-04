package SUT.SE61.Team07.Entity;

import javax.persistence.Entity;

import java.util.List;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
public class Partners {
    @Id
    @SequenceGenerator(name = "partners_seq", sequenceName = "partners_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "partners_seq")
    @Column(name = "partnersId")
    private Long partnersId;
    private String name;


    public Partners() {
    }
    public Partners(String name) {
        this.name = name;
    }
}