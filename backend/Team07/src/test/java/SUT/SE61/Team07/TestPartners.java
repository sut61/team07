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

public class TestPartners {
    @Autowired
    private PartnersRepository partnersrepository;
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
    public void testPartnersNormalSuccess() {
        Partners partners = new Partners();
        partners.setName("AgodaraRx.co.ltd");

        try {
            entityManager.persist(partners);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            System.out.println(
                    "================================================ from testPartnersNormalSuccess =================================================");
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
   
        Partners partners = new Partners();
      System.out.println(
          "============================================================ from NotNullTest =============================================================");
  
   
      assertNotNull("Verify that thing is NOT null", partners);
   
    }

    @Test
    public void testPartnersnamenull() {
        Partners partners = new Partners();
        partners.setName(null);

        try {
            entityManager.persist(partners);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            System.out.println(
                    "================================================ from testPartnersNormalSuccess =================================================");
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

    

    // pattern ของ name
    @Test
    public void testPartnersnamenumber() {
        Partners partners = new Partners();
        partners.setName("123456");

        try {
            entityManager.persist(partners);
            entityManager.flush();
            fail("Should not pass to this line");

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();

            System.out.println(
                    "================================================ from testPartnersnamenumber =================================================");
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
    public void testPartnersnametolost() {
        Partners partners = new Partners();
        partners.setName("Ago");

        try {
            entityManager.persist(partners);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ fromtestPartnersnametolost =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    public void testPartnersnametoMost() {
        Partners partners = new Partners();
        partners.setName(
                "Agofffffffffffffffffffffffffffffffffffffffffffffffffffffffffddddddddddddddddddddddddddddddddddddddddddddddddddddd");

        try {
            entityManager.persist(partners);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ testPartnersnametoMost =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    @Test
    public void testPartnersUnique() {
        Partners partners = new Partners();
        partners.setName("AgodaraRx.co.ltd");
        this.partnersrepository.save(partners);

        Partners partners2 = new Partners();
        partners2.setName("AgodaraRx.co.ltd");

        try {
            // this.prescriptionrepository.save(mag2);
            entityManager.persist(partners2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (PersistenceException ex) {
            System.out.println();
            System.out.println();
            System.out.println(
                    "=================================================testPartnersUnique========================================================");
            System.out.println(ex);
            System.out.println(
                    "=========================================================================================================");
            System.out.println();
            System.out.println();

        }
    }

}
