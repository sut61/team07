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
    private final TypeRepository typerepository;

    public DatabaseLoader(DrugRepository drugrepository, PrescriptionRepository prescriptionrepository,
            StaffRepository staffrepository, TypeRepository typerepository) {
        this.drugrepository = drugrepository;
        this.prescriptionrepository = prescriptionrepository;
        this.staffrepository = staffrepository;
        this.typerepository = typerepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        this.drugrepository.save(new Drug("para","hotheatd"));
    }
}