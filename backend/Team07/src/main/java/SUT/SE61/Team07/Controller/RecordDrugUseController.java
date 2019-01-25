package SUT.SE61.Team07.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import SUT.SE61.Team07.Repository.*;
import SUT.SE61.Team07.Entity.*;

@RestController
class RecordDrugUseController {
    private RecordDrugUseRepository recordDrugUserepository;

    public RecordDrugUseController(RecordDrugUseRepository recordDrugUserepository) {
        this.recordDrugUserepository = recordDrugUserepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/RecordDrugUse-list")
    public Collection<RecordDrugUse> drugs() {
        return recordDrugUserepository.findAll().stream().collect(Collectors.toList());
    }






    
}
