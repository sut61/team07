package SUT.SE61.Team07.Entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

@Entity
@Getter @Setter
public class Receipt {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Date date;

    @ManyToOne
    private Staff staff;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy="receipt")
    private Set<Orders> orders;

    protected Receipt(){}

}
