package SUT.SE61.Team07;

import SUT.SE61.Team07.Entity.*;
import SUT.SE61.Team07.Controller.*;
import SUT.SE61.Team07.Repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class DatabaseLoader implements ApplicationRunner {

    private final DrugRepository drugrepository;
    private final PrescriptionRepository prescriptionrepository;
    private final StaffRepository staffrepository;
    private final CategoryRepository categoryrepository;
    private final CustomerRepository customerrepository;
    private final InitialRepository initialrepository;
    private final BloodTypeRepository bloodTyperepository;
    private final GenderRepository genderrepository;
    private final DepartmentRepository departmentrepository;
    private final WorktimeRepository worktimerepository;
    private final MedicineRepository medicinerepository;
    private final DrugdataRepository drugdatarepository;
    private final ShowHrsRepository showHrsrepository;
    private final RecordDrugUseRepository recordDrugUserepository;

    public DatabaseLoader(DrugRepository drugrepository, PrescriptionRepository prescriptionrepository,
            StaffRepository staffrepository, CategoryRepository categoryrepository,
            CustomerRepository customerrepository, InitialRepository initialrepository,
            BloodTypeRepository bloodTyperepository, GenderRepository genderrepository,
            DepartmentRepository departmentrepository, WorktimeRepository worktimerepository,
            MedicineRepository medicinerepository, DrugdataRepository drugdatarepository,
            ShowHrsRepository showHrsrepository, RecordDrugUseRepository recordDrugUserepository) {
        this.drugrepository = drugrepository;
        this.prescriptionrepository = prescriptionrepository;
        this.staffrepository = staffrepository;
        this.categoryrepository = categoryrepository;
        this.customerrepository = customerrepository;
        this.initialrepository = initialrepository;
        this.bloodTyperepository = bloodTyperepository;
        this.genderrepository = genderrepository;
        this.departmentrepository = departmentrepository;
        this.worktimerepository = worktimerepository;
        this.medicinerepository = medicinerepository;
        this.drugdatarepository = drugdatarepository;
        this.showHrsrepository = showHrsrepository;
        this.recordDrugUserepository = recordDrugUserepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // pam
        this.departmentrepository.save(new Department("Maid"));
        this.departmentrepository.save(new Department("Messenger"));
        this.departmentrepository.save(new Department("Phamacist"));
        Department De1 = this.departmentrepository.findBydeptId(1L);
        // end pam
        /*
         * john db loader
         */
        this.drugrepository.save(new Drug("para", "hotheatd"));
        this.drugrepository.save(new Drug("para2", "aaaa"));
        this.drugrepository.save(new Drug("para3", "bbbb"));
        this.drugrepository.save(new Drug("para4", "cccc"));
        this.drugrepository.save(new Drug("para5", "dddd"));
        Drug D1 = this.drugrepository.findByDrugId(1L);
        this.categoryrepository.save(new Category("ABC1"));
        this.categoryrepository.save(new Category("ABC2"));
        this.categoryrepository.save(new Category("ABC3"));
        this.categoryrepository.save(new Category("ABC4"));
        this.categoryrepository.save(new Category("ABC5"));
        
        Category C1 = this.categoryrepository.findByCategoryId(1L);
        this.staffrepository.save(new Staff(De1,"Bancha", "john", "exx", "0802457192"));
        this.staffrepository.save(new Staff(De1,"Banchon", "Luy", "kk1234", "0900030004"));
        this.staffrepository.save(new Staff(De1,"warsom", "physics", "II", "0832781846"));
        this.staffrepository.save(new Staff(De1,"watsmon", "joy", "kkk", "0801231234"));
        this.staffrepository.save(new Staff(De1,"ahmouy", "mouy", "gg1234", "0960050004"));
        Staff S1 = this.staffrepository.findByStaffId(1L);
        this.prescriptionrepository.save(new Prescription("name1", D1, S1, C1));
        /* end john db loader */

        /* bow db loader */
        this.initialrepository.save(new Initial("Mr."));
        this.initialrepository.save(new Initial("Mrs."));
        this.initialrepository.save(new Initial("Miss."));
        Initial in1 = this.initialrepository.findByInitialId(1L);
        this.genderrepository.save(new Gender("None"));
        this.genderrepository.save(new Gender("Male"));
        this.genderrepository.save(new Gender("Female"));
        this.genderrepository.save(new Gender("Tom"));
        this.genderrepository.save(new Gender("Gay"));
        Gender ge1 = this.genderrepository.findByGenderId(1L);
        this.bloodTyperepository.save(new BloodType("A"));
        this.bloodTyperepository.save(new BloodType("B"));
        this.bloodTyperepository.save(new BloodType("O"));
        this.bloodTyperepository.save(new BloodType("AB"));
        BloodType blood1 = this.bloodTyperepository.findByBloodTypeId(1L);
        this.customerrepository.save(new Customer(in1, "name1", ge1, blood1, "5/7", "0651472525", "Tuntika", "12345")); // การกรอกข้อมูลในcustomer
        /* end bow db loader */

        /* pam dbloader */

        this.worktimerepository.save(new Worktime("9:00-12:00", 3));
        this.worktimerepository.save(new Worktime("13:00-17:00", 4));
        this.worktimerepository.save(new Worktime("17:00-22:00", 5));
        this.worktimerepository.save(new Worktime("9:00-17:00", 8));
        this.worktimerepository.save(new Worktime("9:00-22:00", 13));
        Worktime W1 = this.worktimerepository.findBytimeId(1L);
        this.showHrsrepository.save(new ShowHrs(De1, W1, S1));
        /* end pam dbloader */

        /* kan db loader */
        medicinerepository.save(new Medicine("danger"));
        Medicine M1 = this.medicinerepository.findBymedicineId(1L);
        this.drugdatarepository.save(new Drugdata("name1", D1, S1, C1, M1));
        /* end kan dbloader */

        /* frame db loader */
        Drugdata Dru1 = this.drugdatarepository.findByDrugdataId(1L);
        Customer Cu1 = this.customerrepository.findByCustomerId(1L);
        this.recordDrugUserepository.save(new RecordDrugUse("hothead", Dru1, S1, Cu1));

        /* end frame db loader */

    }
}