package SUT.SE61.Team07.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
@Table(name = "Department")
public class Department {
    @Id
    @SequenceGenerator(name = "dept_seq", sequenceName = "dept_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq")
    private @NonNull Long deptId;
    private @NonNull String deptName;

    private Department() {
    }

    public Department(String deptName) {
        this.deptName = deptName;

    }
   
}

