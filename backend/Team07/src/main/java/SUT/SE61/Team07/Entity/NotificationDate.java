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


public class NotificationDate {
    @Id
    @SequenceGenerator(name = "notificationDate_seq", sequenceName = "notificationDate_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notificationDate_seq")
    private @NonNull Long notificationDateId;
    private @NonNull String notificationName;

    public NotificationDate() {
    }

    public NotificationDate(String notificationName) {
        this.notificationName = notificationName;

    }
   
}