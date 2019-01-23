package SUT.SE61.Team07.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;
import SUT.SE61.Team07.Entity.*;
import SUT.SE61.Team07.Repository.*;


@RestController
class RecordDrugUseController {
    private RecordDrugUseRepository recordDrugUserepository;

    public RecordDrugUseController(RecordDrugUseRepository recordDrugUserepository) {
        this.recordDrugUserepository = recordDrugUserepository;
    }

    @GetMapping("/RecordDrugUse-list")
    public Collection<RecordDrugUse> drugs() {
        return recordDrugUserepository.findAll().stream().collect(Collectors.toList());
    }



}
