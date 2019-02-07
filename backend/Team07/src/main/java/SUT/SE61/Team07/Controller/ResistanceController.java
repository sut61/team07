
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
   /* private CustomerRepository customerrepository;
    private BloodTypeRepository bloodTypeRepository;
    private DrugRepository drugRepository;
    private DrugdataRepository drugdatarepository;
    private StaffRepository staffrepository;*/

    public ResistanceController( ResistanceRepository resistanceRepository,
                                    RecordDrugUseRepository recordDrugUserepository
                                    /*CustomerRepository customerrepository,
                                    BloodTypeRepository bloodTypeRepository,
                                    DrugRepository drugRepository,
                                    DrugdataRepository drugdatarepository, 
                                    StaffRepository staffrepository*/
                                   ) {

        this.resistanceRepository = resistanceRepository;
        this.recordDrugUserepository = recordDrugUserepository;
        /*this.customerrepository = customerrepository;
        this.bloodTypeRepository = bloodTypeRepository;
        this.drugRepository = drugRepository;
        this.drugdatarepository = drugdatarepository;
        this.staffrepository = staffrepository;*/
    }

    @GetMapping("/Resistance-list")
    public Collection<Resistance> res() {
        return resistanceRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("Resistance/{Resistance}/RecordDrugUseId/{RecordDrugUseId}/customerId/{customerId}/bloodTypeId/{bloodTypeId}/drugId/{drugId}/drugdataId/{drugdataId}/symptom/{symptom}/resist/{resist}/staffId/{staffId}")
    public ResponseEntity<Map<String, Object>> RedcordSumbit(   @PathVariable("RecordDrugUseId") Long recorddrugId,
                                                                /*@PathVariable("symptom") String symptom,
                                                                @PathVariable("drugdataId") Long drugdataId, 
                                                                @PathVariable("staffId") Long staffId,
                                                                @PathVariable("customerId") Long customerId,*/
                                                                @PathVariable("resist") String resist) {
        try {
            RecordDrugUse Rdu = this.recordDrugUserepository.findByRecordDrugUseId(recorddrugId);
            /*Drugdata        Dd  = this.drugdatarepository.findByDrugdataId(drugdataId);
            Staff           Ss  = this.staffrepository.findByStaffId(staffId);
            Customer        Cc  = this.customerrepository.findByCustomerId(customerId);*/

            this.resistanceRepository.save(new Resistance(Rdu,resist));

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
