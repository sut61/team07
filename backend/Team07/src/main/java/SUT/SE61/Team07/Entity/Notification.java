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

public class Notification {
    @Id
    @SequenceGenerator(name = "notification_seq", sequenceName = "notification_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_seq")

    @NotNull(message = "data Invoice must not be null to be valid")
    private Long notificationId;
    
    @NotNull
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
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "notificationDateId")
    private NotificationDate notificationDate;

    public Notification() {

    }

    public Notification(Customer customer, Drug drug, TimeEat timeEat,NotificationDate notificationDate, String  notificationName) {
        this.customer = customer;
        this.drug = drug;
        this.timeEat = timeEat;
        this.notificationDate = notificationDate;
        this.notificationName = notificationName;
        this.date = new Date();
    }

}