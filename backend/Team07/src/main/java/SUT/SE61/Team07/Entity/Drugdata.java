package SUT.SE61.Team07.Entity;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
@Table(name = "Drugdata")

public class Drugdata {

    @Id
    @SequenceGenerator(name = "drugdata_seq", sequenceName = "drugdata_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drugdata_seq")
    private long drugdataId;
    private @NonNull String detail; //สรรพคุณ

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staffId", nullable = true)
    private Staff staff;

   
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId", nullable = true)
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "medicine_id", nullable = true)
    private Medicine medicine;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Drug", nullable = true)
    private Drug drug;
    
    private Drugdata(){}
    
    public Drugdata (String detail,Drug drug,Staff staff,Category category, Medicine medicine) {
        this.detail = detail;
        this.drug = drug;
        this.staff = staff;
        this.category = category;
        this.medicine = medicine;
        
    }

}