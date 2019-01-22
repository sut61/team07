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

    public DatabaseLoader(DrugRepository drugrepository, PrescriptionRepository prescriptionrepository,
            StaffRepository staffrepository, CategoryRepository categoryrepository) {
        this.drugrepository = drugrepository;
        this.prescriptionrepository = prescriptionrepository;
        this.staffrepository = staffrepository;
        this.categoryrepository = categoryrepository;
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

        this.staffrepository.save(new Staff("Bancha","john","exx"));
        this.staffrepository.save(new Staff("Banchon","Luy","kk1234"));
        this.staffrepository.save(new Staff("warsom","physics","II"));
        this.staffrepository.save(new Staff("watsmon","joy","kkk"));
        this.staffrepository.save(new Staff("ahmouy","mouy","gg1234"));

        Staff S1 = this.staffrepository.findByStaffId(1L);



        this.prescriptionrepository.save(new Prescription("name1", D1, S1, C1));
        
    }
}