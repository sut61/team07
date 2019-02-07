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
public class TestPrescription {
    @Autowired
    private PrescriptionRepository prescriptionrepository;
    @Autowired
    private DrugRepository drugrepository;
    @Autowired
    private StaffRepository staffrepository;
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

    // ทดสอบ save data Prescription ปกติ
    @Test
    public void testTestInsertPrescriptionDataSuccess() {
        Prescription mag = new Prescription();
        Drug D = this.drugrepository.findByDrugId(1L);
        Category C = this.categoryrepository.findByCategoryId(1L);
        Staff S = this.staffrepository.findByStaffId(1L);
        mag.setPreId("P12345678");
        mag.setDrug(D);
        mag.setCategory(C);
        mag.setStaff(S);
        mag.setDate(new Date());
        try {
            entityManager.persist(mag);
            entityManager.flush();
        } catch (javax.validation.ConstraintViolationException e) {
            System.out.println(e);
            fail("Should   not pass to this line");
        }
    }

    

}
