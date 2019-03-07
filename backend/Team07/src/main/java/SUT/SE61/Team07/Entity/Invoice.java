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
public class Invoice {
    @Id
    @SequenceGenerator(name = "invoice_seq", sequenceName = "invoice_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_seq")

    @NotNull(message = "data Invoice must not be null to be valid")
    private Long invoiceId;

    @NotNull
    private Date date;

    //@Pattern(regexp = "(^M{1}[0-9]{7,10}$)")
    //@Pattern(regexp = "(\\d{10})")
    @Pattern(regexp = "(^0{1}[0-9]{9,9}$)")
    @Size(min = 10, max = 10)
    @NotNull
    private String currentTel;

    @NotNull(message = "not  amount  to null")
    @Max(1000)
    @Min(1)
    private Integer amount;

    @NotNull(message = "not  netamount  to null")
    @Max(100000)
    @Min(1)
    private Integer netamount;

    @NotNull(message = "not  customer  to null")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @NotNull(message = "not  staff  to null")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staffId")
    private Staff staff;

    @NotNull(message = "not  drug  to null")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drugId")
    private Drug drug;

    @NotNull(message = "not  address  to null")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "addressId")
    private Address address;

    public Invoice() {

    }

    public Invoice(Staff staff, Customer customer, Address address, String currentTel, Drug drug, int amount, int netamount) {
        this.staff = staff;
        this.customer = customer;
        this.address = address;
        this.currentTel = currentTel;
        this.drug = drug;
        this.amount = amount;
        this.netamount = netamount;
        
        this.date = new Date();
    }

}