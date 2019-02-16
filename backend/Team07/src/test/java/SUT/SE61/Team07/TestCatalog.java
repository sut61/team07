package SUT.SE61.Team07;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Set;
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

public class TestCatalog {
    @Autowired
    private CatalogRepository catalogrepository;
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
    public void testCatalogSuccess() {
        Catalog Cat = new Catalog();
        Cat.setCatalogname("paracatamols");
        Cat.setPrice("200");

        try {
            entityManager.persist(Cat);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            System.out.println(
                    "================================================ from testCatalogSuccess =================================================");
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


    @Test
    public void NotNullTest() {
   
        Catalog Cat = new Catalog();
      System.out.println(
          "============================================================ from NotNullTest =============================================================");
  
   
      assertNotNull("Verify that thing is NOT null", Cat);
   
    }

    // ทดสอบห้าม catalogname เป็น not null
    @Test
    public void testCatalognameNull() {
        Catalog Cat = new Catalog();
        Cat.setCatalogname(null);
        Cat.setPrice("200");

        try {
            entityManager.persist(Cat);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testCatalognameNull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบห้าม price เป็น not null
    @Test
    public void testCatalogpriceNameNull() {
        Catalog Cat = new Catalog();
        Cat.setPrice(null);
        Cat.setCatalogname("para");

        try {
            entityManager.persist(Cat);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testCatalogpriceNameNull  =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบ Name ของ catalogname ไม่ใช่ตัวหนังสือ
    @Test
    public void testPatternNameCatalog() {
        Catalog Cat = new Catalog();
        Cat.setCatalogname("12345");
        Cat.setPrice("200");
        try {
            entityManager.persist(Cat);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testPatternNameCatalog =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบ Price ของ Catalog ไม่ใช่ตัวเลข
    @Test
    public void testPatternPriceCatalog() {
        Catalog Cat = new Catalog();
        Cat.setCatalogname("Parast");
        Cat.setPrice("ABC");
        try {
            entityManager.persist(Cat);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testPatternPriceCatalog =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบ ความยาว ของ Catalogname สั้น
    @Test
    public void testCatalognametolost() {
        Catalog Cat = new Catalog();
        Cat.setCatalogname("Pa");
        Cat.setPrice("200");
        try {
            entityManager.persist(Cat);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testCatalognametolost  =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบ ความยาว ของ price สั้น
    @Test
    public void testCatalogpricetolost() {
        Catalog Cat = new Catalog();
        Cat.setCatalogname("Para");
        Cat.setPrice("");
        try {
            entityManager.persist(Cat);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testCatalogpricetolost  =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบ ความยาว ของ Catalogname ยาวเกิน
    @Test
    public void testCatalognametomost() {
        Catalog Cat = new Catalog();
        Cat.setCatalogname("Pararrrrrrrrrrrrrrrrrrrrrraaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Cat.setPrice("12");
        try {
            entityManager.persist(Cat);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testCatalogpricetomost   =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
    

    // ทดสอบ ความยาว ของ testCatalogpricetomost ยาวเกิน
    @Test
    public void testCatalogpricetomost() {
        Catalog Cat = new Catalog();
        Cat.setCatalogname("paras");
        Cat.setPrice("12123424254353453453453453452343243245325");
        try {
            entityManager.persist(Cat);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testCatalogpricetomost   =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

}
