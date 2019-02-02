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

public class Customer {

    @Id
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
  
    @NotNull private Long customerId;

    @NotNull(message="customerName must not be null to be valid")
   // @Pattern(regexp = "\\w{0,3}\\d{8,13}")
    //@Size(min = 10, max = 20)
    private  String customerName;

    private @NonNull String customerPhonenumber;
    private @NonNull String customerAddress;
    private @NonNull String customerUserID;
    private @NonNull String customerPassword;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "InitialId")
    private Initial initial;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genderId")
    private Gender gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "bloodTypeId")
    private BloodType bloodType;

    public Customer() {
    }
  
    public Customer(Initial initial, String customerName, Gender gender, BloodType bloodType, String customerAddress,
            String customerPhonenumber, String customerUserID, String customerPassword) {

        this.initial = initial;
        this.customerName = customerName;
        this.gender = gender;
        this.bloodType = bloodType;
        this.customerAddress = customerAddress;
        this.customerPhonenumber = customerPhonenumber;
        this.customerUserID = customerUserID;
        this.customerPassword = customerPassword;

    }

}