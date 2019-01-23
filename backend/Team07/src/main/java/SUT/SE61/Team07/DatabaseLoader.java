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
    private final CustomerRepository customerRepository;
    private final InitialRepository initialRepository;
    private final BloodTypeRepository bloodTypeRepository;
    private final GenderRepository genderRepository;

    public DatabaseLoader(DrugRepository drugrepository, PrescriptionRepository prescriptionrepository,
            StaffRepository staffrepository, CategoryRepository categoryrepository,CustomerRepository customerRepository, InitialRepository initialRepository,
            BloodTypeRepository bloodTypeRepository,GenderRepository genderRepository) {
        this.drugrepository = drugrepository;
        this.prescriptionrepository = prescriptionrepository;
        this.staffrepository = staffrepository;
        this.categoryrepository = categoryrepository;
        this.customerRepository = customerRepository;
        this.initialRepository = initialRepository;
        this.bloodTypeRepository = bloodTypeRepository;
        this.genderRepository = genderRepository;  
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
        
        initialRepository.save(new Initial("mr."));
        genderRepository.save(new Gender("MALE"));
        bloodTypeRepository.save(new BloodType("O"));
        
        /*Initial init1 = new Initial();
        init1.setInitialname("Mr.");
        initialRepository.save(init1);
        Initial init2 = new Initial();
        init2.setInitialname("Mrs.");
        initialRepository.save(init2);
        Initial init3 = new Initial();
        init3.setInitialname("Miss");
        initialRepository.save(init3);

        Gender g1 = new Gender();
        g1.setSex("None");
        genderRepository.save(g1);
        Gender g2 = new Gender();
        g2.setSex("Male");
        genderRepository.save(g2);
        Gender g3 = new Gender();
        g3.setSex("Female");
        genderRepository.save(g3);
        Gender g4 = new Gender();
        g4.setSex("Tom");
        genderRepository.save(g4);
        Gender g5 = new Gender();
        g5.setSex("Gay");
        genderRepository.save(g5);

        BloodType b1 = new BloodType();
        b1.setbloodTypename("A");
        bloodTypeRepository.save(b1);
        BloodType b2 = new BloodType();
        b2.setbloodTypename("B");
        bloodTypeRepository.save(b2);
        BloodType b3 = new BloodType();
        b3.setbloodTypename("O");
        bloodTypeRepository.save(b3);
        BloodType b4 = new BloodType();
        b4.setbloodTypename("AB");
        bloodTypeRepository.save(b4);
*/


        
    }
}