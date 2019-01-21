package SUT.SE61.Team07.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
@Table(name = "Staff")
public class Staff {

    @Id
    @SequenceGenerator(name = "staff_seq", sequenceName = "staff_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_seq")
    private Long staffId;
    private @NonNull String staffname;
    private @NonNull String staffUser;
    private @NonNull String staffPass;

   private Staff(){}

   public Staff(String staffname,String staffUser,String staffPass){
       this.staffname  = staffname;
       this.staffUser = staffUser;
       this.staffPass = staffPass;


   }
}