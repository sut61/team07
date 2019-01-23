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
    
    



    public DatabaseLoader(DrugRepository drugrepository, PrescriptionRepository prescriptionrepository,
            StaffRepository staffrepository, CategoryRepository categoryrepository,CustomerRepository customerrepository, InitialRepository initialrepository,
            BloodTypeRepository bloodTyperepository,GenderRepository genderrepository,DepartmentRepository departmentrepository,WorktimeRepository worktimerepository,MedicineRepository medicinerepository,DrugdataRepository drugdatarepository) {
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

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.drugrepository.save(new Drug("para","hotheatd"));
        this.drugrepository.save(new Drug("para2","aaaa"));
        this.drugrepository.save(new Drug("para3","bbbb"));
        this.drugrepository.save(new Drug("para4","cccc"));
        this.drugrepository.save(new Drug("para5","dddd"));
        Drug D1 = this.drugrepository.findByDrugId(1L);
         
        this.categoryrepository.save(new Category("ABC1"));
        this.categoryrepository.save(new Category("ABC2"));
        this.categoryrepository.save(new Category("ABC3"));
        this.categoryrepository.save(new Category("ABC4"));
        this.categoryrepository.save(new Category("ABC5")); 
        Category C1 = this.categoryrepository.findByCategoryId(1L);

        this.staffrepository.save(new Staff("Bancha","john","exx","0802457192"));
        this.staffrepository.save(new Staff("Banchon","Luy","kk1234","0900030004"));
        this.staffrepository.save(new Staff("warsom","physics","II","0832781846"));
        this.staffrepository.save(new Staff("watsmon","joy","kkk","0801231234"));
        this.staffrepository.save(new Staff("ahmouy","mouy","gg1234","0960050004"));

        Staff S1 = this.staffrepository.findByStaffId(1L);
        this.prescriptionrepository.save(new Prescription("name1", D1, S1, C1));
        
        initialrepository.save(new Initial("Mr."));
        initialrepository.save(new Initial("Mrs."));
        initialrepository.save(new Initial("Miss."));
    

        genderrepository.save(new Gender("None"));
        genderrepository.save(new Gender("Male"));
        genderrepository.save(new Gender("Female"));
        genderrepository.save(new Gender("Tom"));
        genderrepository.save(new Gender("Gay"));


        bloodTyperepository.save(new BloodType("A"));
        bloodTyperepository.save(new BloodType("B"));
        bloodTyperepository.save(new BloodType("O"));
        bloodTyperepository.save(new BloodType("AB"));

        departmentrepository.save(new Department("Maid"));
        departmentrepository.save(new Department("Messenger"));
        departmentrepository.save(new Department("Phamacist"));

        worktimerepository.save(new Worktime("9:00-12:00",3));
        worktimerepository.save(new Worktime("13:00-17:00",4));
        worktimerepository.save(new Worktime("17:00-22:00",5));
        worktimerepository.save(new Worktime("9:00-17:00",8));
        worktimerepository.save(new Worktime("9:00-22:00",13));


        // kan db loader
        medicinerepository.save(new Medicine("danger"));
        Medicine M1 = this.medicinerepository.findBymedicineId(1L);
        
        this.drugdatarepository.save(new Drugdata("name1","name2",D1,S1,C1,M1));




    }
}