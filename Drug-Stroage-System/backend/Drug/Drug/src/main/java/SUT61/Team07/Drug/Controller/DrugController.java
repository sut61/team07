package SUT61.Team07.Drug.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import SUT61.Team07.Drug.Entity.Drug;
import SUT61.Team07.Drug.Repository.DrugRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
class CoolDrugController {
    private DrugRepository repository;

    public CoolDrugController(DrugRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cool-drug")
    public Collection<Drug> coolDrugs() {
        return repository.findAll().stream().filter(this::isCool).collect(Collectors.toList());
    }

    private boolean isCool(Drug drug) {
        return !drug.getName().equals("AMC Gremlin") &&
                !drug.getName().equals("Triumph Stag") &&
                !drug.getName().equals("Ford Pinto") &&
                !drug.getName().equals("Yugo GV");
    }
    


}