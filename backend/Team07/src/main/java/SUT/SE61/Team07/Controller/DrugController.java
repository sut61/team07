
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

    @PostMapping("/Drug-Update/{drugId}/name/{name}/price/{price}/qty/{qty}")
    public ResponseEntity<Map<String, Object>> drugUpdate(@PathVariable("drugId") Long drugId,
            @PathVariable("name") String name, @PathVariable("price") Integer price, @PathVariable("qty") Integer qty) {

        Drug drug = this.drugrepository.findByDrugId(drugId);

        if (drug != null) {
            try {

                drug.setDrugId(drugId);
                drug.setName(name);
                drug.setPrice(price);
                drug.setQty(qty);
                this.drugrepository.save(drug);
                Map<String, Object> json = new HashMap<String, Object>();
                json.put("success", true);
                json.put("status", "update complete");

                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/json; charset=UTF-8");
                headers.add("X-Fsl-Location", "/");
                headers.add("X-Fsl-Response-Code", "302");
                return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));


            } catch (NullPointerException e) {
                Map<String, Object> json = new HashMap<String, Object>();
                json.put("success", true);
                json.put("status", "save");

                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type", "application/json; charset=UTF-8");
                headers.add("X-Fsl-Location", "/");
                headers.add("X-Fsl-Response-Code", "302");
                return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
            }
        } else {
            Map<String, Object> json = new HashMap<String, Object>();
            json.put("success", true);
            json.put("status", "save");

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("X-Fsl-Location", "/");
            headers.add("X-Fsl-Response-Code", "302");
            return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
        }

        // if (!drugOptional.isPresent())
        // return ResponseEntity.notFound().build();

        // drug.setDrugId(drugId);

        // drugrepository.save(drug);

        // return ResponseEntity.noContent().build();

    }

}
