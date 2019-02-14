
package SUT.SE61.Team07.Controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import SUT.SE61.Team07.Entity.*;
import SUT.SE61.Team07.Repository.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

class DrugController {
    private DrugRepository drugrepository;

    public DrugController(DrugRepository drugrepository) {
        this.drugrepository = drugrepository;
    }

    @GetMapping("/Stroage-drug")
    public Collection<Drug> drugs() {
        return drugrepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Drug/{drugId}")
    public Drug drugFind(@PathVariable("drugId") Long id) {
        return drugrepository.findByDrugId(id);
    }

    @PutMapping("/Drug-Update/{drugId}")
    public ResponseEntity<Object> updateStudent(@RequestBody Drug drug, @PathVariable long drugId) {
        Optional<Drug> drugOptional = this.drugrepository.findById(drugId);

        if (!drugOptional.isPresent())
            return ResponseEntity.notFound().build();

            drug.setDrugId(drugId);

            drugrepository.save(drug);

        return ResponseEntity.noContent().build();
    }

}
