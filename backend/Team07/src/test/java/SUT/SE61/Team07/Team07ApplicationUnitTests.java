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
import SUT.SE61.Team07.Repository.DrugRepository;
import SUT.SE61.Team07.Entity.Drug;
 //////////////////////////////// all import //////////////////////////////

@RunWith(SpringRunner.class)
@DataJpaTest
public class Team07ApplicationUnitTests {
	
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
	public void testSetNameDrug(){
		Drug drug = new Drug("para1");
		try{
			entityManager.persist(drug);
			entityManager.flush();
	
			fail("drugname  must not be null to be valid");
		}
		catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}


}

