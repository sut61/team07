package SUT.SE61.Team07;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
public class TestStaff {

    @Autowired
    private StaffRepository staffrepository;
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

    @Test
    public void testStaffSaveDataSuccess() {
        Staff staff = new Staff();
        staff.setStaffName("Johnex");
        staff.setStaffUser("ex1234");
        staff.setStaffPass("johnexa2");
        staff.setStaffPhone("0852097966");
        staff.setOnline("true");

        try {
            entityManager.persist(staff);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println("================ from testStaffSaveDataSuccess =================");
            System.out.println(e.getMessage());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            // fail("Should not pass to this line");
        }
    }

    @Test
    public void NotNullTest() {
   
        Staff staff = new Staff();
      System.out.println(
          "============================================================ from NotNullTest =============================================================");
  
   
      assertNotNull("Verify that thing is NOT null", staff);
   
    }

    // ทดสอบห้าม testStaffSaveNamenull เป็น not null
    @Test
    public void testStaffSaveNamenull() {
        Staff staff = new Staff();
        staff.setStaffName(null);
        staff.setStaffUser("ex1234");
        staff.setStaffPass("johnexa2");
        staff.setStaffPhone("0852097966");
        staff.setOnline("true");
        try {
            entityManager.persist(staff);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testStaffSaveNamenull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบห้าม testStaffSaveStaffUsernull เป็น not null
    @Test
    public void testStaffSaveStaffUsernull() {
        Staff staff = new Staff();
        staff.setStaffName("Johnex");
        staff.setStaffUser(null);
        staff.setStaffPass("johnexa2");
        staff.setStaffPhone("0852097966");
        staff.setOnline("true");
        try {
            entityManager.persist(staff);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testStaffSaveStaffUsernull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบห้าม testStaffSaveStaffPassnull เป็น not null
    @Test
    public void testStaffSaveStaffPassnull() {
        Staff staff = new Staff();
        staff.setStaffName("Johnex");
        staff.setStaffUser("userss");
        staff.setStaffPass(null);
        staff.setStaffPhone("0852097966");
        staff.setOnline("true");
        try {
            entityManager.persist(staff);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testStaffSaveStaffPassnull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบห้าม testStaffSavePhonenull เป็น not null
    @Test
    public void testStaffSavePhonenull() {
        Staff staff = new Staff();
        staff.setStaffName("Johnex");
        staff.setStaffUser("userss");
        staff.setStaffPass("Passswf");
        staff.setStaffPhone(null);
        staff.setOnline("true");
        try {
            entityManager.persist(staff);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testStaffSavePhonenull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

     // ทดสอบห้าม testStaffOnlineNull เป็น not null
     @Test
     public void testStaffOnlineNull() {
         Staff staff = new Staff();
         staff.setStaffName("Johnex");
         staff.setStaffUser("userss");
         staff.setStaffPass("Passswf");
         staff.setStaffPhone("0852097966");
         staff.setOnline(null);
         try {
             entityManager.persist(staff);
             entityManager.flush();
             fail("Should not pass to this line");
         } catch (javax.validation.ConstraintViolationException e) {
             System.out.println();
             System.out.println();
             System.out.println();
             System.out.println(
                     "============================================================ from testStaffOnlineNull =============================================================");
             System.out.println(e);
             System.out.println();
             System.out.println();
             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
             assertEquals(violations.isEmpty(), false);
             assertEquals(violations.size(), 1);
         }
     }

    // ทดสอบ testStaffnametolost สั้น
    @Test
    public void testStaffnametolost() {
        Staff staff = new Staff();
        staff.setStaffName("jo");
        staff.setStaffUser("userss");
        staff.setStaffPass("Passswf");
        staff.setStaffPhone("0852097966");
        staff.setOnline("true");

        try {
            entityManager.persist(staff);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testStaffnametolost =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบ testStaffUsertolost สั้น
    @Test
    public void testStaffUsertolost() {
        Staff staff = new Staff();
        staff.setStaffName("johnex");
        staff.setStaffUser("us");
        staff.setStaffPass("Passswf");
        staff.setStaffPhone("0852097966");
        staff.setOnline("true");
        try {
            entityManager.persist(staff);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testStaffUsertolost =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบ testStaffPasstolost สั้น
    @Test
    public void testStaffPasstolost() {
        Staff staff = new Staff();
        staff.setStaffName("johnex");
        staff.setStaffUser("usssss");
        staff.setStaffPass("jo");
        staff.setStaffPhone("0852097966");
        staff.setOnline("true");

        try {
            entityManager.persist(staff);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testStaffPasstolost =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบ testStaffPhonetolost สั้น
    @Test
    public void testStaffPhonetolost() {
        Staff staff = new Staff();
        staff.setStaffName("johnex");
        staff.setStaffUser("usssss");
        staff.setStaffPass("jgggso");
        staff.setStaffPhone("0852097");
        staff.setOnline("true");

        try {
            entityManager.persist(staff);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testStaffPhonetolost =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบห้าม testStaffnametomost ยาวเกิน
    @Test
    public void testStaffnametomost() {
        Staff staff = new Staff();
        staff.setStaffName("johnexdddddddddddddddddddddddddddddddasssssssssssssssssssssssssssss");
        staff.setStaffUser("usssss");
        staff.setStaffPass("jgggso");
        staff.setStaffPhone("0852097966");
        staff.setOnline("true");

        try {
            entityManager.persist(staff);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testStaffnametomost =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบห้าม testStaffuser ยาวเกิน
    @Test
    public void testStaffuser() {
        Staff staff = new Staff();
        staff.setStaffName("johnexd");
        staff.setStaffUser("usssssfdssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
        staff.setStaffPass("jgggso");
        staff.setStaffPhone("0852097966");
        staff.setOnline("true");

        try {
            entityManager.persist(staff);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testStaffuser =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบห้าม testStaffPasstomost ยาวเกิน
    @Test
    public void testStaffPasstomost() {
        Staff staff = new Staff();
        staff.setStaffName("johnexd");
        staff.setStaffUser("safsaa");
        staff.setStaffPass("safsdafgdslgijrtlgtkfdsdsadkdokgdfjgkfljdngkfjndgndfjkgnjjk");
        staff.setStaffPhone("0852097966");
        staff.setOnline("true");

        try {
            entityManager.persist(staff);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testStaffPasstomost =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบห้าม teststaffPhonetomost ยาวเกิน
    @Test
    public void teststaffPhonetomost() {
        Staff staff = new Staff();
        staff.setStaffName("johnexd");
        staff.setStaffUser("safsaa");
        staff.setStaffPass("johnexxl");
        staff.setStaffPhone("0852097900066");
        staff.setOnline("true");

        try {
            entityManager.persist(staff);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from teststaffPhonetomost =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบ teststaffpatternname ไม่ใช่ตัว อักษร
    @Test
    public void teststaffpatternname() {
        Staff staff = new Staff();
        staff.setStaffName("12345");
        staff.setStaffUser("safsaa");
        staff.setStaffPass("johnexxl");
        staff.setStaffPhone("0852097966");
        staff.setOnline("true");
        try {
            entityManager.persist(staff);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from teststaffpatternname =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


      // ทดสอบ teststaffpatternUser 
      @Test
      public void teststaffpatternUser() {
          Staff staff = new Staff();
          staff.setStaffName("sdasx");
          staff.setStaffUser("safsaa.+");
          staff.setStaffPass("johnexxl");
          staff.setStaffPhone("0852097966");
          staff.setOnline("true");
          try {
              entityManager.persist(staff);
              entityManager.flush();
  
              fail("Should not pass to this line");
          } catch (javax.validation.ConstraintViolationException e) {
              System.out.println();
              System.out.println();
              System.out.println();
              System.out.println(
                      "============================================================ from teststaffpatternUser =============================================================");
              System.out.println(e);
              System.out.println();
              System.out.println();
              Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
              assertEquals(violations.isEmpty(), false);
              assertEquals(violations.size(), 1);
          }
      }


      // ทดสอบ teststaffpatternPass 
      @Test
      public void teststaffpatternPass() {
          Staff staff = new Staff();
          staff.setStaffName("sdasx");
          staff.setStaffUser("safsaac");
          staff.setStaffPass("johnexxl*+.");
          staff.setStaffPhone("0852097966");
          staff.setOnline("true");
          try {
              entityManager.persist(staff);
              entityManager.flush();
  
              fail("Should not pass to this line");
          } catch (javax.validation.ConstraintViolationException e) {
              System.out.println();
              System.out.println();
              System.out.println();
              System.out.println(
                      "============================================================ from teststaffpatternPass =============================================================");
              System.out.println(e);
              System.out.println();
              System.out.println();
              Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
              assertEquals(violations.isEmpty(), false);
              assertEquals(violations.size(), 1);
          }
      }


         // ทดสอบ teststaffpatternPhone 
         @Test
         public void teststaffpatternPhone() {
             Staff staff = new Staff();
             staff.setStaffName("sdasx");
             staff.setStaffUser("safsaac");
             staff.setStaffPass("johnexxl");
             staff.setStaffPhone("A091232125");
             staff.setOnline("true");
             try {
                 entityManager.persist(staff);
                 entityManager.flush();
     
                 fail("Should not pass to this line");
             } catch (javax.validation.ConstraintViolationException e) {
                 System.out.println();
                 System.out.println();
                 System.out.println();
                 System.out.println(
                         "============================================================ from teststaffpatternPhone =============================================================");
                 System.out.println(e);
                 System.out.println();
                 System.out.println();
                 Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
                 assertEquals(violations.isEmpty(), false);
                 assertEquals(violations.size(), 1);
             }
         }


    @Test
    public void testsetStaffnameUnique() {
        Staff staff = new Staff();
        staff.setStaffName("Johnex");
        staff.setStaffUser("ex12314");
        staff.setStaffPass("johnexa2");
        staff.setStaffPhone("0852097965");
        staff.setOnline("true");

        this.staffrepository.save(staff);

        Staff staff2 = new Staff();
        staff2.setStaffName("Johnex");
        staff2.setStaffUser("ex1234");
        staff2.setStaffPass("johnexa2");
        staff2.setStaffPhone("0852097966");
        staff2.setOnline("true");

        try {
            // this.prescriptionrepository.save(mag2);
            entityManager.persist(staff2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (PersistenceException ex) {
            System.out.println();
            System.out.println();
            System.out.println(
                    "=================================================testsetStaffnameUnique========================================================");
            System.out.println(ex);
            System.out.println(
                    "=========================================================================================================");
            System.out.println();
            System.out.println();

        }
    }


    @Test
    public void testsetStaffUserUnique() {
        Staff staff = new Staff();
        staff.setStaffName("Johnex");
        staff.setStaffUser("ex1234");
        staff.setStaffPass("johnexa2");
        staff.setStaffPhone("0852097965");
        staff.setOnline("true");

        this.staffrepository.save(staff);

        Staff staff2 = new Staff();
        staff2.setStaffName("Johnexx");
        staff2.setStaffUser("ex1234");
        staff2.setStaffPass("johnexa2");
        staff2.setStaffPhone("0852097966");
        staff2.setOnline("true");

        try {
            // this.prescriptionrepository.save(mag2);
            entityManager.persist(staff2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (PersistenceException ex) {
            System.out.println();
            System.out.println();
            System.out.println(
                    "=================================================testsetStaffUserUnique========================================================");
            System.out.println(ex);
            System.out.println(
                    "=========================================================================================================");
            System.out.println();
            System.out.println();

        }
    }


    
    @Test
    public void testsetStaffPhoneUnique() {
        Staff staff = new Staff();
        staff.setStaffName("Johnex");
        staff.setStaffUser("ex1234");
        staff.setStaffPass("johnexa2");
        staff.setStaffPhone("0852097965");
        staff.setOnline("true");

        this.staffrepository.save(staff);

        Staff staff2 = new Staff();
        staff2.setStaffName("Johnexx");
        staff2.setStaffUser("ex12234");
        staff2.setStaffPass("johnexa2");
        staff2.setStaffPhone("0852097965");
        staff2.setOnline("true");


        try {
            // this.prescriptionrepository.save(mag2);
            entityManager.persist(staff2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (PersistenceException ex) {
            System.out.println();
            System.out.println();
            System.out.println(
                    "=================================================testsetStaffPhoneUnique========================================================");
            System.out.println(ex);
            System.out.println(
                    "=========================================================================================================");
            System.out.println();
            System.out.println();

        }
    }


}