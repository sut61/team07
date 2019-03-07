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

public class TestShowHrs{

    @Autowired     
   private ShowHrsRepository showHrsRepository;

   @Autowired     
   private StaffRepository staffRepository;

   @Autowired     
   private DepartmentRepository departmentRepository;

   @Autowired     
   private WorktimeRepository worktimeRepository;

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
    public void testTestInsertShowHrsDataSuccess() {
        ShowHrs Sh = new ShowHrs();
        Staff S = this.staffRepository.findByStaffId(1L);
        Department D = this.departmentRepository.findBydeptId(1L);
        Worktime W = this.worktimeRepository.findBytimeId(1L);
        Sh.setStaff(S);
        Sh.setDepartment(D);
        Sh.setWorktime(W);
        Sh.setNote("take leave");
        Sh.setDate(new Date());
        try {
            entityManager.persist(Sh);
            entityManager.flush();
        }  catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testTestInsertShowHrsDataSuccess =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
            // fail("Should not pass to this line");
        }
    }

    // ทดสอบห้าม ShowHrs เป็น not null
    @Test
    public void testShowHrsDateNotNull() {
        ShowHrs Sh = new ShowHrs();
        Staff S = this.staffRepository.findByStaffId(1L);
        Department D = this.departmentRepository.findBydeptId(1L);
        Worktime W = this.worktimeRepository.findBytimeId(1L);
        Sh.setStaff(S);
        Sh.setDepartment(D);
        Sh.setWorktime(W);
        Sh.setNote("Late");
        Sh.setDate(null);
        try {
            entityManager.persist(Sh);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testTestInsertShowHrsDateNotNull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
        }
    }
    @Test
    public void testShowHrsNoteNotNull() {
        ShowHrs Sh = new ShowHrs();
        Staff S = this.staffRepository.findByStaffId(1L);
        Department D = this.departmentRepository.findBydeptId(1L);
        Worktime W = this.worktimeRepository.findBytimeId(1L);
        Sh.setStaff(S);
        Sh.setDepartment(D);
        Sh.setWorktime(W);
        Sh.setNote("");
        Sh.setDate(new Date());
        try {
            entityManager.persist(Sh);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testShowHrsNoteNotNull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }
    @Test
    public void testShowHrsNotNullWorktime() {
        ShowHrs Sh = new ShowHrs();
        Staff S = this.staffRepository.findByStaffId(1L);
        Department D = this.departmentRepository.findBydeptId(1L);
        Worktime W = this.worktimeRepository.findBytimeId(1L);
        Sh.setStaff(S);
        Sh.setDepartment(D);
        Sh.setWorktime(null);
        Sh.setNote("Late");
        Sh.setDate(new Date());
        try {
            entityManager.persist(Sh);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testShowHrsNotNullWorktime =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
        }
    }
    @Test
    public void testShowHrsNotNullDepartment() {
        ShowHrs Sh = new ShowHrs();
        Staff S = this.staffRepository.findByStaffId(1L);
        Department D = this.departmentRepository.findBydeptId(1L);
        Worktime W = this.worktimeRepository.findBytimeId(1L);
        Sh.setStaff(S);
        Sh.setDepartment(null);
        Sh.setWorktime(W);
        Sh.setNote("Late");
        Sh.setDate(new Date());
        try {
            entityManager.persist(Sh);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testShowHrsNotNullDepartment =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
        }
    }
    @Test
    public void testShowHrsNotNullStaff() {
        ShowHrs Sh = new ShowHrs();
        Staff S = this.staffRepository.findByStaffId(1L);
        Department D = this.departmentRepository.findBydeptId(1L);
        Worktime W = this.worktimeRepository.findBytimeId(1L);
        Sh.setStaff(null);
        Sh.setDepartment(D);
        Sh.setWorktime(W);
        Sh.setNote("Late");
        Sh.setDate(new Date());
        try {
            entityManager.persist(Sh);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testShowHrsNotNullStaff =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 3);
        }
    }
    @Test
    public void testShowHrsNotePatten() {
        ShowHrs Sh = new ShowHrs();
        Staff S = this.staffRepository.findByStaffId(1L);
        Department D = this.departmentRepository.findBydeptId(1L);
        Worktime W = this.worktimeRepository.findBytimeId(1L);
        Sh.setStaff(S);
        Sh.setDepartment(D);
        Sh.setWorktime(W);
        Sh.setNote("12345678pppp99");
        Sh.setDate(new Date());
        try {
            entityManager.persist(Sh);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testShowHrsNotePatten =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 4);
        }
    }
    //เช็คความยาวของข้อความ 
    @Test
    public void testMaxShowHrssize25() {
        ShowHrs Sh = new ShowHrs();
        Staff S = this.staffRepository.findByStaffId(1L);
        Department D = this.departmentRepository.findBydeptId(1L);
        Worktime W = this.worktimeRepository.findBytimeId(1L);
        Sh.setStaff(S);
        Sh.setDepartment(D);
        Sh.setWorktime(W);
        Sh.setNote("Lateeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
        Sh.setDate(new Date());
        try {
            entityManager.persist(Sh);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testMaxShowHrssize25 =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }
    @Test
    public void testMinShowHrssize3() {
        ShowHrs Sh = new ShowHrs();
        Staff S = this.staffRepository.findByStaffId(1L);
        Department D = this.departmentRepository.findBydeptId(1L);
        Worktime W = this.worktimeRepository.findBytimeId(1L);
        Sh.setStaff(S);
        Sh.setDepartment(D);
        Sh.setWorktime(W);
        Sh.setNote("ta");
        Sh.setDate(new Date());
        try {
            entityManager.persist(Sh);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(
                    "============================================================ from testMinShowHrssize3 =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 5);
        }
    }
    
}