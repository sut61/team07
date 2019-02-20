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
public class TestInvoice {
    @Autowired
    private StaffRepository staffrepository;
    @Autowired
    private CustomerRepository customerrepository;
    @Autowired
    private AddressRepository addressrepository;
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
    public void testInvoiceSuccess() {
        Invoice In = new Invoice();
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        Customer C = this.customerrepository.findByCustomerId(1L);
        Address A = this.addressrepository.findByAddressId(1L);
        In.setStaff(S);
        In.setCustomer(C);
        In.setAddress(A);
        In.setCurrentTel("0802457192");
        In.setDrug(D);
        In.setAmount(20);
        In.setNetamount(200);
        In.setDate(new Date());

        try {
            entityManager.persist(In);
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


    @Test
    public void testTestInvoiceNotNull() {

        Invoice In = new Invoice();
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        Customer C = this.customerrepository.findByCustomerId(1L);
        Address A = this.addressrepository.findByAddressId(1L);
        In.setStaff(S);
        In.setCustomer(C);
        In.setAddress(A);
        In.setCurrentTel(null);
        In.setDrug(D);
        In.setAmount(20);
        In.setNetamount(200);
        In.setDate(new Date());

        try {
            entityManager.persist(In);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testTestInvoiceNotNull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

// test pattern ไม่ตรง
    @Test
    public void testInvoiceNameInvoice() {
        Invoice In = new Invoice();
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        Customer C = this.customerrepository.findByCustomerId(1L);
        Address A = this.addressrepository.findByAddressId(1L);
        In.setStaff(S);
        In.setCustomer(C);
        In.setAddress(A);
        In.setCurrentTel("9802457192");

        In.setDrug(D);
        In.setAmount(20);
        In.setNetamount(200);
        In.setDate(new Date());

        try {
            entityManager.persist(In);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testPatternNameInvoice =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


    // ทดสอบ ความยาวของ Invoice เกิน 10
    @Test
    public void testMaxInvoicesize8() {
        Invoice In = new Invoice();
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        Customer C = this.customerrepository.findByCustomerId(1L);
        Address A = this.addressrepository.findByAddressId(1L);
        In.setStaff(S);
        In.setCustomer(C);
        In.setAddress(A);
        In.setCurrentTel("08024571922222");

        In.setDrug(D);
        In.setAmount(20);
        In.setNetamount(200);
        In.setDate(new Date());
        
        try {
            entityManager.persist(In);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testMaxInvoicesize10   =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }


    // ทดสอบ ความยาวของ Invoice ไม่ถึง 1
    @Test
    public void testMinInvoicesize1() {
        Invoice In = new Invoice();
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        Customer C = this.customerrepository.findByCustomerId(1L);
        Address A = this.addressrepository.findByAddressId(1L);
        In.setStaff(S);
        In.setCustomer(C);
        In.setAddress(A);
        In.setCurrentTel("080245");

        In.setDrug(D);
        In.setAmount(20);
        In.setNetamount(200);
        In.setDate(new Date());
        try {
            entityManager.persist(In);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testMinInvoicesize10  =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }



}