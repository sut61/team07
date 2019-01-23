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
    @JoinColumn(name = "initialId")
    private Initial initial;

    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "genderId")
    private Gender gender;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "BloodTypeId")
    private BloodType bloodType;


    private Customer(){}
    public Customer(Initial initial,String customerName, Gender gender,BloodType bloodType
                    , String customerAddress,String customerPhonenumber,String customerUserID, String customerPassword
                    ){
        
        this.initial =  initial;
        this.customerName = customerName;
        this.gender = gender;
        this.bloodType = bloodType;
        this.customerAddress = customerAddress;
        this.customerPhonenumber = customerPhonenumber;
        this.customerUserID =customerUserID;
        this.customerPassword = customerPassword;
      
        

    }
           
    

   

}