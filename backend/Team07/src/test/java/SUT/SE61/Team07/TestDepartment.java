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

public class TestDepartment{

   @Autowired     
   private DepartmentRepository departmentRepository;

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

    // ทดสอบ save data ShowHrs ปกติ
    @Test
    public void testDepartmentDataSuccess() {
        Department D  = new Department();

        D.setDeptName("Maid");

        
        try {
            entityManager.persist(D);
            entityManager.flush();
        }  catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testDepartmentDataSuccess =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            // fail("Should not pass to this line");
        }
    }

    // ทดสอบห้าม ShowHrs เป็น not null
    @Test
    public void testDeptNameNotNull() {
        Department D  = new Department();

        D.setDeptName(null);

        try {
            entityManager.persist(D);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testDepartmentNotNull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testColumnUniqueDeptName() {
        Department D  = new Department();
        D.setDeptName("Maid");

        this.departmentRepository.save(D);

        Department D2  = new Department();
        D2.setDeptName("Maid");
        try {
            entityManager.persist(D2);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (PersistenceException ex) {
            System.out.println();
            System.out.println();
            System.out.println(
                    "=================================================form testColumnUniqueDeptName========================================================");
            System.out.println(ex);
            System.out.println(
                    "=========================================================================================================");
            System.out.println();
            System.out.println();

        }
    }
}