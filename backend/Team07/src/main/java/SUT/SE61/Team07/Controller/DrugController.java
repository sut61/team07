package SUT.SE61.Team07.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import SUT.SE61.Team07.Entity.*;
import SUT.SE61.Team07.Repository.*;


@RestController
class DrugController {
    private DrugRepository drugrepository;

    public DrugController(DrugRepository drugrepository) {
        this.drugrepository = drugrepository;
    }

    @GetMapping("/Stroage-drug")
    public Collection<Drug> drugs() {
        return drugrepository.findAll().stream().collect(Collectors.toList());
    }

}
