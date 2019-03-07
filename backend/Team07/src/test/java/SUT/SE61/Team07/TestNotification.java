package SUT.SE61.Team07;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.Time;
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

public class TestNotification {

    @Autowired
    private NotificationRepository notificationrepository;
    @Autowired
    private CustomerRepository customerrepository;
    @Autowired
    private DrugRepository drugrepository;

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

    // ทดสอบ save Notification ปกติ
    @Test
    public void testInsertNotificationDataSuccess() {

        Customer C = this.customerrepository.findByCustomerId(1L);
        Drug D = this.drugrepository.findByDrugId(1L);
        TimeEat T = this.timeEatrepository.findByTimeEatId(1L);

        Notification no = new Notification();
        no.setNotificationName("16 กุมภาพันธ์ 2562");
        no.setCustomer(C);
        no.setDrug(D);
        no.setTimeEat(T);
        no.setDate(new Date());

        try {
            entityManager.persist(no);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("================ from testTestInsertNotificationDataSuccess =================");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);

        }
    }

    // ทดสอบ save Notification ห้ามเป็น null

    @Test
    public void testNotificationdataNotNull() {

        Customer C = this.customerrepository.findByCustomerId(1L);
        Drug D = this.drugrepository.findByDrugId(1L);
        TimeEat T = this.timeEatrepository.findByTimeEatId(1L);

        Notification no = new Notification();

        no.setNotificationName(null);
        no.setCustomer(C);
        no.setDrug(D);
        no.setTimeEat(T);
        no.setDate(new Date());

        try {
            entityManager.persist(no);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testTestNotificationdataNotNull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
        }
    }

    // test pattern ไม่ตรง
    @Test
    public void testNotificationNamepattern() {
        Customer C = this.customerrepository.findByCustomerId(1L);
        Drug D = this.drugrepository.findByDrugId(1L);
        TimeEat T = this.timeEatrepository.findByTimeEatId(1L);

        Notification no = new Notification();

        no.setNotificationName("16 january 1996");
        no.setCustomer(C);
        no.setDrug(D);
        no.setTimeEat(T);
        no.setDate(new Date());

        try {
            entityManager.persist(no);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testNotificationNamepattern =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
        }
    }

    // ทดสอบ ความยาวของ Notification เกิน 20
    @Test
    public void testMaxNotificationsize20() {
        Customer C = this.customerrepository.findByCustomerId(1L);
        Drug D = this.drugrepository.findByDrugId(1L);
        TimeEat T = this.timeEatrepository.findByTimeEatId(1L);

        Notification no = new Notification();

        no.setNotificationName("1666666666 กุมภาพันธ์ 2562222222222");

        no.setCustomer(C);
        no.setDrug(D);
        no.setTimeEat(T);
        no.setDate(new Date());

        try {
            entityManager.persist(no);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testMaxNotificationsize20   =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }

    // ทดสอบ ความยาวของ Notification ไม่ถึง 10
    @Test
    public void testMinNotificationsize10() {
        Customer C = this.customerrepository.findByCustomerId(1L);
        Drug D = this.drugrepository.findByDrugId(1L);
        TimeEat T = this.timeEatrepository.findByTimeEatId(1L);
        Notification no = new Notification();
        no.setNotificationName("กุมภา");
        no.setCustomer(C);
        no.setDrug(D);
        no.setTimeEat(T);
        no.setDate(new Date());

        try {
            entityManager.persist(no);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testMinNotificationsize10  =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }

  

}