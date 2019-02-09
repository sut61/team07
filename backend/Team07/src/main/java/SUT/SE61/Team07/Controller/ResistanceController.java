
package SUT.SE61.Team07.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import SUT.SE61.Team07.Repository.*;
import SUT.SE61.Team07.Entity.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

class ResistanceController {
    private ResistanceRepository resistanceRepository;
    private RecordDrugUseRepository recordDrugUserepository;

    public ResistanceController(ResistanceRepository resistanceRepository,
            RecordDrugUseRepository recordDrugUserepository

    ) {

        this.resistanceRepository = resistanceRepository;
        this.recordDrugUserepository = recordDrugUserepository;

    }

    @GetMapping("/Resistance-list")
    public Collection<Resistance> res() {
        return resistanceRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("Resistance-Insert/RecordDrugUseId/{RecordDrugUseId}/result/{result}")
    public ResponseEntity<Map<String, Object>> RedcordSumbit(@PathVariable("RecordDrugUseId") Long RecordDrugUseId,
            @PathVariable("result") String result) {
        try {
            RecordDrugUse Rdu = this.recordDrugUserepository.findByRecordDrugUseId(RecordDrugUseId);
            this.resistanceRepository.save(new Resistance(Rdu, result));
            Map<String, Object> json = new HashMap<String, Object>();
            json.put("success", true);
            json.put("status", "save");
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("X-Fsl-Location", "/");
            headers.add("X-Fsl-Response-Code", "302");
            return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.OK));
        } catch (NullPointerException e) {
            Map<String, Object> json = new HashMap<String, Object>();
            System.out.println("Error Save CancelReservation");
            json.put("success", false);
            json.put("status", "save-false");
            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Type", "application/json; charset=UTF-8");
            headers.add("X-Fsl-Location", "/");
            headers.add("X-Fsl-Response-Code", "500");
            return (new ResponseEntity<Map<String, Object>>(json, headers, HttpStatus.INTERNAL_SERVER_ERROR));

        }
    }

}
