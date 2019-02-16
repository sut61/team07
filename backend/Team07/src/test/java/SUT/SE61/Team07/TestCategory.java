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
public class TestCategory {

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

    @Test
    public void TestCatagorySaveDataSuccess() {
        Category  category  = new Category();
        category.setCategoryname("herbalremedies");

        try {
            entityManager.persist(category);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println("================ from TestCatagorySaveDataSuccess =================");
            System.out.println(e.getMessage());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            // fail("Should not pass to this line");
        }
    }

    @Test
    public void NotNullTest() {
   
        Category  category  = new Category();
      System.out.println(
          "============================================================ from NotNullTest =============================================================");
  
   
      assertNotNull("Verify that thing is NOT null", category);
   
    }


      // ทดสอบห้าม testCategorynotnull เป็น not null
      @Test
      public void testCategorynotnull() {
        Category  category  = new Category();
        category.setCategoryname(null);
          try {
              entityManager.persist(category);
              entityManager.flush();
              fail("Should not pass to this line");
          } catch (javax.validation.ConstraintViolationException e) {
              System.out.println();
              System.out.println();
              System.out.println();
              System.out.println(
                      "============================================================ from testCategorynotnull =============================================================");
              System.out.println(e);
              System.out.println();
              System.out.println();
              Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
              assertEquals(violations.isEmpty(), false);
              assertEquals(violations.size(), 1);
          }
      }


      // ทดสอบห้าม testCategorytolost 
      @Test
      public void testCategorytolost() {
        Category  category  = new Category();
        category.setCategoryname("abc");
          try {
              entityManager.persist(category);
              entityManager.flush();
              fail("Should not pass to this line");
          } catch (javax.validation.ConstraintViolationException e) {
              System.out.println();
              System.out.println();
              System.out.println();
              System.out.println(
                      "============================================================ from testCategorytolost =============================================================");
              System.out.println(e);
              System.out.println();
              System.out.println();
              Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
              assertEquals(violations.isEmpty(), false);
              assertEquals(violations.size(), 2);
          }


      }

        // ทดสอบ TestCategorysetPatternCategoryname ไม่ใช่ตัว อักษร
    @Test
    public void TestCategorysetPatternCategoryname() {
        Category  category  = new Category();
        category.setCategoryname("Abc123");
        try {
            entityManager.persist(category);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from TestCategorysetPatternCategoryname =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testsetCategoryUnique() {
        Category  category  = new Category();
        category.setCategoryname("herbalremedies");


        this.categoryrepository.save(category);

        Category  category2  = new Category();
        category2.setCategoryname("herbalremedies");

        try {
            // this.prescriptionrepository.save(mag2);
            entityManager.persist(category2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (PersistenceException ex) {
            System.out.println();
            System.out.println();
            System.out.println(
                    "=================================================testsetCategoryUnique========================================================");
            System.out.println(ex);
            System.out.println(
                    "=========================================================================================================");
            System.out.println();
            System.out.println();

        }
    }



}