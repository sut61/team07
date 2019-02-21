package SUT.SE61.Team07.Entity;

import lombok.*;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
public class Drugdata {

    @Id
    @SequenceGenerator(name = "drugdata_seq", sequenceName = "drugdata_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drugdata_seq")
    @NotNull private  Long drugdataId;

    @NotNull(message="detail  must not be null to be valid")
    @Size(min = 10, max = 35)
    private  String detail; //สรรพคุณ

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staffId")
    private Staff staff;

   
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medicineId")
    private Medicine medicine;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drugId")
    private Drug drug;
    
    public Drugdata(){}
    
    public Drugdata (String detail,Drug drug,Staff staff,Category category, Medicine medicine) {
        this.detail = detail;
        this.drug = drug;
        this.staff = staff;
        this.category = category;
        this.medicine = medicine;
        
    }

}