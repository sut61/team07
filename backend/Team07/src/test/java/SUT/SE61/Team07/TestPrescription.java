package SUT.SE61.Team07;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;
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
public class TestPrescription {
    @Autowired
    private PrescriptionRepository prescriptionrepository;
    @Autowired
    private DrugRepository drugrepository;
    @Autowired
    private StaffRepository staffrepository;
    @Autowired
    private CategoryRepository categoryrepository;

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

    // ทดสอบ save data Prescription ปกติ
    @Test
    public void testTestInsertPrescriptionDataSuccess() {
        Prescription mag = new Prescription();
        Drug D = this.drugrepository.findByDrugId(1L);
        Category C = this.categoryrepository.findByCategoryId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        mag.setNamepre("P0000000");
        mag.setAmountout(10);
        mag.setDrug(D);
        mag.setCategory(C);
        mag.setStaff(S);
        mag.setDate(new Date());
        try {
            entityManager.persist(mag);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println("================ from testSuccess =================");
            System.out.println(e.getMessage());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

        }
    }


    @Test
  public void NotNullTest() {
 
    Prescription mag = new Prescription();
    System.out.println(
        "============================================================ from NotNullTest =============================================================");

 
    assertNotNull("Verify that thing is NOT null", mag);
 
  }

    // ทดสอบห้าม setNamepre เป็น not null
    @Test
    public void testsetNamepreNull() {
        Prescription mag = new Prescription();
        Drug D = this.drugrepository.findByDrugId(1L);
        Category C = this.categoryrepository.findByCategoryId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        mag.setNamepre(null);
        mag.setAmountout(10);
        mag.setDrug(D);
        mag.setCategory(C);
        mag.setStaff(S);
        mag.setDate(new Date());
        try {
            entityManager.persist(mag);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testsetNamepreNull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testsetAmountNull() {
        Prescription mag = new Prescription();
        Drug D = this.drugrepository.findByDrugId(1L);
        Category C = this.categoryrepository.findByCategoryId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        mag.setNamepre("P0000000");
        mag.setAmountout(0);
        mag.setDrug(D);
        mag.setCategory(C);
        mag.setStaff(S);
        mag.setDate(new Date());
        try {
            entityManager.persist(mag);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testsetAmountNull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบห้ามเป็น not null
    @Test
    public void testNamedateNull() {
        Prescription mag = new Prescription();
        Drug D = this.drugrepository.findByDrugId(1L);
        Category C = this.categoryrepository.findByCategoryId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        mag.setNamepre("P0000000");
        mag.setAmountout(10);
        mag.setDrug(D);
        mag.setCategory(C);
        mag.setStaff(S);
        mag.setDate(null);
        try {
            entityManager.persist(mag);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testNamedateNull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบ first Prescription name ไม่ใช่ตัว P
    @Test
    public void testPatternNamePrescription() {
        Prescription mag = new Prescription();
        Drug D = this.drugrepository.findByDrugId(1L);
        Category C = this.categoryrepository.findByCategoryId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        mag.setNamepre("A0000000");
        mag.setAmountout(10);
        mag.setDrug(D);
        mag.setCategory(C);
        mag.setStaff(S);
        mag.setDate(new Date());
        try {
            entityManager.persist(mag);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testPatternNamePrescription =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

  

    // ทดสอบ ความยาวของ Prescription ไม่ถึง 8
    @Test
    public void testMinPrescriptionsize8() {
        Prescription mag = new Prescription();
        Drug D = this.drugrepository.findByDrugId(1L);
        Category C = this.categoryrepository.findByCategoryId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        mag.setNamepre("P12345");
        mag.setAmountout(10);
        mag.setDrug(D);
        mag.setCategory(C);
        mag.setStaff(S);
        mag.setDate(new Date());
        try {
            entityManager.persist(mag);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testMinPrescriptionsize8  =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบ  AmountOut ไม่ถึง 1
    @Test
    public void testMinAmountOut1() {
        Prescription mag = new Prescription();
        Drug D = this.drugrepository.findByDrugId(1L);
        Category C = this.categoryrepository.findByCategoryId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        mag.setNamepre("P0000000");
        mag.setAmountout(0);
        mag.setDrug(D);
        mag.setCategory(C);
        mag.setStaff(S);
        mag.setDate(new Date());
        try {
            entityManager.persist(mag);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testMinAmountOut1  =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบ ความยาวของ AmountOut เกิน 10000000
    @Test
    public void testMaxAmountOut8() {
        Prescription mag = new Prescription();
        Drug D = this.drugrepository.findByDrugId(1L);
        Category C = this.categoryrepository.findByCategoryId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        mag.setNamepre("P0000000");
        mag.setAmountout(100000000);
        mag.setDrug(D);
        mag.setCategory(C);
        mag.setStaff(S);
        mag.setDate(new Date());
        try {
            entityManager.persist(mag);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testMaxAmountOut8  =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบ ความยาวของ testMaxPrescriptionsize13 name มากกว่า 13
    @Test
    public void testMaxPrescriptionsize13() {
        Prescription mag = new Prescription();
        Drug D = this.drugrepository.findByDrugId(1L);
        Category C = this.categoryrepository.findByCategoryId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        mag.setNamepre("P1234567890123412345678901234");
        mag.setAmountout(10);
        mag.setDrug(D);
        mag.setCategory(C);
        mag.setStaff(S);
        mag.setDate(new Date());
        try {
            entityManager.persist(mag);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testMaxPrescriptionsize13   =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    public void testPrescriptionUnique() {
        Prescription mag = new Prescription();
        Drug D = this.drugrepository.findByDrugId(1L);
        Category C = this.categoryrepository.findByCategoryId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        mag.setNamepre("P0000001");
        mag.setAmountout(10);
        mag.setDrug(D);
        mag.setCategory(C);
        mag.setStaff(S);
        mag.setDate(new Date());
        this.prescriptionrepository.save(mag);

        Prescription mag2 = new Prescription();
        mag2.setNamepre("P0000001");
        mag2.setAmountout(10);
        mag2.setDrug(D);
        mag2.setCategory(C);
        mag2.setStaff(S);
        mag2.setDate(new Date());

        try {
            // this.prescriptionrepository.save(mag2);
            entityManager.persist(mag2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (PersistenceException ex) {
            System.out.println();
            System.out.println();
            System.out.println("=================================================testPrescriptionUnique========================================================");
            System.out.println(ex);
            System.out.println("=========================================================================================================");
            System.out.println();
            System.out.println();

        }
    }

}
