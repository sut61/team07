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
public class TestDrug {
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

    @Test
    public void testDrugsaveDataSuccess() {
        Drug drug = new Drug();
        drug.setName("paracetamol");
        drug.setPrice(50);
        drug.setQty(10);

        try {
            entityManager.persist(drug);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println("================ from testInvoiceSuccess =================");
            System.out.println(e.getMessage());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

          //   fail("Should not pass to this line");
        }
    }

    @Test
    public void NotNullTest() {
   
        Drug drug = new Drug();
      System.out.println(
          "============================================================ from NotNullTest =============================================================");
  
   
      assertNotNull("Verify that thing is NOT null", drug);
   
    }


    // ทดสอบห้าม testDrugnameNull เป็น not null
    @Test
    public void testDrugnameNull() {
        Drug drug = new Drug();
        drug.setName(null);
        drug.setPrice(50);
        drug.setQty(10);

        try {
            entityManager.persist(drug);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testDrugnameNull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบห้าม testDrugnameNull เป็น not null
    @Test
    public void testDrugPriceNull() {
        Drug drug = new Drug();
        drug.setName("paracetamol");
        drug.setPrice(null);
        drug.setQty(10);

        try {
            entityManager.persist(drug);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testDrugPriceNull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบห้าม testDrugPriceNull เป็น not null
    @Test
    public void testDrugQTYNull() {
        Drug drug = new Drug();
        drug.setName("paracetamol");
        drug.setPrice(50);
        drug.setQty(null);

        try {
            entityManager.persist(drug);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testDrugQTYNull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบห้าม testnameDrugtolost สั้นเกิน
    @Test
    public void testnameDrugtolost() {
        Drug drug = new Drug();
        drug.setName("A");
        drug.setPrice(50);
        drug.setQty(10);

        try {
            entityManager.persist(drug);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testnameDrugtolost =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบห้าม testnameDrugtoMost ยาวเกิน
    @Test
    public void testnameDrugtoMost() {
        Drug drug = new Drug();
        drug.setName(
                "Asdasdsadasdasdsadasdsadasdasdasdasdasdasadasdasdsdasdasdasdsdsadasdasdasdassaddsasadssdasdsasadsadsdsd");
        drug.setPrice(50);
        drug.setQty(10);

        try {
            entityManager.persist(drug);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testnameDrugtoMost =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบห้าม testDrugprice สั้นเกิน
    @Test
    public void testDrugpricetolost() {
        Drug drug = new Drug();
        drug.setName("ABCDEFG");
        drug.setPrice(0);
        drug.setQty(10);

        try {
            entityManager.persist(drug);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testDrugpricetolost =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบห้าม testDrugprice ยาวเกิน
    @Test
    public void testDrugpricetomost() {
        Drug drug = new Drug();
        drug.setName("ABCDEFG");
        drug.setPrice(100000000);
        drug.setQty(10);

        try {
            entityManager.persist(drug);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testDrugpricetomost =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบห้าม testDrugQtytomost สั้นเกิน
    @Test
    public void testDrugQtytolost() {
        Drug drug = new Drug();
        drug.setName("ABCDEFG");
        drug.setPrice(32);
        drug.setQty(0);

        try {
            entityManager.persist(drug);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testDrugQtytolost =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบห้าม testDrugQty ยาวเกิน
    @Test
    public void testDrugQtytomost() {
        Drug drug = new Drug();
        drug.setName("ABCDEFG");
        drug.setPrice(50);
        drug.setQty(1000000000);

        try {
            entityManager.persist(drug);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testDrugQtytomost =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบ testPatternNameDrug ไม่ใช่ตัว อักษร
    @Test
    public void testPatternNameDrug() {
        Drug drug = new Drug();
        drug.setName("12Abcd");
        drug.setPrice(50);
        drug.setQty(10);
        try {
            entityManager.persist(drug);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testPatternNameDrug =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }



    @Test
    public void testDrugUnique() {
        Drug drug = new Drug();
        drug.setName("paracetamol");
        drug.setPrice(50);
        drug.setQty(10);
        this.drugrepository.save(drug);

        Drug drug2 = new Drug();
        drug2.setName("paracetamol");
        drug2.setPrice(50);
        drug2.setQty(10);

        try {
            // this.prescriptionrepository.save(mag2);
            entityManager.persist(drug2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (PersistenceException ex) {
            System.out.println();
            System.out.println();
            System.out.println(
                    "=================================================testDrugUnique========================================================");
            System.out.println(ex);
            System.out.println(
                    "=========================================================================================================");
            System.out.println();
            System.out.println();

        }
    }

}