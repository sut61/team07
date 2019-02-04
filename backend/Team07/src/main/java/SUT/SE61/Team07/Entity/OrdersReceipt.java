package SUT.SE61.Team07.Entity;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Getter @Setter
public class OrdersReceipt {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Integer amount;

    @ManyToOne
    private Drug drug;
    
    @ManyToOne
    @JsonIgnore
    private Receipt receipt;


    protected OrdersReceipt(){}

}