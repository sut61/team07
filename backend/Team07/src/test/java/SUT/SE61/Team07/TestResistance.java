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
        res.setDate(new Date());

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

    // ทดสอบห้าม Resistance เป็น null
    @Test
    public void testNameResistanceNull() {
        Resistance res = new Resistance();
        RecordDrugUse re = this.recordDrugUserepository.findByRecordDrugUseId(1L);
        res.setRecordDrugUse(re);
        res.setResist(null);
        res.setDate(new Date());

        try {
            entityManager.persist(res);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "=============================== from testNameResistanceNull ======================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบ first char Resist ไม่ใช่ N หรือ R
    @Test
    public void testPatternNameResistance() {
        Resistance res = new Resistance();
        RecordDrugUse re = this.recordDrugUserepository.findByRecordDrugUseId(1L);
        res.setRecordDrugUse(re);
        res.setResist("Mormal");
        res.setDate(new Date());
        try {
            entityManager.persist(res);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "================================= from testPatternFirstCharResistance ===================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

      // ทดสอบ ความยาวของ Resist มากกว่า 8
    @Test
    public void testMaxResistancesize8() {
        Resistance res = new Resistance();
        RecordDrugUse re = this.recordDrugUserepository.findByRecordDrugUseId(1L);
        res.setRecordDrugUse(re);
        res.setResist("Ressssssssssssssssssssssssssssssssssssssssssit");
        res.setDate(new Date());

        try {
            entityManager.persist(res);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "=============================== from testMaxResistancesize8   =====================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบ ความยาวของ Resist น้อยกว่า 6
    @Test
    public void testResistanceMinsize6() {
        Resistance res = new Resistance();
        RecordDrugUse re = this.recordDrugUserepository.findByRecordDrugUseId(1L);
        res.setRecordDrugUse(re);
        res.setResist("Norm");
        res.setDate(new Date());
        try {
            entityManager.persist(res);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "=============================== from testResistanceMinsize6  ===================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบ DateNull
    @Test
    public void testResistanceDateNull() {
        Resistance res = new Resistance();
        RecordDrugUse re = this.recordDrugUserepository.findByRecordDrugUseId(1L);
        res.setRecordDrugUse(re);
        res.setResist("Norm");
        res.setDate(null);
        try {
            entityManager.persist(res);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "=============================== from testResistanceDatenull  ===================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
        }
    }



  

}
