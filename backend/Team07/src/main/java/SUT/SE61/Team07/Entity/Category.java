package SUT.SE61.Team07.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
@Table(name = "Category")
public class Category {

    @Id
    @SequenceGenerator(name = "category_seq", sequenceName = "category_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq")
    private Long categoryId;
    private @NonNull String categoryname;

    private Category() {
    }

    public Category(String categoryname) {
        this.categoryname = categoryname;

    }

}