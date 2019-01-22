package SUT.SE61.Team07.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import SUT.SE61.Team07.Entity.*;
import SUT.SE61.Team07.Repository.*;


@RestController
class RecordDrugController {
    private RecordDrugRepository recordDrugrepository;

    public RecordDrugController(RecordDrugRepository recordDrugrepository) {
        this.recordDrugrepository = recordDrugrepository;
    }

    @GetMapping("/RecordDrug")
    public Collection<RecordDrug> drugs() {
        return recordDrugrepository.findAll().stream().collect(Collectors.toList());
    }



}
