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
import SUT.SE61.Team07.Repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestOrderReceipt {
    @Autowired
    OrdersReciptRepository orderreceiptrepository;
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

    // ทดสอบ Save ordersreceipt ปกติ
    @Test
    public void testOrderReceiptSuccess() {
        OrdersReceipt or = new OrdersReceipt();
        or.setAmount(2);

        try {
            entityManager.persist(or);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "================================== from testOrderReceiptSuccess =====================================================");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);

            // fail("Should not pass to this line");
        }
    }

     // ทดสอบ Save ordersreceipt Null
     @Test
     public void testOrderReceiptNull() {
         OrdersReceipt or = new OrdersReceipt();
         or.setAmount(null);
 
         try {
             entityManager.persist(or);
             entityManager.flush();
 
         } catch (javax.validation.ConstraintViolationException e) {
             System.out.println();
             System.out.println();
             System.out.println();
             System.out.println(
                     "================================== from testOrderReceiptNull =====================================================");
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
     // ทดสอบ Save ordersreceipt Null
     @Test
     public void testOrderReceiptOversize() {
         OrdersReceipt or = new OrdersReceipt();
         or.setAmount(1111111);
 
         try {
             entityManager.persist(or);
             entityManager.flush();
 
         } catch (javax.validation.ConstraintViolationException e) {
             System.out.println();
             System.out.println();
             System.out.println();
             System.out.println(
                     "================================== from testOrderReceiptOversize =====================================================");
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
}