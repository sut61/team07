
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
class PrescriptionController {
    private PrescriptionRepository prescriptionrepository;
    private DrugRepository drugrepository;
    private StaffRepository staffrepository;
    private CategoryRepository categoryrepository;

    public PrescriptionController(PrescriptionRepository prescriptionrepository, DrugRepository drugrepository,
            StaffRepository staffrepository, CategoryRepository categoryrepository) {
        this.prescriptionrepository = prescriptionrepository;
        this.drugrepository = drugrepository;
        this.staffrepository = staffrepository;
        this.categoryrepository = categoryrepository;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/Stroage-prescription")
    public Collection<Prescription> prescriptions() {
        return prescriptionrepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/Prescription-insert/{id}/nameprescription/{nameprescription}")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<Map<String, Object>> Drugsumbit(@PathVariable("id") Long id,
            @PathVariable("nameprescription") String nameprescription) {
        try {
            Drug D = this.drugrepository.findByDrugId(id);
            Staff S = this.staffrepository.findByStaffId(id);
            Category C = this.categoryrepository.findByCategoryId(id);

            this.prescriptionrepository.save(new Prescription(nameprescription, D, S, C));

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
