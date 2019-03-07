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
public class TestDrugdata{
    @Autowired
    private DrugdataRepository drugdatarepository;
    @Autowired
    private DrugRepository drugrepository;
    @Autowired
    private StaffRepository staffrepository;
    @Autowired 
    private MedicineRepository medicinerepository;
    @Autowired
    private CategoryRepository categoryrepository;

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

    // ทดสอบ save data Drugdata ปกติ
    @Test
    public void testInsertDrugDataSuccess() {
        Drugdata dd = new Drugdata();
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        Category C = this.categoryrepository.findByCategoryId(1L);
        Medicine M = this.medicinerepository.findBymedicineId(1L);
        dd.setDrug(D);
        dd.setStaff(S);
        dd.setCategory(C);
        dd.setMedicine(M);
        dd.setDetail("Muscle-like medicine,external drugs apply to the swelling");

        try {
            entityManager.persist(dd);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "================================== from testInsertDrugDataSuccessful =====================================================");
            System.out.println(e.getMessage());
            System.out.println();
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);

            // fail("Should not pass to this line");
        }
    }
    
    // ทดสอบห้าม Drugdata เป็น not null
    @Test
    public void testInsertDrugDataNull() {
        Drugdata dd = new Drugdata();
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        Category C = this.categoryrepository.findByCategoryId(1L);
        Medicine M = this.medicinerepository.findBymedicineId(1L);
        dd.setDrug(D);
        dd.setStaff(S);
        dd.setCategory(C);
        dd.setMedicine(M);
        dd.setDetail(null);

        try {
            entityManager.persist(dd);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testInsertDrugDataNull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }
    //ทดสอบ Drugdata ความยาวน้อยกว่า 10
    @Test
    public void testInsertDrugDatasize10() {
        Drugdata dd = new Drugdata();
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        Category C = this.categoryrepository.findByCategoryId(1L);
        Medicine M = this.medicinerepository.findBymedicineId(1L);
        dd.setDrug(D);
        dd.setStaff(S);
        dd.setCategory(C);
        dd.setMedicine(M);
        dd.setDetail("AA");

        try {
            entityManager.persist(dd);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testInsertDrugDatasize10 =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 6);
        }
    }
    //ทดสอบ Drugdata ความยาวมากกว่า 35
    @Test
    public void testInsertDrugDatasize35() {
        Drugdata dd = new Drugdata();
        Drug D = this.drugrepository.findByDrugId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        Category C = this.categoryrepository.findByCategoryId(1L);
        Medicine M = this.medicinerepository.findBymedicineId(1L);
        dd.setDrug(D);
        dd.setStaff(S);
        dd.setCategory(C);
        dd.setMedicine(M);
        dd.setDetail("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");

        try {
            entityManager.persist(dd);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testInsertDrugDatasize35 =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 6);
        }
    }
}