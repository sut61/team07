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
import SUT.SE61.Team07.Repository.ResistanceRepository;

import SUT.SE61.Team07.Repository.RecordDrugUseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestResistance {

    @Autowired
    private ResistanceRepository resistanceRepository;
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

    // ทดสอบ Save Data Resistance ปกติ
    @Test
    public void testResistanceSuccess() {
        Resistance res = new Resistance();
        RecordDrugUse re = this.recordDrugUserepository.findByRecordDrugUseId(1L);
        res.setRecordDrugUse(re);
        res.setResist("Normal");

        try {
            entityManager.persist(res);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "================================== from testResistanceSuccess =====================================================");
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

    // ทดสอบห้าม Resistance เป็น not null
    @Test
    public void testNameResistanceNull() {
        Resistance res = new Resistance();
        RecordDrugUse re = this.recordDrugUserepository.findByRecordDrugUseId(1L);
        res.setRecordDrugUse(re);
        res.setResist(null);

        try {
            entityManager.persist(res);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testNameResistanceNull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบ first Resistance name ไม่ใช่ตัว N หรือ R
    @Test
    public void testPatternNameResistance() {
        Resistance res = new Resistance();
        RecordDrugUse re = this.recordDrugUserepository.findByRecordDrugUseId(1L);
        res.setRecordDrugUse(re);
        res.setResist("Mormal");
        try {
            entityManager.persist(res);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testPatternNameResistance =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

      // ทดสอบ ความยาวของ Resistance เกิน 8
    @Test
    public void testMaxResistancesize8() {
        Resistance res = new Resistance();
        RecordDrugUse re = this.recordDrugUserepository.findByRecordDrugUseId(1L);
        res.setRecordDrugUse(re);
        res.setResist("Ressssssssssssssssssssssssssssssssssssssssssit");

        try {
            entityManager.persist(res);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testMaxResistancesize8   =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบ Resistance ยาวไม่ถึง 6
    @Test
    public void testResistanceMinsize6() {
        Resistance res = new Resistance();
        RecordDrugUse re = this.recordDrugUserepository.findByRecordDrugUseId(1L);
        res.setRecordDrugUse(re);
        res.setResist("Norm");
        try {
            entityManager.persist(res);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testResistanceMinsize6  =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }



  

}
