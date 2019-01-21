package SUT.SE61.Team07.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
@Table(name = "Type")
public class Type {

    @Id
    @SequenceGenerator(name = "type_seq", sequenceName = "type_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_seq")
    private Long typeId;
    private @NonNull String typename;

    private Type() {
    }

    public Type(String typename) {
        this.typename = typename;

    }

}