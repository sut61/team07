package SUT.SE61.Team07.Entity;

import javax.persistence.*;
import lombok.*;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@Table(name = "BloodType")
public class BloodType {
  @Id
  @SequenceGenerator(name = "bloodType_seq", sequenceName = "bloodType_seq")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bloodType_seq")

  private Long bloodTypeId;
  private String name;

  private BloodType() {

  }

  public BloodType(String name) {
    this.name = name;
  }

}
