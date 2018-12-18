package SUT.SE61.Team07;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class Drug {
    @Id @GeneratedValue
    private Long id;
    private @NonNull String name;

    
}