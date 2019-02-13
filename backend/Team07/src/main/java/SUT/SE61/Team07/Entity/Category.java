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
public class Category {

    @Id
    @SequenceGenerator(name = "category_seq", sequenceName = "category_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    private Long categoryId;
    
    @NotNull(message = "not categoryname to null")
    @Pattern(regexp = "[A-Za-z]{5,25}")
    @Size(min = 5, max = 25)
    @Column(unique = true)
    private  String categoryname;

    public Category() {

    }

    public Category(String categoryname) {
        this.categoryname = categoryname;

    }

}