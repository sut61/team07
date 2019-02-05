package SUT.SE61.Team07;
//////////////////// System import ///////////

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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

//////////////////// System import ///////////

//////////////////////////////// all import //////////////////////////////
import SUT.SE61.Team07.Repository.*;
import SUT.SE61.Team07.Entity.*;
//////////////////////////////// all import //////////////////////////////

@RunWith(SpringRunner.class)
@DataJpaTest
public class Team07ApplicationUnitTests {

    @Autowired
    private PrescriptionRepository prescriptionrepository;
    @Autowired
    private DrugdataRepository drugdatarepository;
    @Autowired
    private RecordDrugUseRepository recordDrugUserepository;
    @Autowired
    private CustomerRepository customerrepository;
    @Autowired
    private ShowHrsRepository showHrsrepository;
    @Autowired
    private OrdersRepository ordersrepository;
    @Autowired
    private InvoiceRepository invoicerepository;
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private ResistanceRepository resistancerepository;
    @Autowired
    private NotificationRepository notificationrepository;


    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    // ทดสอบ save data Prescription ปกติ
    @Test
    public void testTestInsertPrescriptionDataSuccess() {
        Prescription mag = new Prescription();
        mag.setPreId("1234567890TH");
        mag.setDate(new Date());
        try {
            entityManager.persist(mag);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
    }

    // ทดสอบห้าม Prescription เป็น not null
    @Test
    public void testTestPrescriptionNotNull() {
        Prescription mag = new Prescription();
        mag.setPreId(null);
        mag.setDate(new Date());
        try {
            entityManager.persist(mag);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบ save data Drugdata ปกติ
    public void testTestInsertDrugDataSuccess() {
        Drugdata dd = new Drugdata();
        dd.setDetail("ABCDEFGH");
        try {
            entityManager.persist(dd);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
    }

    // ทดสอบห้าม Drugdata เป็น not null
    @Test
    public void testTestDrugdataNotNull() {
        Drugdata dd = new Drugdata();
        dd.setDetail(null);

        try {
            entityManager.persist(dd);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบ save Customer ปกติ
    public void testTestInsertCustomerDataSuccess() {
        Customer cc = new Customer();
        cc.setCustomerName("ABCDEFGH");
        try {
            entityManager.persist(cc);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
    }

    // ทดสอบห้าม Customer เป็น not null
    @Test
    public void testTestCustomerdataNotNull() {
        Customer cc = new Customer();
        cc.setCustomerName(null);

        try {
            entityManager.persist(cc);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบ save RecordDrugUse ปกติ
    public void testTestInsertRecordDrugUseDataSuccess() {
        RecordDrugUse rr = new RecordDrugUse();
        rr.setSymptom("ABCDEFGH");
        rr.setDate(new Date());
        try {
            entityManager.persist(rr);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
    }

    // ทดสอบห้าม RecordDrugUse เป็น not null
    @Test
    public void testTestRecordDrugUsedataNotNull() {
        RecordDrugUse rr = new RecordDrugUse();
        rr.setSymptom(null);
        rr.setDate(new Date());

        try {
            entityManager.persist(rr);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบ save data ShowHrs ปกติ
    @Test
    public void testTestInsertShowHrsDataSuccess() {
        ShowHrs ss = new ShowHrs();
        ss.setDate(new Date());
        // ss.setDate(new Date());

        try {
            entityManager.persist(ss);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
    }

    // ทดสอบห้าม ShowHrs เป็น not null
    @Test
    public void testTestShowHrsNotNull() {
        ShowHrs ss = new ShowHrs();
        ss.setDate(null);
        try {
            entityManager.persist(ss);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบ save data Orders ปกติ
    public void testTestInsertOrdersSuccess() {
        Orders os = new Orders();
        os.setName("O1234567");
        os.setAmount("20");
        try {
            entityManager.persist(os);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
    }
    
    // ทดสอบ  first  Orders name  ไม่ใช่ตัว O
    @Test
    public void testFistAmountNotO(){
        Orders os = new Orders();
        os.setName("A1234567");
        os.setAmount("20");
         try {
            entityManager.persist(os);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(),1);
        }
    }

// ทดสอบ  ความยาวของ Orders name  ไม่ถึง 8
    @Test
    public void testLengthMinimum8(){
        Orders os = new Orders();
        os.setName("O123456");
        os.setAmount("20");
         try {
            entityManager.persist(os);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(),2);
        }
    }



    // ทดสอบ  ความยาวของ Orders name  มากกว่า 10
    @Test
    public void testLengthNotEquals10(){
        Orders os = new Orders();
        os.setName("O1234567891");
        os.setAmount("20");
         try {
            entityManager.persist(os);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(),2);
        }
    }

   


    // ทดสอบห้าม Drugdata เป็น not null
    @Test
    public void testTestOrdersNotNull() {
        Orders os = new Orders();
        os.setName(null);

        try {
            entityManager.persist(os);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบ save data Invoice ปกติ
    @Test
    public void testTestInsertInvoiceDataSuccess() {
        Invoice in = new Invoice();
        in.setAmount("21");
        in.setDate(new Date());
        try {
            entityManager.persist(in);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
    }

    // ทดสอบห้าม Invoice เป็น not null
    @Test
    public void testTestInvoiceNotNull() {
        Invoice in = new Invoice();
        in.setAmount(null);
        in.setDate(new Date());
        try {
            entityManager.persist(in);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


    
    // ทดสอบ save Resistance ปกติ
    public void testTestInsertResistanceDataSuccess() {
        Resistance re = new Resistance();
        re.setResistanceId(1L);
        try {
            entityManager.persist(re);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
    }


    // ทดสอบห้าม Resistance เป็น not null
    @Test
    public void testTestResistancedataNotNull() {
        Resistance re = new Resistance();
        re.setRecordDrugUse(null);

        try {
            entityManager.persist(re);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


    // ทดสอบ save Notification ปกติ
    public void testTestInsertNotificationDataSuccess() {
        Notification no = new Notification();
        no.setNotificationId(1L);
        try {
            entityManager.persist(no);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
    }


    // ทดสอบห้าม Notification เป็น not null
    @Test
    public void testTestNotificationdataNotNull() {
        Notification no = new  Notification();
        no.setNotificationName(null);
        no.setDate(new Date());

        try {
            entityManager.persist(no);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }



}
