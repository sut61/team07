package SUT.SE61.Team07.Entity;

import javax.persistence.Entity;
import java.time.LocalDate;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;
import javax.persistence.ManyToOne;
import java.util.*;

@Entity
@Data
@Table(name = "Customer")

public class Customer {

    @Id
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    private Long customerId;
    private @NonNull String customerName;
    private @NonNull String customerPhonenumber;
    private @NonNull String customerAddress;
    private @NonNull String customerUserID;
    private @NonNull String customerPassword;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Initial", nullable = true)
    private Initial initial;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Gender", nullable = true)
    private Gender gender;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BloodType", nullable = true)
    private BloodType bloodType;

    private Customer() {
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