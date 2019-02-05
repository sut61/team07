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

public class TestNotification{

    @Autowired
    private NotificationRepository notificationrepository;
   
    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;
	
	@Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
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

     // ทดสอบ  ความยาวของ Notification name  มากกว่า 10
     /*@Test
     public void testLengthNotEquals10(){
         Notification no = new  Notification();
         no.setNotificationName("O1234567891");
         no.setDate(new Date());
          try {
             entityManager.persist(no);
             entityManager.flush();
 
             fail("Should not pass to this line");
         } catch(javax.validation.ConstraintViolationException e) {
             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
             assertEquals(violations.isEmpty(), false);
             assertEquals(violations.size(),2);
         }
     }

     // ทดสอบ  ความยาวของ Notification name   ไม่ถึง 8
    @Test
    public void testLengthMinimum8(){
        Notification no = new  Notification();
        no.setNotificationName("O123456");
        no.setDate(new Date());
         try {
            entityManager.persist(no);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(),2);
        }
    }

    // ทดสอบ pattern ไม่ตรง
   @Test
	public void testTestPackageIdDonthaveTH() {
        Notification no = new  Notification();
        no.setNotificationName("123456789");
        no.setDate(new Date());
        try {
            entityManager.persist(no);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 2);
        }
    }
 */
    


}