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

public class TestGender{
    @Autowired
    private GenderRepository genderrepository;
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

  // ทดสอบ save Gender ปกติ
  @Test
  public void testTestInsertInitialDataSuccess() {
    Gender ge = new Gender();
    ge.setSex("Female");
  

    try {
        entityManager.persist(ge);
        entityManager.flush();
    } catch (javax.validation.ConstraintViolationException e) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("================ from testTestInsertGenderDataSuccess =================");
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

  // ทดสอบ Sex ห้ามเป็น null

  @Test
  public void testSexNull() {
    Gender ge = new Gender();
    ge.setSex(null);

    try {
        entityManager.persist(ge);
        entityManager.flush();
    } catch (javax.validation.ConstraintViolationException e) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("================ from testSexnulll ===================");
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
   // ทดสอบ ความยาวของ MinSex  ไม่เกิน 3
   @Test
   public void testMinCustomerAddresssize2() {
    Gender ge = new Gender();
    ge.setSex("Fe");

    try {
        entityManager.persist(ge);
        entityManager.flush();
     fail("Should not pass to this line");
    } catch (javax.validation.ConstraintViolationException e) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(
                "====================================================== from testMinSexsize3  =============================================================");
        System.out.println(e);
        System.out.println();
        System.out.println();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 1);
    }

   }
  // ทดสอบ ความยาวของ MaxSex  เกิน 6
  @Test
  public void testMaxInitialNamesize5() {
    Gender ge = new Gender();
    ge.setSex("Femaleeeee");
    
    try {
        entityManager.persist(ge);
        entityManager.flush();
        fail("Should not pass to this line");
    } catch (javax.validation.ConstraintViolationException e) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("========================================== from testSexsize6   =============================================================");
        System.out.println(e);
        System.out.println();
        System.out.println();
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 1);
    }
  }
}
