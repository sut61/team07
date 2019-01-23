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
    private @NonNull String staffName;
    private @NonNull String staffUser;
    private @NonNull String staffPass;
    private @NonNull String staffPhone;

   private Staff(){}

   @ManyToOne(fetch = FetchType.EAGER)   //set festch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "deptId")      // join colume video_id จาก video กับ entity comment
    private Department department;

   public Staff(Department department,String staffName,String staffUser,String staffPass, String staffPhone){
      this.department = department;
    this.staffName  = staffName;
       this.staffUser = staffUser;
       this.staffPass = staffPass;
       this.staffPhone = staffPhone;


   }
}