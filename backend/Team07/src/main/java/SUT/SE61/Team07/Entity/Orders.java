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
public class Orders {

    @Id
    @SequenceGenerator(name = "orders_seq", sequenceName = "orders_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq")
    @NotNull private Long ordersId;

    @NotNull(message = " name Orders must not be null to be valid")
    private String  name;

   
    private String qty;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partnersId")
    private Partners partners;
 
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "catalogId")
    private Catalog catalog;

    

   


    public Orders() {
    }

    public Orders(String name,String qty, Partners partners,Catalog catalog) {
        this.name = name;
        this.qty = qty;
        this.partners = partners;
        this.catalog = catalog;
        
    }

}