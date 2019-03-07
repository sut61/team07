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

import javax.persistence.PersistenceException;
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
        cus.setCustomerAddress("7/7 หมู่5 ต.ในเมือง อ.เมือง จ.นครราชสีมา 30000");
        cus.setCustomerPhonenumber("0612345678");
        
        
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
            System.out.println("================ from testTestInsertCustomerDataSuccess =================");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);

        }
    }
    

    // ทดสอบ  Initial ห้ามเป็น null

   @Test
   public void testInitialNull() {

       Initial I = this.initialrepository.findByInitialId(1L);
       Gender G = this.genderrepository.findByGenderId(1L);
       BloodType B = this.bloodTyperepository.findByBloodTypeId(1L);
      

       Customer cus = new Customer();
       cus.setInitial(null);
       cus.setCustomerName("Tuntika");
       cus.setGender(G); 
       cus.setBloodType(B);
       cus.setCustomerAllergic("คนไข้ปฏิเสธการแพ้ยา");
       cus.setCustomerAddress("7/7 หมู่5 ต.ในเมือง อ.เมือง จ.นครราชสีมา 30000");
       cus.setCustomerPhonenumber("0612345678");
       
      
    try {
           entityManager.persist(cus);
           entityManager.flush();
           fail("Should not pass to this line");
       } catch (javax.validation.ConstraintViolationException e) {
           System.out.println();
           System.out.println();
           System.out.println();
           System.out.println("======================================== from testInitialNulll ========================================");
           System.out.println(e);
           System.out.println();
           System.out.println();
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
           assertEquals(violations.isEmpty(), false);
           assertEquals(violations.size(), 4);
       }
     }

      // ทดสอบ  CustomerName ห้ามเป็น null

   @Test
   public void testCustomerNameNull() {

       Initial I = this.initialrepository.findByInitialId(1L);
       Gender G = this.genderrepository.findByGenderId(1L);
       BloodType B = this.bloodTyperepository.findByBloodTypeId(1L);
      

       Customer cus = new Customer();
       cus.setInitial(I);
       cus.setCustomerName(null);
       cus.setGender(G); 
       cus.setBloodType(B);
       cus.setCustomerAllergic("คนไข้ปฏิเสธการแพ้ยา");
       cus.setCustomerAddress("7/7 หมู่5 ต.ในเมือง อ.เมือง จ.นครราชสีมา 30000");
       cus.setCustomerPhonenumber("0612345678");
       
      
      
       try {
           entityManager.persist(cus);
           entityManager.flush();
           fail("Should not pass to this line");
       } catch (javax.validation.ConstraintViolationException e) {
           System.out.println();
           System.out.println();
           System.out.println();
           System.out.println("=================================== from testCustomerNameNulll =====================================");
           System.out.println(e);
           System.out.println();
           System.out.println();
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
           assertEquals(violations.isEmpty(), false);
           assertEquals(violations.size(), 5);
       }
     }
     

     // ทดสอบ  Gender ห้ามเป็น null

   @Test
   public void testGenderNull() {

       Initial I = this.initialrepository.findByInitialId(1L);
       Gender G = this.genderrepository.findByGenderId(1L);
       BloodType B = this.bloodTyperepository.findByBloodTypeId(1L);
      

       Customer cus = new Customer();
       cus.setInitial(I);
       cus.setCustomerName("Tuntika");
       cus.setGender(null); 
       cus.setBloodType(B);
       cus.setCustomerAllergic("คนไข้ปฏิเสธการแพ้ยา");
       cus.setCustomerAddress("7/7 หมู่5 ต.ในเมือง อ.เมือง จ.นครราชสีมา 30000");
       cus.setCustomerPhonenumber("0612345678");
       
      
      
       try {
           entityManager.persist(cus);
           entityManager.flush();
           fail("Should not pass to this line");
       } catch (javax.validation.ConstraintViolationException e) {
           System.out.println();
           System.out.println();
           System.out.println();
           System.out.println("================================ from testGenderNulll =============================");
           System.out.println(e);
           System.out.println();
           System.out.println();
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
           assertEquals(violations.isEmpty(), false);
           assertEquals(violations.size(), 4);
       }
     }

     
     // ทดสอบ BloodType ห้ามเป็น null

   @Test
   public void testBloodTypeNull() {

       Initial I = this.initialrepository.findByInitialId(1L);
       Gender G = this.genderrepository.findByGenderId(1L);
       BloodType B = this.bloodTyperepository.findByBloodTypeId(1L);
      

       Customer cus = new Customer();
       cus.setInitial(I);
       cus.setCustomerName("Tuntika");
       cus.setGender(G); 
       cus.setBloodType(null);
       cus.setCustomerAllergic("คนไข้ปฏิเสธการแพ้ยา");
       cus.setCustomerAddress("7/7 หมู่5 ต.ในเมือง อ.เมือง จ.นครราชสีมา 30000");
       cus.setCustomerPhonenumber("0612345678");
       
      
      
       try {
           entityManager.persist(cus);
           entityManager.flush();
           fail("Should not pass to this line");
       } catch (javax.validation.ConstraintViolationException e) {
           System.out.println();
           System.out.println();
           System.out.println();
           System.out.println("================================ from testBloodTypeNulll =============================");
           System.out.println(e);
           System.out.println();
           System.out.println();
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
           assertEquals(violations.isEmpty(), false);
           assertEquals(violations.size(), 4);
       }
     }

     // ทดสอบ  CustomerAllergicNull ห้ามเป็น null

   @Test
   public void testCustomerAllergicNull() {

       Initial I = this.initialrepository.findByInitialId(1L);
       Gender G = this.genderrepository.findByGenderId(1L);
       BloodType B = this.bloodTyperepository.findByBloodTypeId(1L);
      

       Customer cus = new Customer();
       cus.setInitial(I);
       cus.setCustomerName("Tuntika");
       cus.setGender(G); 
       cus.setBloodType(B);
       cus.setCustomerAllergic(null);
       cus.setCustomerAddress("7/7 หมู่5 ต.ในเมือง อ.เมือง จ.นครราชสีมา 30000");
       cus.setCustomerPhonenumber("0612345678");
       
      
      
       try {
           entityManager.persist(cus);
           entityManager.flush();
           fail("Should not pass to this line");
       } catch (javax.validation.ConstraintViolationException e) {
           System.out.println();
           System.out.println();
           System.out.println();
           System.out.println("=============================== from testCustomerAllergicNull ===============================");
           System.out.println(e);
           System.out.println();
           System.out.println();
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
           assertEquals(violations.isEmpty(), false);
           assertEquals(violations.size(), 5);
       }
     }

         // ทดสอบ  CustomerAddressNull ห้ามเป็น null

   @Test
   public void testCustomeAddressNull() {

       Initial I = this.initialrepository.findByInitialId(1L);
       Gender G = this.genderrepository.findByGenderId(1L);
       BloodType B = this.bloodTyperepository.findByBloodTypeId(1L);
      

       Customer cus = new Customer();
       cus.setInitial(I);
       cus.setCustomerName("Tuntika");
       cus.setGender(G); 
       cus.setBloodType(B);
       cus.setCustomerAllergic("คนไข้ปฏิเสธการแพ้ยา");
       cus.setCustomerAddress(null);
       cus.setCustomerPhonenumber("0612345678");
       
      
      
       try {
           entityManager.persist(cus);
           entityManager.flush();
           fail("Should not pass to this line");
       } catch (javax.validation.ConstraintViolationException e) {
           System.out.println();
           System.out.println();
           System.out.println();
           System.out.println( "============================ from CustomereAddressNull =======================================");
           System.out.println(e);
           System.out.println();
           System.out.println();
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
           assertEquals(violations.isEmpty(), false);
           assertEquals(violations.size(), 4);
       }
     }

     
         // ทดสอบ  CustomerPhonenumberNull ห้ามเป็น null

   @Test
   public void testCustomerPhonenumberNull() {

       Initial I = this.initialrepository.findByInitialId(1L);
       Gender G = this.genderrepository.findByGenderId(1L);
       BloodType B = this.bloodTyperepository.findByBloodTypeId(1L);
      

       Customer cus = new Customer();
       cus.setInitial(I);
       cus.setCustomerName("Tuntika");
       cus.setGender(G); 
       cus.setBloodType(B);
       cus.setCustomerAllergic("คนไข้ปฏิเสธการแพ้ยา");
       cus.setCustomerAddress("7/7 หมู่5 ต.ในเมือง อ.เมือง จ.นครราชสีมา 30000");
       cus.setCustomerPhonenumber(null);
       
      
      
       try {
           entityManager.persist(cus);
           entityManager.flush();
           fail("Should not pass to this line");
       } catch (javax.validation.ConstraintViolationException e) {
           System.out.println();
           System.out.println();
           System.out.println();
           System.out.println( "=============================== from CustomerPhonenumberNull ==================================");
           System.out.println(e);
           System.out.println();
           System.out.println();
           Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
           assertEquals(violations.isEmpty(), false);
           assertEquals(violations.size(), 5);
       }
     }
    
    

     // ทดสอบ Pattern CustomerName ห้ามมีตัวเลข
    @Test
    public void testPatternCustomerNameNotNumber() {
       Initial I = this.initialrepository.findByInitialId(1L);
       Gender G = this.genderrepository.findByGenderId(1L);
       BloodType B = this.bloodTyperepository.findByBloodTypeId(1L);

       Customer cus = new Customer();
       cus.setInitial(I);
       cus.setCustomerName("Tuntika56");
       cus.setGender(G); 
       cus.setBloodType(B);
       cus.setCustomerAllergic("คนไข้ปฏิเสธการแพ้ยา");
       cus.setCustomerAddress("7/7 หมู่5 ต.ในเมือง อ.เมือง จ.นครราชสีมา 30000");
       cus.setCustomerPhonenumber("0612345678");
       

       try {
        entityManager.persist(cus);
        entityManager.flush();
        fail("Should not pass to this line");
    } catch (javax.validation.ConstraintViolationException e) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("================================= from testPatternCustomerNameNotNumber   ===================================");
        System.out.println(e);
        System.out.println();
        System.out.println();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 5);
    }
} 


     // ทดสอบ Pattern CustomerPhonenumber ห้ามเป็นตัวหนังสือ
     @Test
     public void testPatternCustomerPhonenumberNotLetter() {
        Initial I = this.initialrepository.findByInitialId(1L);
        Gender G = this.genderrepository.findByGenderId(1L);
        BloodType B = this.bloodTyperepository.findByBloodTypeId(1L);
 
        Customer cus = new Customer();
        cus.setInitial(I);
        cus.setCustomerName("Tuntika");
        cus.setGender(G); 
        cus.setBloodType(B);
        cus.setCustomerAllergic("คนไข้ปฏิเสธการแพ้ยา");
        cus.setCustomerAddress("7/7 หมู่5 ต.ในเมือง อ.เมือง จ.นครราชสีมา 30000");
        cus.setCustomerPhonenumber("ศูนย์แปดเก้าห้าเก้าหนึ่งสองหกเจ็ดแปด");
        

        try {
         entityManager.persist(cus);
         entityManager.flush();
         fail("Should not pass to this line");
     } catch (javax.validation.ConstraintViolationException e) {
         System.out.println();
         System.out.println();
         System.out.println();
         System.out.println("========================= from testPatternCustomerPhonenumberNotLetter   ================================");
         System.out.println(e);
         System.out.println();
         System.out.println();
         Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
         assertEquals(violations.isEmpty(), false);
         assertEquals(violations.size(), 5);
     }
    } 
 
   // ทดสอบ ความยาวของ MinCustomerAddress ไม่เกิน 3
    @Test
    public void testMinCustomerAddresssize3() {
       Initial I = this.initialrepository.findByInitialId(1L);
       Gender G = this.genderrepository.findByGenderId(1L);
       BloodType B = this.bloodTyperepository.findByBloodTypeId(1L);

       Customer cus = new Customer();
       cus.setInitial(I);
       cus.setCustomerName("Tuntika");
       cus.setGender(G); 
       cus.setBloodType(B);
       cus.setCustomerAllergic("คนไข้ปฏิเสธการแพ้ยา");
       cus.setCustomerAddress("77");
       cus.setCustomerPhonenumber("0612345678");
       

       try {
        entityManager.persist(cus);
        entityManager.flush();
     fail("Should not pass to this line");
    } catch (javax.validation.ConstraintViolationException e) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("============================= from testMinCustomersize3   =================================");
        System.out.println(e);
        System.out.println();
        System.out.println();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 4);
    }
}

    // ทดสอบ ความยาวของ MaxCustomerAddress เกิน 40
    @Test
    public void testMaxCustomerAddresssize40() {
       Initial I = this.initialrepository.findByInitialId(1L);
       Gender G = this.genderrepository.findByGenderId(1L);
       BloodType B = this.bloodTyperepository.findByBloodTypeId(1L);

       Customer cus = new Customer();
       cus.setInitial(I);
       cus.setCustomerName("Tuntika");
       cus.setGender(G); 
       cus.setBloodType(B);
       cus.setCustomerAllergic("คนไข้ปฏิเสธการแพ้ยา");
       cus.setCustomerAddress("7/7 หมู่5 ต.ในเมือง อ.เมือง จ.นครราชสีมา 3000000000000000000000");
       cus.setCustomerPhonenumber("0612345678");
       

       try {
        entityManager.persist(cus);
        entityManager.flush();
        fail("Should not pass to this line");
    } catch (javax.validation.ConstraintViolationException e) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println( "================================ from testMaxCustomerize40   ======================================");
        System.out.println(e);
        System.out.println();
        System.out.println();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 4);
    }
}

 // test  column customerAddress ห้ามซ้ำ
 @Test
 public void testsetcustomerAddressUnique() {
    Initial I = this.initialrepository.findByInitialId(1L);
    Gender G = this.genderrepository.findByGenderId(1L);
    BloodType B = this.bloodTyperepository.findByBloodTypeId(1L);
    Customer cus = new Customer();
    cus.setInitial(I);
    cus.setCustomerName("Tuntika");
    cus.setGender(G); 
    cus.setBloodType(B);
    cus.setCustomerAllergic("คนไข้ปฏิเสธการแพ้ยา");
    cus.setCustomerAddress("7/7 หมู่5 ต.ในเมือง อ.เมือง จ.นครราชสีมา 30000");
    cus.setCustomerPhonenumber("0612345677");
    

     this.customerrepository.save(cus);

    Customer cus2 = new Customer();
    cus2.setInitial(I);
    cus2.setCustomerName("Tuntika");
    cus2.setGender(G); 
    cus2.setBloodType(B);
    cus2.setCustomerAllergic("คนไข้ปฏิเสธการแพ้ยา");
    cus2.setCustomerAddress("7/7 หมู่5 ต.ในเมือง อ.เมือง จ.นครราชสีมา 30000");
    cus2.setCustomerPhonenumber("0612345678");
    


    try {
        entityManager.persist(cus2);
        entityManager.flush();
        fail("Should not pass to this line");
    } catch (javax.validation.ConstraintViolationException e) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("=========================== from testsetcustomerAddressUnique   ================================");
        System.out.println(e);
        System.out.println();
        System.out.println();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 4);
   }
 }

  // test  column customerPhonenumber ห้ามซ้ำ
  @Test
  public void testsetcustomerPhonenumberUnique() {
     Initial I = this.initialrepository.findByInitialId(1L);
     Gender G = this.genderrepository.findByGenderId(1L);
     BloodType B = this.bloodTyperepository.findByBloodTypeId(1L);
     Customer cus = new Customer();
     cus.setInitial(I);
     cus.setCustomerName("Tuntika");
     cus.setGender(G); 
     cus.setBloodType(B);
     cus.setCustomerAllergic("คนไข้ปฏิเสธการแพ้ยา");
     cus.setCustomerAddress("7/7 หมู่5 ต.ในเมือง อ.เมือง จ.นครราชสีมา 30000");
     cus.setCustomerPhonenumber("0612345677");
     
 
      this.customerrepository.save(cus);
 
     Customer cus2 = new Customer();
     cus2.setInitial(I);
     cus2.setCustomerName("Tuntika");
     cus2.setGender(G); 
     cus2.setBloodType(B);
     cus2.setCustomerAllergic("คนไข้ปฏิเสธการแพ้ยา");
     cus2.setCustomerAddress("7/7 หมู่5 ต.ในเมือง อ.เมือง จ.นครราชสีมา 30");
     cus2.setCustomerPhonenumber("0612345677");
     
 
 
     try {
         entityManager.persist(cus2);
         entityManager.flush();
         fail("Should not pass to this line");
     } catch (javax.validation.ConstraintViolationException e) {
         System.out.println();
         System.out.println();
         System.out.println();
         System.out.println("============================ from testsetcustomerPhonenumberUnique   ===================================");
         System.out.println(e);
         System.out.println();
         System.out.println();
         Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
         assertEquals(violations.isEmpty(), false);
         assertEquals(violations.size(), 4);
    }
  }

}