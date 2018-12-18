package SUT.SE61.Team07.Entity;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode

public class Pharmacist {
    @Id @GeneratedValue
    private Long ph_id;
    private String ph_name;
    private String ph_address;
    private String ph_phone;
}
