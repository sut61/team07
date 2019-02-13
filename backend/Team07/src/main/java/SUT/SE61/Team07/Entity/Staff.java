package SUT.SE61.Team07.Entity;

import javax.persistence.Entity;
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
public class Staff {

    @Id
    @SequenceGenerator(name = "staff_seq", sequenceName = "staff_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_seq")
    @NotNull(message = "not staffId to null")
    private Long staffId;

    @NotNull(message = "not staffname to null")
    @Pattern(regexp = "[A-Za-z]{4,10}")
    @Size(min = 4, max = 25)
    @Column(unique = true)
    private String staffName;

    @NotNull(message = "not staffUser to null")
    @Pattern(regexp = "[A-Za-z0-9]{3,25}")
    @Size(min = 3, max = 25)
    @Column(unique = true)
    private String staffUser;

    @NotNull(message = "not staffPass to null")
    @Pattern(regexp = "[A-Za-z0-9]{3,25}")
    @Size(min = 3, max = 25)
    private String staffPass;

    @NotNull(message = "not staffPhone to null")
    @Pattern(regexp = "[0-9]{10}")
    @Size(min=10,max = 10)
    @Column(unique = true)
    private String staffPhone;

    public Staff() {
    }

    public Staff(String staffName, String staffUser, String staffPass, String staffPhone) {

        this.staffName = staffName;
        this.staffUser = staffUser;
        this.staffPass = staffPass;
        this.staffPhone = staffPhone;
    }
}