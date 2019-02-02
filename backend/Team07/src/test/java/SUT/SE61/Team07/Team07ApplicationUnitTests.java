package SUT.SE61.Team07;
//////////////////// System import ///////////

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


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


//////////////////// System import ///////////

 //////////////////////////////// all import //////////////////////////////
import SUT.SE61.Team07.Repository.*;
import SUT.SE61.Team07.Entity.*;
 //////////////////////////////// all import //////////////////////////////

@RunWith(SpringRunner.class)
@DataJpaTest
public class Team07ApplicationUnitTests {
	
	@Autowired
    private PrescriptionRepository prescriptionrepository;
    @Autowired
    private DrugdataRepository drugdatarepository;
    @Autowired
    private  RecordDrugUseRepository recordDrugUserepository;
    @Autowired
    private  CustomerRepository customerrepository;
    @Autowired
    private  ShowHrsRepository showHrsrepository;
    



	@Autowired
	private TestEntityManager entityManager;
	
	private Validator validator;

	@Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
	}
	
	 //ทดสอบ save data  Prescription ปกติ
	 @Test
	 public void testTestInsertPrescriptionDataSuccess() {
		 Prescription mag = new Prescription();
		 mag.setPreId("1234567890TH");
		 mag.setDate(new Date());
		 try {
			 entityManager.persist(mag);
			 entityManager.flush();
		 } catch(javax.validation.ConstraintViolationException e) {
			 fail("Should not pass to this line");
		 }
     }
     
	// ทดสอบห้าม Prescription เป็น  not null
    @Test
	public void testTestPrescriptionNotNull() {
        Prescription mag = new Prescription();
        mag.setPreId(null);
        mag.setDate(new Date());
        try {
            entityManager.persist(mag);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

     //ทดสอบ save data  Drugdata ปกติ
     public void testTestInsertDrugDataSuccess() {
        Drugdata dd = new Drugdata();
        dd.setDetail("ABCDEFGH");
        try {
            entityManager.persist(dd);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
    }

    // ทดสอบห้าม Drugdata เป็น  not null
    @Test
	public void testTestDrugdataNotNull() {
        Drugdata dd = new Drugdata();
        dd.setDetail(null);
        
        try {
            entityManager.persist(dd);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


    
     //ทดสอบ save Customer   ปกติ
     public void testTestInsertCustomerDataSuccess() {
        Customer cc = new Customer();
        cc.setCustomerName("ABCDEFGH");
        try {
            entityManager.persist(cc);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
    }

    // ทดสอบห้าม Customer เป็น  not null
    @Test
	public void testTestCustomerdataNotNull() {
        Customer cc = new Customer();
        cc.setCustomerName(null);
        
        try {
            entityManager.persist(cc);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    
     //ทดสอบ save RecordDrugUse   ปกติ
     public void testTestInsertRecordDrugUseDataSuccess() {
        RecordDrugUse rr = new RecordDrugUse();
        rr.setSymptom("ABCDEFGH");
        rr.setDate(new Date());
        try {
            entityManager.persist(rr);
            entityManager.flush();
        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
    }

    // ทดสอบห้าม RecordDrugUse เป็น  not null
    @Test
	public void testTestRecordDrugUsedataNotNull() {
        RecordDrugUse rr = new RecordDrugUse();
        rr.setSymptom(null);
        rr.setDate(new Date());
        
        try {
            entityManager.persist(rr);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


     //ทดสอบ save data  ShowHrs ปกติ
	 @Test
	 public void testTestInsertShowHrsDataSuccess() {
        ShowHrs ss = new ShowHrs();
        ss.setDate(new Date());
         //ss.setDate(new Date());
		 
		 try {
			 entityManager.persist(ss);
			 entityManager.flush();
		 } catch(javax.validation.ConstraintViolationException e) {
			 fail("Should not pass to this line");
		 }
     }
     
	// ทดสอบห้าม ShowHrs เป็น  not null
    @Test
	public void testTestShowHrsNotNull() {
        ShowHrs ss = new ShowHrs();
           ss.setDate(null);
        try {
            entityManager.persist(ss);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }


}

