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
    private InvoiceRepository invoicerepository;
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
            assertEquals(violations.size(), 4);

            // fail("Should not pass to this line");
        }
    }


    @Test
    public void testInvoiceNotNullCurrentTel() {

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
                    "============================================================ from testInvoiceNotNullCurrentTel =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }
    @Test
    public void testInvoiceNotNullAmount() {

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
        In.setAmount(null);
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
                    "============================================================ from testInvoiceNotNullAmount =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }
    @Test
    public void testInvoiceNotNullNetAmount() {

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
        In.setNetamount(null);
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
                    "============================================================ from testInvoiceNotNullNetAmount =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }
    @Test
    public void testInvoiceNotNullDate() {

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
        In.setNetamount(2000);
        In.setDate(null);

        try {
            entityManager.persist(In);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testInvoiceNotNullDate =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }
    @Test
    public void testInvoiceNotNullDrug() {

        Invoice In = new Invoice();
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        Customer C = this.customerrepository.findByCustomerId(1L);
        Address A = this.addressrepository.findByAddressId(1L);
        In.setStaff(S);
        In.setCustomer(C);
        In.setAddress(A);
        In.setCurrentTel("0802457192");
        In.setDrug(null);
        In.setAmount(20);
        In.setNetamount(2000);
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
                    "============================================================ from testInvoiceNotNullDrug =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
        }
    }
    @Test
    public void testInvoiceNotNullStaff() {

        Invoice In = new Invoice();
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        Customer C = this.customerrepository.findByCustomerId(1L);
        Address A = this.addressrepository.findByAddressId(1L);
        In.setStaff(null);
        In.setCustomer(C);
        In.setAddress(A);
        In.setCurrentTel("0802457192");
        In.setDrug(D);
        In.setAmount(20);
        In.setNetamount(2000);
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
                    "============================================================ from testInvoiceNotNullStaff =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
        }
    }
    @Test
    public void testInvoiceNotNullCustomer() {

        Invoice In = new Invoice();
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        Customer C = this.customerrepository.findByCustomerId(1L);
        Address A = this.addressrepository.findByAddressId(1L);
        In.setStaff(S);
        In.setCustomer(null);
        In.setAddress(A);
        In.setCurrentTel("0802457192");
        In.setDrug(D);
        In.setAmount(20);
        In.setNetamount(2000);
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
                    "============================================================ from testInvoiceNotNullCustomer =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
        }
    }
    @Test
    public void testInvoiceNotNullAddress() {

        Invoice In = new Invoice();
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        Customer C = this.customerrepository.findByCustomerId(1L);
        Address A = this.addressrepository.findByAddressId(1L);
        In.setStaff(S);
        In.setCustomer(C);
        In.setAddress(null);
        In.setCurrentTel("0802457192");
        In.setDrug(D);
        In.setAmount(20);
        In.setNetamount(2000);
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
                    "============================================================ from testInvoiceNotNullAddress =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
        }
    }
    @Test
    public void testInvoiceMinAmount1() {

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
        In.setAmount(0);
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
                    "============================================================ from testInvoiceMinAmount1 =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }
    @Test
    public void testInvoiceMaxAmount1000() {

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
        In.setAmount(1001);
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
                    "============================================================ from testInvoiceMaxAmount1000 =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }
    @Test
    public void testInvoiceMinNetAmount1() {

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
        In.setAmount(0);
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
                    "============================================================ from testInvoiceMinNetAmount1 =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }
    @Test
    public void testInvoiceMaxNetAmount100000() {

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
        In.setNetamount(100001);
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
                    "============================================================ from testInvoiceMaxNetAmount100000 =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }
// test pattern ไม่ตรง
    @Test
    public void testInvoicePatternCurrentTel() {
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
                    "============================================================ from testInvoicePatternCurrentTel =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }


    // ทดสอบ ความยาวของ Invoice เกิน 10
    @Test
    public void testInvoicesCurrentTelMaxsize10() {
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
                    "============================================================ from testInvoicesCurrentTelMaxsize10   =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 6);
        }
    }


    // ทดสอบ ความยาวของ Invoice ไม่ถึง 1
    @Test
    public void testInvoiceCurrentTelMinsize10() {
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
                    "============================================================ from testInvoiceCurrentTelMinsize10  =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 6);
        }
    }



}