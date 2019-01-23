package SUT.SE61.Team07.Entity;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Data
@Table(name = "Drugdata")

public class Drugdata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long DrugdataId;
    private @NonNull String brand;
    private @NonNull String detail; //สรรพคุณ

    @ManyToOne()
    @JoinColumn(name = "staffId")
    private Staff staff;

    @ManyToOne()
    @JoinColumn(name = "categoryId")
    private Category category;

    @ManyToOne()
    @JoinColumn(name = "medicine_id")
    private Medicine medicine;

    
    @ManyToOne()
    @JoinColumn(name = "drugId")
    private Drug drug;
    
    public Drugdata (String brand,String detail,Drug drug,Staff staff,Category category, Medicine medicine) {
        this.brand = brand;
        this.detail = detail;
        this.drug = drug;
        this.staff = staff;
        this.category = category;
        this.medicine = medicine;
        
    }

}