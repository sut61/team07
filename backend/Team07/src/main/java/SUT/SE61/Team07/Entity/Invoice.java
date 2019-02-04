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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.validation.constraints.*;

@Entity
@Data
public class Invoice {
    @Id
    @SequenceGenerator(name = "invoice_seq", sequenceName = "invoice_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_seq")

    @NotNull(message="invoice Id must not be null to be valid")
    private  Long invoiceId;

    @NotNull 
    private  Date date;

    @NotNull 
    private  String amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "addressId")
    private Address adress;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staffId")
    private Staff staff;

    // @OneToMany(mappedBy = "invoice")//เป็น bidirectional mapping ที่ map กลับไปยัง table COMMENT_FORUM ฟิลด์ COMMENT_ID 
    // private List<Drug> drug;

    public Invoice() {
    }

    public Invoice(Staff staff , Customer customer, Drug drug,String amount,Date date) {
        this.staff = staff;
        this.customer = customer;
        //this.drug = drug;
        this.amount = amount;
        this.date = new Date();
    }

}