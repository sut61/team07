
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

class RecordDrugUseController {
    private RecordDrugUseRepository recordDrugUserepository;
    private CustomerRepository customerrepository;
    private DrugdataRepository drugdatarepository;
    private StaffRepository staffrepository;

    public RecordDrugUseController(RecordDrugUseRepository recordDrugUserepository,
     DrugdataRepository drugdatarepository, StaffRepository staffrepository,
            CustomerRepository customerrepository) {

        this.drugdatarepository = drugdatarepository;
        this.recordDrugUserepository = recordDrugUserepository;
        this.customerrepository = customerrepository;
        this.staffrepository = staffrepository;
    }

    @GetMapping("/RecordDrugUse-list")
    public Collection<RecordDrugUse> drugs() {
        return recordDrugUserepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/RecordDrugUse-insert/symptom/{symptom}/drugdataId/{drugdataId}/staffId/{staffId}/customerId/{customerId}")
    public ResponseEntity<Map<String, Object>> RedcordSumbit(@PathVariable("symptom") String symptom,
            @PathVariable("drugdataId") Long drugdataId, @PathVariable("staffId") Long staffId,
            @PathVariable("customerId") Long customerId) {
        try {

            Drugdata Dd = this.drugdatarepository.findByDrugdataId(drugdataId);
            Staff Ss = this.staffrepository.findByStaffId(staffId);
            Customer Cc = this.customerrepository.findByCustomerId(customerId);

            this.recordDrugUserepository.save(new RecordDrugUse(symptom, Dd, Ss, Cc));

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
