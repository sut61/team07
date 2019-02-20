package SUT.SE61.Team07.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import lombok.*;

@Entity
@Data
public class Drug {

    @Id
    @SequenceGenerator(name = "drug_seq", sequenceName = "drug_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "drug_seq")
    private Long drugId;

    @NotNull(message = "not Drugname to null")
    @Pattern(regexp = "[A-Za-z]{3,25}")
    @Size(min = 3, max = 25)
    @Column(unique = true)
    private String name;

    @NotNull(message = "not price  to null")
    @Max(100000)
    @Min(1)
    private Integer price;

    @NotNull(message = "not qty  to null")
    @Max(100000)
    @Min(1)
    private Integer qty;

    public Drug() {
    }

    public Drug(String name, Integer price, Integer qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;

    }

	

}