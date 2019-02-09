// package SUT.SE61.Team07;

// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.test.context.junit4.SpringRunner;
// import static org.junit.Assert.assertEquals;
// import static org.junit.Assert.fail;

// import java.util.Collections;
// import java.util.OptionalInt;
// import java.util.Set;
// import java.util.Date;
// import javax.validation.ConstraintViolation;
// import javax.validation.Validation;
// import javax.validation.Validator;
// import javax.validation.ValidatorFactory;

// import org.junit.Before;
// import org.junit.Test;

// import SUT.SE61.Team07.Entity.*;
// import SUT.SE61.Team07.Repository.*;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
// import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

// @RunWith(SpringRunner.class)
// @DataJpaTest

// public class TestShowHrs{

//     @Autowired
//     private ShowHrsRepository showHrsrepository;

//     @Autowired
//     private StaffRepository staffrepository;

//     @Autowired
//     private TestEntityManager entityManager;

//     private Validator validator;

//     @Before
//     public void setup() {
//         ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//         validator = factory.getValidator();
//     }



//     // ทดสอบ save data ShowHrs ปกติ
//     @Test
//     public void testTestInsertShowHrsDataSuccess() {
//         ShowHrs ss = new ShowHrs();
//         ss.setDate(new Date());
//         // ss.setDate(new Date());

//         try {
//             entityManager.persist(ss);
//             entityManager.flush();
//         } catch (javax.validation.ConstraintViolationException e) {
//             fail("Should not pass to this line");
//         }
//     }

//     // ทดสอบห้าม ShowHrs เป็น not null
//     @Test
//     public void testTestShowHrsNotNull() {
//         ShowHrs ss = new ShowHrs();
//         ss.setDate(null);
//         try {
//             entityManager.persist(ss);
//             entityManager.flush();
//             fail("Should not pass to this line");
//         } catch (javax.validation.ConstraintViolationException e) {
//             Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
//             assertEquals(violations.isEmpty(), false);
//             assertEquals(violations.size(), 1);
//         }
//     }
// //    // ทดสอบ  ความยาวของ Orders name  ไม่ถึง 8
// //
// //    @Test
// //    public void testLengthMinimum8(){
// //        Staff st = new Staff();
// //        st.setName("O123456");
// //        //ss.setAmount("20");
// //        try {
// //            entityManager.persist(ss);
// //            entityManager.flush();
// //
// //            fail("Should not pass to this line");
// //        } catch(javax.validation.ConstraintViolationException e) {
// //            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
// //            assertEquals(violations.isEmpty(), false);
// //            assertEquals(violations.size(),2);
// //        }
// //    }
// //
// //    // ทดสอบ  ความยาวของ Orders name  มากกว่า 10
// //    @Test
// //    public void testLengthNotEquals10(){
// //        Staff ss = new Staff();
// //        st.setName("O1234567891");
// //        //os.setAmount("20");
// //        try {
// //            entityManager.persist(os);
// //            entityManager.flush();
// //
// //            fail("Should not pass to this line");
// //        } catch(javax.validation.ConstraintViolationException e) {
// //            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
// //            assertEquals(violations.isEmpty(), false);
// //            assertEquals(violations.size(),2);
// //        }
// //    }
// }