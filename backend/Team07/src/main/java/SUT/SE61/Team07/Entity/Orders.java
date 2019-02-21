package SUT.SE61.Team07.Entity;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.Column;

@Entity
@Data
public class Orders {

    @Id
    @SequenceGenerator(name = "orders_seq", sequenceName = "orders_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orders_seq")

    @NotNull
    private Long ordersId;

    @NotNull(message = " name Orders must not be null to be valid")
    @Pattern(regexp = "(^O{1}[0-9]{7,13}$)")
    @Size(min = 8, max = 10)
    @Column(unique = true, nullable = false)
    private String name;

    @NotNull(message = " amount Orders must not be null to be valid")
    @Max(1000000)
    @Min(1)
    private Integer amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "partnersId")
    private Partners partners;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "catalogId")
    private Catalog catalog;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "drugId")
    private Drug drug;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "staffId")
    private Staff staff;

    public Orders() {
    }

    public Orders(String name, Integer amount, Partners partners, Catalog catalog,Drug drug,Staff staff) {
        this.name = name;
        this.amount = amount;
        this.partners = partners;
        this.catalog = catalog;
        this.drug = drug;
        this.staff = staff;

    }

}