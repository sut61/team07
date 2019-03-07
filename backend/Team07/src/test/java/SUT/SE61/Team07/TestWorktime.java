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

public class TestWorktime{

   @Autowired     
   private WorktimeRepository worktimeRepository;

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

    // ทดสอบ save data ShowHrs ปกติ
    @Test
    public void testWorktimeDataSuccess() {
        Worktime W  = new Worktime();

        W.setRangeTime("9:00-17:00");
        W.setHrsAmount(8);

        try {
            entityManager.persist(W);
            entityManager.flush();
        }  catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testWorktimeDataSuccess =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            // fail("Should not pass to this line");
        }
    }

    // ทดสอบห้าม ShowHrs เป็น not null
    @Test
    public void testRangeTimeNotNull() {
        Worktime W  = new Worktime();

        W.setRangeTime(null);
        W.setHrsAmount(8);

        try {
            entityManager.persist(W);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testRangeTimeNotNull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testHrsAmountNotNull() {
        Worktime W  = new Worktime();

        W.setRangeTime("9:00-17:00");
        W.setHrsAmount(null);

        try {
            entityManager.persist(W);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testRangeTimeNotNull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testColumnUniqueRangeTime() {
        Worktime W  = new Worktime();

        W.setRangeTime("9:00-17:00");
        W.setHrsAmount(8);

        this.worktimeRepository.save(W);

        Worktime W2  = new Worktime();

        W2.setRangeTime("9:00-17:00");
        W2.setHrsAmount(3);
        try {
            entityManager.persist(W2);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (PersistenceException ex) {
            System.out.println();
            System.out.println();
            System.out.println(
                    "=================================================form testColumnUniqueRangeTime========================================================");
            System.out.println(ex);
            System.out.println(
                    "=========================================================================================================");
            System.out.println();
            System.out.println();

        }
    }
    @Test
    public void testHrsAmountMax13() {
        Worktime W  = new Worktime();

        W.setRangeTime("9:00-22:00");
        W.setHrsAmount(14);

        try {
            entityManager.persist(W);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testHrsAmountMax13 =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testHrsAmountMin3() {
        Worktime W  = new Worktime();

        W.setRangeTime("9:00-22:00");
        W.setHrsAmount(2);

        try {
            entityManager.persist(W);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testHrsAmountMin3 =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
}