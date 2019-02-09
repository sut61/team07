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

public class Notification {
    @Id
    @SequenceGenerator(name = "notification_seq", sequenceName = "notification_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_seq")

    @NotNull(message = "data notificationId must not be null to be valid")
    private Long notificationId;

    @NotNull(message = "notificationName not null")
    @Size(min = 10, max = 20)
    @Pattern(regexp = "[0-9]{1,2}\\s(กุมภาพันธ์|มกราคม|มีนาคม|เมษายน|พฤษภาคม|มิถุนายน|กรกฎาคม|สิงหาคม|กันยายน|ตุลาคม|พฤษจิกายน|ธันวาคม)\\s[0-9]{2,4}")
    private String notificationName;

    @NotNull
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drugId")
    private Drug drug;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "timeEatId")
    private TimeEat timeEat;

    public Notification() {

    }

    public Notification(String notificationName, Customer customer, Drug drug, TimeEat timeEat) {

        this.notificationName = notificationName;
        this.customer = customer;
        this.drug = drug;
        this.timeEat = timeEat;
        this.date = new Date();
    }

}