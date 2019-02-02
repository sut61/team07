package SUT.SE61.Team07.Entity;

import lombok.*;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.validation.constraints.*;

@Entity
@Data
public class Prescription {

    @Id
    @SequenceGenerator(name = "prescription_seq", sequenceName = "prescription_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prescription_seq")
    @NotNull private  Long PrescriptionId;

    @NotNull(message="Package Id must not be null to be valid")
    //@Pattern(regexp = "\\w{0,3}\\d{8,13}TH")
    //@Size(min = 10, max = 20)
    private  String preId;

    @NotNull 
    private  Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drugId")
    private Drug drug;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staffId")
    private Staff staff;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    private Category category;

    public Prescription() {
    }

    public Prescription(String preId, Category category, Drug drug, Staff staff) {

        this.preId = preId;
        this.category = category;
        this.drug = drug;
        this.staff = staff;
        this.date = new Date();
    }

}