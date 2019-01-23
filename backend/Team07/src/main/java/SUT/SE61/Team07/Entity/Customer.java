package SUT.SE61.Team07.Entity;

import javax.persistence.*;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@Table(name = "Customer")

public class Customer {

    @Id
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    private Long customerId;
    private String customerName;
    private String customerPhonenumber;
    private String customerAddress;
    private String customerUserID;
    private String customerPassword;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genderId")
    private Gender gender;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "initialId")
    private Initial initial;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BloodTypeId")
    private BloodType bloodType;


    private Customer(){}
    public Customer(String customerName, String customerPhonenumber, String customerAddress,String customerUserID, String customerPassword
                    ,Gender gender,Initial initial, BloodType bloodType){
        this.customerName = customerName;
        this.customerPhonenumber = customerPhonenumber;
        this.customerAddress = customerAddress;
        this.customerUserID =customerUserID;
        this.customerPassword = customerPassword;
        this.gender = gender;
        this.initial =  initial;
        this.bloodType = bloodType;

    }
           
    

   

}