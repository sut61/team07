package SUT.SE61.Team07.Entity;

import javax.persistence.*;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Data
public class BloodType {
  @Id
  @SequenceGenerator(name = "bloodType_seq", sequenceName = "bloodType_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bloodType_seq")

  private Long bloodTypeId;
  
  @NotNull(message = "not initialName to null")
  @Pattern(regexp = "([A-Z]{1,2})")
  private String name;

  public BloodType() {

  }

  public BloodType(String name) {
    this.name = name;
  }

}
