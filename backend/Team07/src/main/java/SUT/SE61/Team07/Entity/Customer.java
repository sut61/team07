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
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.validation.constraints.*;

@Entity
@Data

public class Customer {

    @Id
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
  
    @NotNull private Long customerId;

    @NotNull(message="not customerName  to null")
    @Pattern(regexp = "([A-Za-z]{2,10}$)") //มีอย่างน้อยสองตัวมากสุดสิบตัวใส่ได้แต่ภาษาอังกฤษ
    private  String customerName;

    @NotNull(message="not customerAllergic  to null")
    private  String customerAllergic;

    @NotNull(message="not customerAddress  to null")
    @Size(min =3 ,max = 40)
    @Column(unique = true)
    private  String customerAddress;

    @NotNull(message="not customerPhonenumber to null")
    @Pattern(regexp = "([0-9]{2,10}$)")
    @Column(unique = true)
    private String customerPhonenumber;
    
    

    @NotNull(message="not initial to null")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "InitialId")
    private Initial initial;
    
    @NotNull(message="not gender to null")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genderId")
    private Gender gender;
    
    @NotNull(message="not bloodType to null")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bloodTypeId")
    private BloodType bloodType;

    public Customer() {
    }
  
    public Customer(Initial initial, String customerName, Gender gender, BloodType bloodType,String customerAllergic, String customerAddress,
            String customerPhonenumber) {

        this.initial = initial;
        this.customerName = customerName;
        this.gender = gender;
        this.bloodType = bloodType;
        this.customerAllergic =customerAllergic;
        this.customerAddress = customerAddress;
        this.customerPhonenumber = customerPhonenumber;
        

    }

}