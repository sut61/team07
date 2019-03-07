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

public class TestInitial{
    @Autowired
    private InitialRepository initialrepository;
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

  // ทดสอบ save Initial ปกติ
  @Test
  public void testTestInsertInitialDataSuccess() {
    Initial in = new Initial();
    in.setInitialName("Miss");
  

    try {
        entityManager.persist(in);
        entityManager.flush();
    } catch (javax.validation.ConstraintViolationException e) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("================ from testTestInsertInitialDataSuccess =================");
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

  // ทดสอบ  InitialName ห้ามเป็น null

  @Test
  public void testInitialNameNull() {
    Initial in = new Initial();
    in.setInitialName(null);

    try {
        entityManager.persist(in);
        entityManager.flush();
    } catch (javax.validation.ConstraintViolationException e) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("================ from testInitialNameNulll ===================");
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
   // ทดสอบ ความยาวของ MinInitialName  ไม่เกิน 2
   @Test
   public void testMinInitialNamesize2() {
    Initial in = new Initial();
    in.setInitialName("M");

    try {
        entityManager.persist(in);
        entityManager.flush();
     fail("Should not pass to this line");
    } catch (javax.validation.ConstraintViolationException e) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(
                "====================================================== from test MinInitialNamesize2   =============================================================");
        System.out.println(e);
        System.out.println();
        System.out.println();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 1);
    }

   }
  // ทดสอบ ความยาวของ MaxInitialName  เกิน 5
  @Test
  public void testMaxInitialNamesize5() {
    Initial in = new Initial();
    in.setInitialName("Missssss");
    
    try {
        entityManager.persist(in);
        entityManager.flush();
        fail("Should not pass to this line");
    } catch (javax.validation.ConstraintViolationException e) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("========================================== from testInitialNamesize5   =============================================================");
        System.out.println(e);
        System.out.println();
        System.out.println();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 1);
    }
  }
}
