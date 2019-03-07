package SUT.SE61.Team07.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.*;

@Entity
@Data
public class Initial {
  @Id
  @SequenceGenerator(name = "initial_seq", sequenceName = "initial_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "initial_seq")

  private Long initialId;
  
  @NotNull(message = "not initialName to null")
  @Size(min = 2, max =5)
  private String initialName;

  public Initial() {

  }

  public Initial(String initialName) {
    this.initialName = initialName;
  }
}
