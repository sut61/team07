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

import javax.persistence.FetchType;
import javax.validation.constraints.*;

@Entity
@Data
public class Receipt {
    @Id
    @SequenceGenerator(name = "receipt_seq", sequenceName = "receipt_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "receipt_seq")
    @NotNull(message = "receiptId must not be null to be valid")
    private Long receiptId;
    @NotNull
    private String dates;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ordersreceiptId")
    private OrdersReceipt ordersReceipt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staffId")
    private Staff staff;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drugId")
    private Drug drug;

    public Receipt() {
    }

    public Receipt(OrdersReceipt ordersReceipt, Staff staff, Drug drug, String dates) {
        this.ordersReceipt = ordersReceipt;
        this.staff = staff;
        this.drug = drug;
        this.dates = dates;

    }

}
