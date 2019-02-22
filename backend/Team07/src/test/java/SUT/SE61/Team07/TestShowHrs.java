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
            assertEquals(violations.size(), 1);
            // fail("Should not pass to this line");
        }
    }

    // ทดสอบห้าม ShowHrs เป็น not null
    @Test
    public void testTestInsertShowHrsDataNotNull() {
        ShowHrs Sh = new ShowHrs();
        Staff S = this.staffRepository.findByStaffId(1L);
        Department D = this.departmentRepository.findBydeptId(1L);
        Worktime W = this.worktimeRepository.findBytimeId(1L);
        Sh.setStaff(S);
        Sh.setDepartment(D);
        Sh.setWorktime(W);
        Sh.setNote("take leave");
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
                    "============================================================ from testTestInsertShowHrsDataNotNull =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }
    @Test
    public void testTestInsertShowHrsDataPatten() {
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
                    "============================================================ from testTestInsertShowHrsDataPatten =============================================================");
            System.out.println(e);
            System.out.println();
            System.out.println();
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
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
        Sh.setNote("take leaveeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee");
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
            assertEquals(violations.size(), 2);
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
            assertEquals(violations.size(), 2);
        }
    }

//    // ทดสอบ  ความยาวของ Orders name  ไม่ถึง 8
//
//    @Test
//    public void testLengthMinimum8(){
//        Staff st = new Staff();
//        st.setName("O123456");
//        //ss.setAmount("20");
//        try {
//            entityManager.persist(ss);
//            entityManager.flush();
//
//            fail("Should not pass to this line");
//        } catch(javax.validation.ConstraintViolationException e) {
//            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//            assertEquals(violations.isEmpty(), false);
//            assertEquals(violations.size(),2);
//        }
//    }
//
//    // ทดสอบ  ความยาวของ Orders name  มากกว่า 10
//    @Test
//    public void testLengthNotEquals10(){
//        Staff ss = new Staff();
//        st.setName("O1234567891");
//        //os.setAmount("20");
//        try {
//            entityManager.persist(os);
//            entityManager.flush();
//
//            fail("Should not pass to this line");
//        } catch(javax.validation.ConstraintViolationException e) {
//            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//            assertEquals(violations.isEmpty(), false);
//            assertEquals(violations.size(),2);
//        }
//    }
}