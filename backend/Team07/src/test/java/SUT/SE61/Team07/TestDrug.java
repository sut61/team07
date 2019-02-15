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
        drug.setPrice("50");
        drug.setQty("10");

        try {
            entityManager.persist(drug);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {

            System.out.println("================ from testInvoiceSuccess =================");
            System.out.println(e.getMessage());
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);

            // fail("Should not pass to this line");
        }
    }

    // ทดสอบห้าม testDrugnameNull เป็น not null
    @Test
    public void testDrugnameNull() {
        Drug drug = new Drug();
        drug.setName(null);
        drug.setPrice("50");
        drug.setQty("10");

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
        drug.setQty("10");

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
        drug.setPrice("50");
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
        drug.setPrice("50");
        drug.setQty("10");

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
        drug.setPrice("50");
        drug.setQty("10");

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
        drug.setPrice("");
        drug.setQty("10");

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
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบห้าม testDrugprice ยาวเกิน
    @Test
    public void testDrugpricetomost() {
        Drug drug = new Drug();
        drug.setName("ABCDEFG");
        drug.setPrice("2225454242345324523452452345325432544534534534534534554345");
        drug.setQty("10");

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
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบห้าม testDrugQtytomost สั้นเกิน
    @Test
    public void testDrugQtytolost() {
        Drug drug = new Drug();
        drug.setName("ABCDEFG");
        drug.setPrice("32");
        drug.setQty("");

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
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบห้าม testDrugQty ยาวเกิน
    @Test
    public void testDrugQtytomost() {
        Drug drug = new Drug();
        drug.setName("ABCDEFG");
        drug.setPrice("123");
        drug.setQty("1000000000000000000000000000000000000000000000000000000000000000");

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
            assertEquals(violations.size(), 2);
        }
    }

    // ทดสอบ testPatternNameDrug ไม่ใช่ตัว อักษร
    @Test
    public void testPatternNameDrug() {
        Drug drug = new Drug();
        drug.setName("12Abcd");
        drug.setPrice("50");
        drug.setQty("10");
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

    // ทดสอบ testPatternPriceDrug ไม่ใช่ตัว เลข
    @Test
    public void testPatternPriceDrug() {
        Drug drug = new Drug();
        drug.setName("Abcd");
        drug.setPrice("AC50");
        drug.setQty("10");
        try {
            entityManager.persist(drug);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testPatternPriceDrug =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    // ทดสอบ testPatternQtyDrug ไม่ใช่ตัว เลข
    @Test
    public void testPatternQtyDrug() {
        Drug drug = new Drug();
        drug.setName("ABCDEF");
        drug.setPrice("50");
        drug.setQty("AC502");
        try {
            entityManager.persist(drug);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testPatternQtyDrug =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

}