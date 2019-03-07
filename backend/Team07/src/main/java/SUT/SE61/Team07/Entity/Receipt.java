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

    @NotNull(message = "noBill not null")
    @Pattern(regexp = "(^M{1}[0-9]{7,10}$)")
    @Size(min = 7,max = 10)
    private String noBill;

    @NotNull(message = "dates not null")
    @Size(min = 10, max = 20)
    @Pattern(regexp = "[0-9]{1,2}\\s(กุมภาพันธ์|มกราคม|มีนาคม|เมษายน|พฤษภาคม|มิถุนายน|กรกฎาคม|สิงหาคม|กันยายน|ตุลาคม|พฤศจิกายน|ธันวาคม)\\s[0-9]{2,4}")
    private String dates;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ordersreceiptId")
    private OrdersReceipt ordersReceipt;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staffId")
    private Staff staff;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drugId")
    private Drug drug;

    public Receipt() {
    }

    public Receipt(OrdersReceipt ordersReceipt, Staff staff, Drug drug,String dates, String noBill) {
        this.ordersReceipt = ordersReceipt;
        this.staff = staff;
        this.drug = drug;
        this.dates = dates;
        this.noBill = noBill;

    }

}
