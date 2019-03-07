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

public class TestBloodType{
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

  // ทดสอบ save BloodType ปกติ
  @Test
  public void testTestInsertInitialDataSuccess() {
    BloodType bl = new BloodType();
    bl.setName("AB");
  

    try {
        entityManager.persist(bl);
        entityManager.flush();
    } catch (javax.validation.ConstraintViolationException e) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("================ from testTestInsertBloodTypeDataSuccess =================");
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

  // ทดสอบ  BloodTypeName ห้ามเป็น null

  @Test
  public void testInitialNameNull() {
    BloodType bl = new BloodType();
    bl.setName(null);

    try {
        entityManager.persist(bl);
        entityManager.flush();
    } catch (javax.validation.ConstraintViolationException e) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("================ from testBloodTypeNameNulll ===================");
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
  
   // ทดสอบ Pattern  BloodTypeName ห้ามเกินสองตัวและต้องเป็นภาษาอังกฤษตัวใหญ่
   @Test
   public void testPatternBloodTypeNameLetter() {
    BloodType bl = new BloodType();
    bl.setName("ABA");

    try {
        entityManager.persist(bl);
        entityManager.flush();
    } catch (javax.validation.ConstraintViolationException e) {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("================ from testPatternBloodTypeNameLetter ===================");
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
}