package SUT.SE61.Team07.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data

public class Address {
    @Id
    @SequenceGenerator(name = "address_seq", sequenceName = "address_seq_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_seq")
    private @NonNull Long addressId;
    private @NonNull String addressName;

    public Address() {
    }

    public Address(String addressName) {
        this.addressName = addressName;

    }
   
}

