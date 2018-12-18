package SUT.SE61.Team07;
import javax.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "customer")
@NoArgsConstructor
public class Customer {

    @Id
    @SequenceGenerator(name = "customer_seq", sequenceName = "customer_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_seq")
    private Long customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhone;
    private String customerEmail;
    private String customerUserID;
    private String customerPassword;
    
   

}