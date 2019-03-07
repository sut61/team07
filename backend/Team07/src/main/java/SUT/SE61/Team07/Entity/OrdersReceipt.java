package SUT.SE61.Team07.Entity;

import lombok.*;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;

@Entity
@Data
public class OrdersReceipt {
    @Id
    @SequenceGenerator(name = "ordersReceipt_seq", sequenceName = "ordersReceipt_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ordersReceipt_seq")

    @NotNull
    private Long ordersreceiptId;

    @NotNull(message = "not amount to null")
    @Max(100000)
    @Min(1)
    private Integer amount;
   

    public OrdersReceipt() {}

    public OrdersReceipt(Integer amount) {
        this.amount = amount;
        
    }

}