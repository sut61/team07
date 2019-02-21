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

import javax.persistence.EntityManager;
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
    private PartnersRepository partnersrepository;
    @Autowired
    private CatalogRepository catalogrepository;
    @Autowired
    private DrugRepository drugrepository;
    @Autowired
    private StaffRepository staffrepository;

    

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
    public void testSuccess() {
        Orders os = new Orders();
        Partners P = this.partnersrepository.findBypartnersId(1L);
        Catalog C = this.catalogrepository.findByCatalogId(1L);
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
     
        os.setName("O1234567");
        os.setAmount(20);
        os.setPartners(P);
        os.setCatalog(C);
        os.setDrug(D);
        os.setStaff(S);

        try {
            entityManager.persist(os);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println("================ from testSuccess =================");
            System.out.println(e.getMessage());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            // fail("Should not pass to this line");
        }
    }

    @Test
    public void NotNullTest() {
   
        Orders os = new Orders();
      System.out.println(
          "============================================================ from NotNullTest =============================================================");
  
   
      assertNotNull("Verify that thing is NOT null", os);
   
    }

    // ทดสอบห้าม name Order เป็น not null
    @Test
    public void testNameOrdersNull() {
        Orders os = new Orders();
        Partners P = this.partnersrepository.findBypartnersId(1L);
        Catalog C = this.catalogrepository.findByCatalogId(1L);
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
     
        
        os.setName(null);
         os.setDrug(D);
        os.setAmount(20);
        os.setPartners(P);
        os.setCatalog(C);
        os.setDrug(D);
        os.setStaff(S);
        try {
            entityManager.persist(os);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testNameOrdersNull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบห้าม amount เป็น not null
    @Test
    public void testamountOrdersNull() {
        Orders os = new Orders();
        Partners P = this.partnersrepository.findBypartnersId(1L);
        Catalog C = this.catalogrepository.findByCatalogId(1L);
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
     
      
        os.setName("O1234567");
        os.setAmount(null);
        os.setPartners(P);
        os.setCatalog(C);
        os.setDrug(D);
        os.setStaff(S);
        try {
            entityManager.persist(os);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testamountOrdersNull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบ first Orders name ไม่ใช่ตัว O
    @Test
    public void testPatternNameOrders() {
        Orders os = new Orders();
        Partners P = this.partnersrepository.findBypartnersId(1L);
        Catalog C = this.catalogrepository.findByCatalogId(1L);
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
     
      
        os.setName("A1234567");
        os.setAmount(20);
        os.setPartners(P);
        os.setCatalog(C);
        os.setDrug(D);
        os.setStaff(S);
        try {
            entityManager.persist(os);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testPatternNameOrders =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


    // ทดสอบ ความยาวของ Orders name ไม่ถึง 8
    @Test
    public void testMinsize8() {
        Orders os = new Orders();
        Partners P = this.partnersrepository.findBypartnersId(1L);
        Catalog C = this.catalogrepository.findByCatalogId(1L);
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
     
        os.setName("O123456");
        os.setAmount(20);
        os.setPartners(P);
        os.setCatalog(C);
        os.setDrug(D);
        os.setStaff(S);
        try {
            entityManager.persist(os);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testMinsize8  =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบ  Orders amount ไม่ถึง 1
    @Test
    public void testMinamountsize1() {
        Orders os = new Orders();
        Partners P = this.partnersrepository.findBypartnersId(1L);
        Catalog C = this.catalogrepository.findByCatalogId(1L);
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
     
        
        os.setName("O1234567");
        os.setAmount(0);
        os.setPartners(P);
        os.setCatalog(C);
        os.setDrug(D);
        os.setStaff(S);
        try {
            entityManager.persist(os);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testMinamountsize1  =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบ ความยาวของ Orders name มากกว่า 10
    @Test
    public void testMaxsize10() {
        Orders os = new Orders();
        Partners P = this.partnersrepository.findBypartnersId(1L);
        Catalog C = this.catalogrepository.findByCatalogId(1L);
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
     
        os.setName("O123456789124245342352524254745340");
        os.setAmount(20);
        os.setPartners(P);
        os.setCatalog(C);
        os.setDrug(D);
        os.setStaff(S);
        try {
            entityManager.persist(os);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testMaxsize10   =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบ  Orders amount เกิน 1000000000
    @Test
    public void testMaxsizeamount13() {
        Orders os = new Orders();
        Partners P = this.partnersrepository.findBypartnersId(1L);
        Catalog C = this.catalogrepository.findByCatalogId(1L);
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
     
        os.setName("O1234567");
        os.setAmount(1000000000);
        os.setPartners(P);
        os.setCatalog(C);
        os.setDrug(D);
        os.setStaff(S);
        try {
            entityManager.persist(os);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testMaxsizeamount13   =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testOrdersUnique() {
        Orders os = new Orders();
        Partners P = this.partnersrepository.findBypartnersId(1L);
        Catalog C = this.catalogrepository.findByCatalogId(1L);
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
     
        os.setName("O1234567");
        os.setAmount(20);
        os.setPartners(P);
        os.setCatalog(C);
        os.setDrug(D);
        os.setStaff(S);
        this.ordersrepository.save(os);

        Orders os2 = new Orders();

        os2.setName("O1234567");
        os2.setAmount(20);
        os2.setPartners(P);
        os2.setCatalog(C);
        os2.setDrug(D);
        os2.setStaff(S);

        try {
            // this.prescriptionrepository.save(mag2);
            entityManager.persist(os2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (PersistenceException ex) {
            System.out.println();
            System.out.println();
            System.out.println(
                    "=================================================testPrescriptionUnique========================================================");
            System.out.println(ex);
            System.out.println(
                    "=========================================================================================================");
            System.out.println();
            System.out.println();

        }
    }

}