package SUT.SE61.Team07.Entity;

import lombok.*;
import javax.validation.constraints.NotNull;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
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
    private Integer amount;
    private Integer priceorder;

    public OrdersReceipt() {
    }

    public OrdersReceipt(Integer amount,Integer priceorder) {
        this.amount = amount;
        this.priceorder = priceorder;
    }

}