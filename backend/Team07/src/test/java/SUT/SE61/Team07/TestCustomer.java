package SUT.SE61.Team07;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.OptionalInt;
import java.util.Set;
import java.util.Date;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import SUT.SE61.Team07.Entity.*;
import SUT.SE61.Team07.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest

public class TestCustomer{
    @Autowired
    private CustomerRepository customerrepository;

    @Autowired
    private InitialRepository initialrepository;

    @Autowired
    private GenderRepository genderrepository;

    @Autowired
    private BloodTypeRepository bloodTyperepository;

    @Autowired
    private TestEntityManager entityManager;

   

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }



    @Test
   public void contextLoads() {
       System.out.println("Test Successful");
   }
   
   // ทดสอบ save Customer ปกติ
    @Test
    public void testTestInsertCustomerDataSuccess() {

       
        Initial I = this.initialrepository.findByInitialId(1L);
        Gender G = this.genderrepository.findByGenderId(1L);
        BloodType B = this.bloodTyperepository.findByBloodTypeId(1L);

        Customer cus = new Customer();
        cus.setInitial(I);
        cus.setCustomerName("Tuntika");
        cus.setGender(G); 
        cus.setBloodType(B);
        cus.setCustomerAllergic("คนไข้ปฏิเสธการแพ้ยา");
        cus.setCustomerAddress("717 หมู่5 ต.ในเมือง อ.เมือง จ.นครราชสีมา 30000");
        cus.setCustomerPhonenumber("0612345678");
        cus.setCustomerUserID("B5802838");
        cus.setCustomerPassword("123456");
        
   try {
            entityManager.persist(cus);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("================ from testTestInsertNotificationDataSuccess =================");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }
    

    // ทดสอบ save Customer ห้ามเป็น null

   @Test
   public void testTestCustomerdataNotNull() {

       Initial I = this.initialrepository.findByInitialId(1L);
       Gender G = this.genderrepository.findByGenderId(1L);
       BloodType B = this.bloodTyperepository.findByBloodTypeId(1L);
       Notification no = new Notification();

       Customer cus = new Customer();
       cus.setInitial(I);
       cus.setCustomerName(null);
       cus.setGender(G); 
       cus.setBloodType(B);
       cus.setCustomerAllergic("คนไข้ปฏิเสธการแพ้ยา");
       cus.setCustomerAddress("717 หมู่5 ต.ในเมือง อ.เมือง จ.นครราชสีมา 30000");
       cus.setCustomerPhonenumber("0612345678");
       cus.setCustomerUserID("B5802838");
       cus.setCustomerPassword("123456");
      
      
       try {
           entityManager.persist(cus);
           entityManager.flush();
           fail("Should not pass to this line");
       } catch (javax.validation.ConstraintViolationException e) {
           System.out.println();
           System.out.println();
           System.out.println();
           System.out.println(
                   "============================================================ from testTestNotificationdataNotNull =============================================================");
           System.out.println(e);
           System.out.println();
           System.out.println();
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
           assertEquals(violations.isEmpty(), false);
           assertEquals(violations.size(), 1);
       }
     }

      // ทดสอบ ความยาวของ Customer ไม่ถึง 10
 /*  @Test
   public void testMinCustomersize10() {
      
       Initial I = this.initialrepository.findByInitialId(1L);
       Gender G = this.genderrepository.findByGenderId(1L);
       BloodType B = this.bloodTyperepository.findByBloodTypeId(1L);

       Customer cus = new Customer();
       cus.setInitial(I);
       cus.setCustomerName("Tuntika");
       cus.setGender(G); 
       cus.setBloodType(B);
       cus.setCustomerAddress("717 หมู่5 ต.ในเมือง อ.เมือง จ.นครราชสีมา 30000");
       cus.setCustomerPhonenumber("0612345678");
       cus.setCustomerUserID("B5802838");
       cus.setCustomerPassword("123456");

       try {
           entityManager.persist(cus);
           entityManager.flush();
           fail("Should not pass to this line");
       } catch (javax.validation.ConstraintViolationException e) {
           System.out.println();
           System.out.println();
           System.out.println();
           System.out.println(
                   "============================================================ from testMinNotificationsize10  =============================================================");
           System.out.println(e);
           System.out.println();
           System.out.println();
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
           assertEquals(violations.isEmpty(), false);
           assertEquals(violations.size(), 2);
       }
   } */
}