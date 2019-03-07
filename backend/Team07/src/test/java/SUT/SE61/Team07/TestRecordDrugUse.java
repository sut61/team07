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
public class TestRecordDrugUse {
    
    @Autowired
    private CustomerRepository customerrepository;

    @Autowired
    private DrugdataRepository drugdatarepository;

    @Autowired
    private StaffRepository staffrepository;

    @Autowired
    private RecordDrugUseRepository recordDrugUserepository;
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

    // ทดสอบ Save Data RecordDrugUse ปกติ
    @Test
    public void testRecordDrugUseSuccess() {
        RecordDrugUse rec = new RecordDrugUse();

        Drugdata Dd = this.drugdatarepository.findByDrugdataId(1L);
        Staff Ss = this.staffrepository.findByStaffId(1L);
        Customer Cc = this.customerrepository.findByCustomerId(1L);

        rec.setSymptom("death");
        rec.setDrugdata(Dd);
        rec.setStaff(Ss);
        rec.setCustomer(Cc);
        rec.setDate(new Date());
  

        try {
            entityManager.persist(rec);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "================================== from testRecordDrugUseSuccess =====================================================");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            // fail("Should not pass to this line");
        }
    }

    // ทดสอบห้าม Rec-Symptom เป็น null
    @Test
    public void testSymptomRecordDrugUseNull() {
      RecordDrugUse rec = new RecordDrugUse();

      Drugdata Dd = this.drugdatarepository.findByDrugdataId(1L);
      Staff Ss = this.staffrepository.findByStaffId(1L);
      Customer Cc = this.customerrepository.findByCustomerId(1L);

      rec.setSymptom(null);
      rec.setDrugdata(Dd);
      rec.setStaff(Ss);
      rec.setCustomer(Cc);
      rec.setDate(new Date());
        try {
            entityManager.persist(rec);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "=============================== from test Rec-Symptom Null ======================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบ Rec-Symptom ไม่ใช่ตัวอักษร
    @Test
    public void testPatternSymptomRecordDrugUse() {
      RecordDrugUse rec = new RecordDrugUse();

      Drugdata Dd = this.drugdatarepository.findByDrugdataId(1L);
      Staff Ss = this.staffrepository.findByStaffId(1L);
      Customer Cc = this.customerrepository.findByCustomerId(1L);

      rec.setSymptom("12345");
      rec.setDrugdata(Dd);
      rec.setStaff(Ss);
      rec.setCustomer(Cc);
      rec.setDate(new Date()); 

        try {
            entityManager.persist(rec);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "================================= from testPatternSymptomRecordDrugUse ===================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

      // ทดสอบ ความยาวของ Symtom น้อยกว่า 3
    @Test
    public void testMinRecordDrugUseSize3() {
      RecordDrugUse rec = new RecordDrugUse();

      Drugdata Dd = this.drugdatarepository.findByDrugdataId(1L);
      Staff Ss = this.staffrepository.findByStaffId(1L);
      Customer Cc = this.customerrepository.findByCustomerId(1L);

      rec.setSymptom("de");
      rec.setDrugdata(Dd);
      rec.setStaff(Ss);
      rec.setCustomer(Cc);
      rec.setDate(new Date());

        try {
            entityManager.persist(rec);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "=============================== from testMinRecordDrugUseSize3   =====================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบ ความยาวของ Symptom มากกว่า 20
    @Test
    public void testRecordDrugUseMaxSize20() {
        RecordDrugUse rec = new RecordDrugUse();

        Drugdata Dd = this.drugdatarepository.findByDrugdataId(1L);
        Staff Ss = this.staffrepository.findByStaffId(1L);
        Customer Cc = this.customerrepository.findByCustomerId(1L);

        rec.setSymptom("deathhhhhhhhhhhhhhhhhhhhh");
        rec.setDrugdata(Dd);
        rec.setStaff(Ss);
        rec.setCustomer(Cc);
        rec.setDate(new Date());

        try {
            entityManager.persist(rec);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "=============================== from testRecordDrugUseMaxSize20  ===================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }


     // ทดสอบห้าม Rec-Date เป็น null
     @Test
     public void testDateRecordDrugUseNull() {
       RecordDrugUse rec = new RecordDrugUse();
 
       Drugdata Dd = this.drugdatarepository.findByDrugdataId(1L);
       Staff Ss = this.staffrepository.findByStaffId(1L);
       Customer Cc = this.customerrepository.findByCustomerId(1L);
 
       rec.setSymptom("death");
       rec.setDrugdata(Dd);
       rec.setStaff(Ss);
       rec.setCustomer(Cc);
       rec.setDate(null);

         try {
             entityManager.persist(rec);
             entityManager.flush();
             fail("Should not pass to this line");
         } catch (javax.validation.ConstraintViolationException e) {
             System.out.println();
             System.out.println();
             System.out.println();
             System.out.println(
                     "=============================== from testDateRecordDrugUseNull ======================================");
             System.out.println(e);
             System.out.println();
             System.out.println();
             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
             assertEquals(violations.isEmpty(), false);
             assertEquals(violations.size(),1);
         }
     }



  

}
