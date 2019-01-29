
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
import java.util.Optional;
import java.util.stream.Collectors;
import SUT.SE61.Team07.Repository.*;
import SUT.SE61.Team07.Entity.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

class DrugdataController {

    private DrugRepository drugrepository;
    private DrugdataRepository drugdatarepository;
    private StaffRepository staffrepository;
    private MedicineRepository medicinerepository;
    private CategoryRepository categoryrepository;
    private CustomerRepository customerrepository;

    public DrugdataController(DrugdataRepository drugdatarepository, DrugRepository drugrepository,
            StaffRepository staffrepository, MedicineRepository medicinerepository,
            CategoryRepository categoryrepository, CustomerRepository customerrepository) {
        this.drugdatarepository = drugdatarepository;
        this.drugrepository = drugrepository;
        this.staffrepository = staffrepository;
        this.medicinerepository = medicinerepository;
        this.categoryrepository = categoryrepository;
        this.customerrepository = customerrepository;
    }

    @GetMapping("/Drugdata-list")
    public Collection<Drugdata> items() {
        return drugdatarepository.findAll();
    }

    @GetMapping("/Drugdata/{drugdataId}")
    public Drugdata DrugdataFinds(@PathVariable("drugdataId") Long drugdataId) {
        return drugdatarepository.findByDrugdataId(drugdataId);
    }

    @GetMapping("/Medicine")
    public Collection<Medicine> Medicine() {
        return medicinerepository.findAll();
    }

    @GetMapping("/Medicine/{medicineId}")
    public Optional<Medicine> takeinMedicineByid(@PathVariable Long medicineId) {
        return medicinerepository.findById(medicineId);
    }

    @PostMapping("/Drugdata-insert/detail/{detail}/drugId/{drugId}/staffId/{staffId}/categoryId/{categoryId}/medicineId/{medicineId}")
    public ResponseEntity<Map<String, Object>> Drugdatasumbit(@PathVariable("detail") String detail,
            @PathVariable("drugId") Long drugId, @PathVariable("staffId") Long staffId,
            @PathVariable("categoryId") Long categoryId, @PathVariable("medicineId") Long medicineId) {
        try {

            Drug D = this.drugrepository.findByDrugId(drugId);
            Staff S = this.staffrepository.findByStaffId(staffId);
            Category C = this.categoryrepository.findByCategoryId(categoryId);
            Medicine M = this.medicinerepository.findBymedicineId(medicineId);

            this.drugdatarepository.save(new Drugdata(detail, D, S, C, M));

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

    @PostMapping("/Medicine-insert/name/{name}")
    public ResponseEntity<Map<String, Object>> Medicinesumbit(@PathVariable("name") String name) {
        try {
            Medicine Me = new Medicine(name);
            this.medicinerepository.save(Me);
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