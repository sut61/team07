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
@Table(name = "Catalog")
public class Catalog {

    @Id
    @SequenceGenerator(name = "catalog_seq", sequenceName = "catalog_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalog_seq")
    @Column(name = "catalogId")
    @NotNull
    private Long catalogId;

    @NotNull(message = "not catalog to null")
    @Pattern(regexp = "[A-Za-z]{3,25}")
    @Size(min = 3, max = 25)
    @Column(unique = true)
    private String catalogname;

    @NotNull(message = "not price  to null")
    @Pattern(regexp = "[0-9]{1,8}")
    @Size(min = 1, max = 25)
    private String price;

    public Catalog() {
    }

    public Catalog(String catalogname, String price) {
        this.catalogname = catalogname;
        this.price = price;

    }

}