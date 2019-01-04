package SUT.SE61.Team07.Entity;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Staff {
    @Id @GeneratedValue
    private Long staffId;
    private String staffName;
    private String customerAddress;
    private String staffTel;
    private String staffUserID;
    private String staffPassword;

}