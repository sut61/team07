package SUT.SE61.Team07.Entity;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Data
@Table(name = "Initial")

public class Initial {
  @Id
  @SequenceGenerator(name = "initial_seq", sequenceName = "initial_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "initial_seq")

  private Long initialId;
  private String name;

  private Initial() {

  }

  public Initial(String name) {
    this.name = name;
  }
}
