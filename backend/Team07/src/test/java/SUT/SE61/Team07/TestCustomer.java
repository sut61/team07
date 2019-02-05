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

public class TestCustomer{
    @Autowired
    private CustomerRepository customerrepository;

    @Autowired
    private TestEntityManager entityManager;

private Validator validator;
	
	@Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


  // ทดสอบ save Customer ปกติ
  public void testTestInsertCustomerDataSuccess() {
    Customer cc = new Customer();
    cc.setCustomerName("ABCDEFGH");
    try {
        entityManager.persist(cc);
        entityManager.flush();
    } catch (javax.validation.ConstraintViolationException e) {
        fail("Should not pass to this line");
    }
}

// ทดสอบห้าม Customer เป็น not null
    @Test
    public void testTestCustomerdataNotNull() {
    Customer cc = new Customer();
    cc.setCustomerName(null);

    try {
        entityManager.persist(cc);
        entityManager.flush();
        fail("Should not pass to this line");
    } catch (javax.validation.ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 1);
    }
  }
}