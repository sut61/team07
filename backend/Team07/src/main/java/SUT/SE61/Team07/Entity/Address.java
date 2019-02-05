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
    private @NonNull String houseno;
    private @NonNull String villageno;
    private @NonNull String subdistrict;
    private @NonNull String district;
    private @NonNull String province;
    private @NonNull String postcode;

    public Address() {
    }

    public Address(String houseno,String villageno,String subdistrict,String district,String province,String postcode) {
        this.houseno = houseno;
        this.villageno = villageno;
        this.subdistrict = subdistrict;
        this.district = district;
        this.province = province;
        this.postcode = postcode;


    }
   
}

