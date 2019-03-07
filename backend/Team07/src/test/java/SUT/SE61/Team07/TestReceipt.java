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

import SUT.SE61.Team07.Repository.RecordDrugUseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TestReceipt {
    @Autowired
    private ReceiptRepository receiptrepository;
    @Autowired
    private OrdersReciptRepository ordersreciptRepository;
    @Autowired
    private StaffRepository staffrepository;
    @Autowired
    private DrugRepository drugrepository;

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

    // ทดสอบ Save Data Receipt ปกติ
    @Test
    public void testReceiptSuccess() {
        Receipt re = new Receipt();
        OrdersReceipt O  = this.ordersreciptRepository.findByordersreceiptId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        Drug D = this.drugrepository.findByDrugId(1L);
        re.setOrdersReceipt(O);
        re.setStaff(S);
        re.setDrug(D);
        re.setNoBill("M1234567");
        re.setDates("12 กุมพาพันธ์ 62");

        try {
            entityManager.persist(re);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "================================== from testReceiptSuccess =====================================================");
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

      // ทดสอบห้าม Receipt เป็น not null
      @Test
      public void testNameReceiptNull() {
        Receipt re = new Receipt();
        OrdersReceipt O  = this.ordersreciptRepository.findByordersreceiptId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        Drug D = this.drugrepository.findByDrugId(1L);
        re.setOrdersReceipt(O);
        re.setStaff(S);
        re.setDrug(D);
        re.setNoBill(null);
        re.setDates("12 กุมพาพันธ์ 62");
  
          try {
              entityManager.persist(re);
              entityManager.flush();
              fail("Should not pass to this line");
          } catch (javax.validation.ConstraintViolationException e) {
              System.out.println();
              System.out.println();
              System.out.println();
              System.out.println(
                      "============================================================ from testNameReceiptNull =============================================================");
              System.out.println(e);
              System.out.println();
              System.out.println();
              Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
              assertEquals(violations.isEmpty(), false);
              assertEquals(violations.size(), 5);
          }
      }


      // ทดสอบ first Receipt name ไม่ใช่ตัว M
    @Test
    public void testPatternNameReceipt() {
        Receipt re = new Receipt();
        OrdersReceipt O  = this.ordersreciptRepository.findByordersreceiptId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        Drug D = this.drugrepository.findByDrugId(1L);
        re.setOrdersReceipt(O);
        re.setStaff(S);
        re.setDrug(D);
        re.setNoBill("N1234567");
        re.setDates("12 กุมพาพันธ์ 62");
        try {
            entityManager.persist(re);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testPatternNameReceipt =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }


    // ทดสอบ ความยาวของ Receipt เกิน 10
    @Test
    public void testMaxReceiptsize10() {
        Receipt re = new Receipt();
        OrdersReceipt O  = this.ordersreciptRepository.findByordersreceiptId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        Drug D = this.drugrepository.findByDrugId(1L);
        re.setOrdersReceipt(O);
        re.setStaff(S);
        re.setDrug(D);
        re.setNoBill("M1234567777777567476587657657657");
        re.setDates("12 กุมพาพันธ์ 62");
        try {
            entityManager.persist(re);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testMaxReceiptsize10   =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 6);
        }
    }

    // ทดสอบ Receipt ยาวไม่ถึง 7
    @Test
    public void testReceiptMinsize7() {
        Receipt re = new Receipt();
        OrdersReceipt O  = this.ordersreciptRepository.findByordersreceiptId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        Drug D = this.drugrepository.findByDrugId(1L);
        re.setOrdersReceipt(O);
        re.setStaff(S);
        re.setDrug(D);
        re.setNoBill("M1234");
        re.setDates("12 กุมพาพันธ์ 62");
        try {
            entityManager.persist(re);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testReceiptMinsize7  =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 6);
        }
    }

}