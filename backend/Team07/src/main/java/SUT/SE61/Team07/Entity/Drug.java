package SUT.SE61.Team07.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    @Pattern(regexp = "[0-9]{1,8}")
    @Size(min = 1, max = 25)
    private String price;

    @NotNull(message = "not qty  to null")
    @Pattern(regexp = "[0-9]{1,8}")
    @Size(min = 1, max = 25)
    private String qty;

    public Drug() {
    }

    public Drug(String name, String price, String qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;

    }

}