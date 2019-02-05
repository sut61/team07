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

public class TestOrders {

    @Autowired
    private OrdersRepository ordersrepository;

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    // ทดสอบ save data Orders ปกติ
    public void testTestInsertOrdersSuccess() {
        Orders os = new Orders();
        os.setName("O1234567");
        os.setAmount("20");
        os.setPartners(null);
        os.setCatalog(null);

        try {
            entityManager.persist(os);
            entityManager.flush();
            System.out.println(
                    "------------------------------------------------------------------------------------------------------------------------------------------------Test Case 1 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");

        } catch (javax.validation.ConstraintViolationException e) {

            fail("Should not pass to this line");
        }
    }

    // ทดสอบห้ามเป็น not null 
    @Test
    public void testTestOrdersnameNotNull() {
        Orders os = new Orders();
        os.setName(null);
        os.setAmount("20");
        os.setPartners(null);
        os.setCatalog(null);
        try {
            entityManager.persist(os);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("2.1  Test testTestPackageIdNotNull >> ");
            System.out.println(e.getMessage()
                    + "------------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.1 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");

        }
    }

    // ทดสอบ first Orders name ไม่ใช่ตัว O
    @Test
    public void testFistAmountNotO() {
        Orders os = new Orders();
        os.setName("A1234567");
        os.setAmount("20");
        os.setPartners(null);
        os.setCatalog(null);
        try {
            entityManager.persist(os);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.print("2.4  Test testTestPackageIdNotNull >> ");
            System.out.println(e.getMessage()
                    + "------------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.4 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");

        }
    }

    // ทดสอบ ความยาวของ Orders name ไม่ถึง 8
    @Test
    public void testLengthMinimum8() {
        Orders os = new Orders();
        os.setName("O123456");
        os.setAmount("20");
        os.setPartners(null);
        os.setCatalog(null);
        try {
            entityManager.persist(os);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.print("2.3  Test testTestPackageIdNotNull >> ");
            System.out.println(e.getMessage()
                    + "------------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.3 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");

        }
    }

    // ทดสอบ ความยาวของ Orders name มากกว่า 10
    @Test
    public void testLengthNotEquals10() {
        Orders os = new Orders();
        os.setName("O1234567891");
        os.setAmount("20");
        os.setPartners(null);
        os.setCatalog(null);
        try {
            entityManager.persist(os);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
            System.out.print("2.2  Test testTestPackageIdNotNull >> ");
            System.out.println(e.getMessage()
                    + "------------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.2 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");

        }
    }

    public void testIdMustBeUnique() {
        Orders os = new Orders();
        os.setName("O12345678");
        os.setAmount("20");
        os.setPartners(null);
        os.setCatalog(null);
        entityManager.persist(os);
        entityManager.flush();

        Orders os2 = new Orders();
        os.setName("O12345678");
        os.setAmount("20");
        os.setPartners(null);
        os.setCatalog(null);

        try {

            entityManager.persist(os2);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (PersistenceException e) {
            

            System.out.print("2.5  Test testIdMustBeUnique >> ");
            System.out.println(e.getMessage()
                    + "------------------------------------------------------------------------------------------------------------------------------------------------Test Case 2.5 Succuess------------------------------------------------------------------------------------------------------------------------------------------------");

        }

    }

}