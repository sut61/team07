package SUT.SE61.Team07.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Data

public class Department {
    @Id
    @SequenceGenerator(name = "dept_seq", sequenceName = "dept_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq")
   
   @NotNull
    private  Long deptId;

    
    @NotNull
    @Column(unique = true)
    private  String deptName;

    public Department() {
    }

    public Department(String deptName) {
        this.deptName = deptName;

    }
   
}

