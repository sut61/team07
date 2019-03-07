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
public class TestTimeEat{
    @Autowired
    private TimeEatRepository timeEatrepository;
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


// ทดสอบ save TimeEat ปกติ
@Test
public void testTestInsertTimeEatDataSuccess() {
    TimeEat ti = new TimeEat();
  ti.setTimeEatName("ทานตอนเช้า");


  try {
      entityManager.persist(ti);
      entityManager.flush();
  } catch (javax.validation.ConstraintViolationException e) {
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("================ from testTestInsertTimeEatDataSuccess =================");
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

 // ทดสอบ  TimeEatName ห้ามเป็น null

 @Test
 public void testTimeEatNameNull() {
    TimeEat ti = new TimeEat();
   ti.setTimeEatName(null);

   try {
       entityManager.persist(ti);
       entityManager.flush();
   } catch (javax.validation.ConstraintViolationException e) {
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println("================ from testTimeEatNameNulll ===================");
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

  // ทดสอบ ความยาวของ MinTimeEatName  ไม่เกิน 5
  @Test
  public void testMinTimeEatNamesize5() {
    TimeEat ti = new TimeEat();
    ti.setTimeEatName("เช้า");

   try {
       entityManager.persist(ti);
       entityManager.flush();
    fail("Should not pass to this line");
   } catch (javax.validation.ConstraintViolationException e) {
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println("================================================== from testMinTimeEatNamesize5   =============================================================");
       System.out.println(e);
       System.out.println();
       System.out.println();
       Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
       assertEquals(violations.isEmpty(), false);
       assertEquals(violations.size(), 1);
   }

  }
 // ทดสอบ ความยาวของ MaxTimeEatName  เกิน 20
 @Test
 public void testMaxTimeEatNamesize20() {
    TimeEat ti = new TimeEat();
   ti.setTimeEatName("ตอนเช้าาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาาา");
   
   try {
       entityManager.persist(ti);
       entityManager.flush();
       fail("Should not pass to this line");
   } catch (javax.validation.ConstraintViolationException e) {
       System.out.println();
       System.out.println();
       System.out.println();
       System.out.println("========================================== from testMaxTimeEatNamesize20   =============================================================");
       System.out.println(e);
       System.out.println();
       System.out.println();
       Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
       assertEquals(violations.isEmpty(), false);
       assertEquals(violations.size(), 1);
   }
 }

}