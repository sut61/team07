package SUT.SE61.Team07.Entity;

import javax.persistence.Entity;

import java.util.ArrayList;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "Medicine")
public class Medicine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long medicineId;
    private String name;



    private Medicine() {}

    public Medicine(String name) {
        this.name = name;
    }
}